package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.*;

/**
 * 
 * @author Matteo Farneti, Ismael Liuzzi
 *
 */

public class Player implements IPlayer {

	private transient final Logger logger = Logger.getLogger("");
	private String passwordHash;
	private String nickname;
	private ILobby lobby;
	private int militaryWarPoints = 0;
	private ArrayList<ICard> cards;
	private ArrayList<ICard> CardStack;
	private IBoard board;
	private boolean cardPlayed;
	private Card selectedCard;
	private ArrayList<ResourceType> coinWallet;

	static final long serialVersionUID = 12L;

	@Override
	public void setPasswordHash(String pwHash) {
		this.passwordHash = pwHash;
	}

	@Override
	public String getPassword() {
		return this.passwordHash;
	}

	public void monetizeCard(ICard card, IPlayer player) {

		player.getCoinWallet().add(ResourceType.Coin);
		player.getCoinWallet().add(ResourceType.Coin);
		player.getCoinWallet().add(ResourceType.Coin);

		player.setCardPlayed(true);

		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i) == card) {
				player.getCards().remove(i);
				break;
			}
		}
	}

	public void playCard(ICard card, IPlayer player) {

		if (card.isPlayable(player.getPlayerResources())) {

			if (card.getCardType().equals(CardType.CivilianStructures)
					|| card.getCardType().equals(CardType.ManufacturedGoods)
					|| card.getCardType().equals(CardType.RawMaterials)
					|| card.getCardType().equals(CardType.ScientificStructures)) {

				player.getPlayerResources().addAll(card.getValue());

			}

			if (card.getCardType().equals(CardType.CommercialStructures)) {
				for (int i = 0; i < card.getValue().size(); i++) {
					if (card.getValue().get(i).equals(ResourceType.Coin)) {

						player.getCoinWallet().add(ResourceType.Coin);
					}
					if (card.getValue().get(i).equals(ResourceType.Clay)
							|| card.getValue().get(i).equals(ResourceType.Cloth)
							|| card.getValue().get(i).equals(ResourceType.Compasses)
							|| card.getValue().get(i).equals(ResourceType.GearWheel)
							|| card.getValue().get(i).equals(ResourceType.Glas)
							|| card.getValue().get(i).equals(ResourceType.Ore)
							|| card.getValue().get(i).equals(ResourceType.Papyrus)
							|| card.getValue().get(i).equals(ResourceType.Stone)
							|| card.getValue().get(i).equals(ResourceType.StonePanel)
							|| card.getValue().get(i).equals(ResourceType.Wood)
							|| card.getValue().get(i).equals(ResourceType.VictoryPoint)) {

						player.getPlayerResources().addAll(card.getValue());

					}
				}
			}
			if (card.getCardType().equals(CardType.MilitaryStructures)) {

				int mwp = card.getValue().size();
				player.setMilitaryWarPoints(mwp);
			}

			player.setCardPlayed(true);

			for (int i = 0; i < cards.size(); i++) {
				if (cards.get(i) == card) {
					player.getCards().remove(i);
					break;
				}
			}
		}
	}

	public void useCardForBuilding(ICard card, IPlayer player, IBoard board) {

		if (board.canBuild(board.getNextStageToBuild(), player.getPlayerResources())) {

			int nextStage = board.getNextStageToBuild();
			if (nextStage == 1) {
				board.setStepOneBuilt(true);
				player.getPlayerResources().addAll(board.getStepOneValue());
			}
			if (nextStage == 2) {
				board.setStepTwoBuilt(true);
				player.getPlayerResources().addAll(board.getStepTwoValue());
			}
			if (nextStage == 3) {
				board.setStepThreeBuilt(true);
				player.getPlayerResources().addAll(board.getStepThreeValue());
			}
			player.setCardPlayed(true);

			for (int i = 0; i < cards.size(); i++) {
				if (cards.get(i) == card) {
					player.getCards().remove(i);
					break;
				}
			}
		}
	}

	public Card getSelectedCard() {
		return this.selectedCard;
	}

	public ArrayList<ICard> getCards() {
		return this.cards;
	}

	@Override
	public void setName(String name) {
		this.nickname = name;
	}

	@Override
	public String getName() {
		return this.nickname;
	}

	public ArrayList<ICard> getCardStack() {
		return this.CardStack;
	}

	@Override
	public IBoard getBoard() {
		return board;
	}

	@Override
	public boolean getCardPlayed() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setCardPlayed(Boolean cardPlayed) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(IPlayer player) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getIsAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ILobby getLobby() {
		return this.lobby;
	}

	@Override
	public void setLobby(ILobby inLobby) {
		this.lobby = inLobby;
	}

	public ArrayList<ResourceType> getCoinWallet() {
		return coinWallet;
	}

	public void setCoinWallet(ArrayList<ResourceType> coinWallet) {
		this.coinWallet = coinWallet;
	}

	public int getMilitaryWarPoints() {
		return militaryWarPoints;
	}

	public void setMilitaryWarPoints(int militaryWarPoints) {
		this.militaryWarPoints += militaryWarPoints;
	}

	/**
	 *  gibt alle Ressourcen der gespielten Karten aus
	 */
	public ArrayList<ResourceType> getCardResources() {
		ArrayList<ResourceType> cardResource = new ArrayList<ResourceType>();

		for (int x = 0; x < this.cards.size(); x++) {
			cardResource.addAll(this.cards.get(x).getValue());

		}
		return cardResource;
	}

	/**
	 *  alle Ressourcen aus, die der Spieler zur Verf�gung hat
	 */
	public ArrayList<ResourceType> getPlayerResources() {
		ArrayList<ResourceType> allResources = new ArrayList<ResourceType>();

		allResources.addAll(this.getCardResources());
		allResources.addAll(this.getBoard().getBoardResource());

		return allResources;
	}
	
	/**
	 * Gibt die Gewinnpunkte aufgrund der Coins an
	 */
	@Override
	public int evaluateVictoryCoin() {
		int c = 0;
		for (int x = 0; x < this.getCoinWallet().size(); x++) {
			if (this.getCoinWallet().get(x) == ResourceType.Coin) {
				c++;
			}
		}
		return c / 3;
	}

	/**
	 * Gibt die Gewinnpunkte aufgrund der Weltwunderbauten an
	 */
	@Override
	public int evaluateVictoryWonder() {
		int w = 0;
		for (int x = 0; x < this.getBoard().getBoardResource().size(); x++) {
			if (this.getBoard().getBoardResource().get(x) == ResourceType.VictoryPoint) {
				w++;
			}
		}

		return w;
	}
	
	/**
	 * Gibt die Gewinnpunkte aufgrund gespielter PRofankarten an
	 */
	@Override
	public int evaluateVictoryDirect() {
		int d = 0;

		for (int x = 0; x < this.getCardResources().size(); x++) {
			if (this.getCardResources().get(x) == ResourceType.VictoryPoint) {
				d++;
			}
		}
		return d;
	}

	
	/**
	 * Gibt die Gewinnpunkte aufgrund der Forschungsgeb�ude an
	 */
	@Override
	
	public int evaluateVictoryResearch() {
		int r = 0, tafel = 0, zirkel = 0, zahnrad = 0;
		
		
		// Z�hlen der verschiedenen Forschungssymbole
		for (int x = 0; x < this.getPlayerResources().size(); x++) {
			switch (this.getPlayerResources().get(x)) {

			case GearWheel:
				zahnrad++;
				break;

			case StonePanel:
				tafel++;
				break;

			case Compasses:
				zirkel++;
				break;
			}
		}
		
		//Punkte berechnung f�r gleiche Symbole
		ArrayList <Integer> temp = new ArrayList <Integer>();
		temp.add(0, tafel);
		temp.add(1, zirkel);
		temp.add(2, zahnrad);
		for (int x = 0; x < temp.size(); x++)	{
			
			switch (temp.get(x)) {

			case 0: break;

			case 1:
				r++;
				break;

			case 2:
				r=r+4;
				break;
				
			case 3:
				r=r+9;
				break;
				
			case 4:
				r=r+16;
				break;
			}
			
		}
		
		
		//Punkteberechnung f�r Paket � 3verschiedenen Sympbolen
		while (tafel != 0 && zirkel !=0  && zahnrad != 0) {
			r++;
			tafel --;
			zirkel--;
			zahnrad--;
		}
	
				
		return r;
	}

	/**
	 * Gibt alle Siegpunkte eines Spielers zur�ck
	 */
	public HashMap<String, Integer> evaluate() {

		HashMap<String, Integer> winPoints = new HashMap<String, Integer>();

		winPoints.put("Milit�rkonflikt", this.getMilitaryWarPoints());
		winPoints.put("Coins", this.evaluateVictoryCoin());
		winPoints.put("Weltwunder", this.evaluateVictoryWonder());
		winPoints.put("Profanbauten", this.evaluateVictoryDirect());
		winPoints.put("Forschungsgeb�ude", this.evaluateVictoryResearch());
		winPoints.put("TOTAL", (this.getMilitaryWarPoints()+this.evaluateVictoryCoin()+this.evaluateVictoryWonder()+this.evaluateVictoryDirect()+this.evaluateVictoryResearch()));
	

		return winPoints;
	}
}