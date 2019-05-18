package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;
import java.util.HashMap;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.*;

/**
 * 
 * @author Matteo Farneti, Ismael Liuzzi
 *
 */

public class Player implements IPlayer {

	private String passwordHash;
	private String nickname;
	private ILobby lobby;
	private int militaryWarPoints = 0;
	private ArrayList<ICard> cards;
	private ArrayList<ICard> CardStack;
	private IBoard board;
	private ArrayList<ResourceType> coinWallet;

	static final long serialVersionUID = 12L;

	public Player() {
		this.coinWallet = new ArrayList<ResourceType>();
		coinWallet.add(ResourceType.Coin);
		coinWallet.add(ResourceType.Coin);
		coinWallet.add(ResourceType.Coin);
	}

	@Override
	public void setPasswordHash(String pwHash) {
		this.passwordHash = pwHash;
	}

	@Override
	public String getPassword() {
		return this.passwordHash;
	}

	/**
	 * Ummuenzen der Karte, was dem Spieler 3 Coins bringt. Es findet keine Pruefung
	 * statt, da dies immer funktionieren muss.
	 * 
	 */
	public void monetizeCard(ICard card) {

		getCoinWallet().add(ResourceType.Coin);
		getCoinWallet().add(ResourceType.Coin);
		getCoinWallet().add(ResourceType.Coin);

		for (int i = 0; i < CardStack.size(); i++) {

			// Der Bildname ist immer eindeutig
			if (CardStack.get(i).getImageName().equals(card.getImageName())) {
				getCards().remove(i);
				break;
			}
		}
	}

	/**
	 * Wenn die gewünschte Karte gespielt wird, muss sie auch aus dem Kartendeck
	 * entfernt werden.
	 */
	public void playCard(ICard card) {
		if (card.isPlayable(this)) {

			for (int i = 0; i < CardStack.size(); i++) {
				if (CardStack.get(i) == card) {
					getCards().remove(i);
					break;
				}
			}
		}
	}
	/**
	 * Karte wird für den nächstmöglichen Weltwunderstufen-Bau verwendet.
	 */
	public void useCardForBuilding(ICard card) {

		if (board.canBuild(board.getNextStageToBuild(), getPlayerResources())) {

			int nextStage = board.getNextStageToBuild();
			if (nextStage == 1) {
				board.setStepOneBuilt(true);
				getPlayerResources().addAll(board.getStepOneValue());
			}
			if (nextStage == 2) {
				board.setStepTwoBuilt(true);
				getPlayerResources().addAll(board.getStepTwoValue());
			}
			if (nextStage == 3) {
				board.setStepThreeBuilt(true);
				getPlayerResources().addAll(board.getStepThreeValue());
			}

			for (int i = 0; i < CardStack.size(); i++) {
				if (CardStack.get(i) == card) {
					getCards().remove(i);
					break;
				}
			}
		}
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

	public int getMilitaryWarPoints() {
		return militaryWarPoints;
	}

	public void setMilitaryWarPoints(int militaryWarPoints) {
		this.militaryWarPoints += militaryWarPoints;
	}

	/**
	 * gibt alle Ressourcen der gespielten Karten aus
	 */
	public ArrayList<ResourceType> getCardResources() {
		ArrayList<ResourceType> cardResource = new ArrayList<ResourceType>();

		for (int x = 0; x < this.cards.size(); x++) {
			cardResource.addAll(this.cards.get(x).getValue());

		}
		return cardResource;
	}

	/**
	 * alle Ressourcen aus, die der Spieler zur Verfügung hat
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
			if (this.getCoinWallet().get(x).equals(ResourceType.Coin)) {
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

		for (int i = 0; i < this.getBoard().getBoardResource().size(); i++) {
			if (this.getBoard().getStepOneValue().get(i).equals(ResourceType.VictoryPoint)) {
				w++;
			}
		}
		return w;
	}

	/**
	 * Gibt die Gewinnpunkte aufgrund gespielter Profankarten an.
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
	 * Gibt die Gewinnpunkte aufgrund der Forschungsgebäude an
	 */
	@Override

	public int evaluateVictoryResearch() {
		int r = 0, tafel = 0, zirkel = 0, zahnrad = 0;

		// Zaehlen der verschiedenen Forschungssymbole
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

			default:
				break;
			}
		}

		// Punkte berechnung fuer gleiche Symbole
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(0, tafel);
		temp.add(1, zirkel);
		temp.add(2, zahnrad);
		for (int x = 0; x < temp.size(); x++) {

			switch (temp.get(x)) {

			case 0:
				break;

			case 1:
				r++;
				break;

			case 2:
				r = r + 4;
				break;

			case 3:
				r = r + 9;
				break;

			case 4:
				r = r + 16;
				break;
			}

		}

		// Punkteberechnung für Paket an 3 verschiedenen Symbolen
		while (tafel != 0 && zirkel != 0 && zahnrad != 0) {
			r = r + 7;
			tafel--;
			zirkel--;
			zahnrad--;
		}
		return r;
	}

	/**
	 * Gibt alle Siegpunkte eines Spielers zurück
	 */
	public HashMap<String, Integer> evaluate() {

		HashMap<String, Integer> winPoints = new HashMap<String, Integer>();

		winPoints.put("Militärkonflikt", this.getMilitaryWarPoints());
		winPoints.put("Coins", this.evaluateVictoryCoin());
		winPoints.put("Weltwunder", this.evaluateVictoryWonder());
		winPoints.put("Profanbauten", this.evaluateVictoryDirect());
		winPoints.put("Forschungsgebäude", this.evaluateVictoryResearch());
		winPoints.put("TOTAL", (this.getMilitaryWarPoints() + this.evaluateVictoryCoin() + this.evaluateVictoryWonder()
				+ this.evaluateVictoryDirect() + this.evaluateVictoryResearch()));

		return winPoints;
	}

	@Override
	public String toString() {
		return this.nickname;
	}

	public void setCards(ArrayList<ICard> cards) {
		this.cards = cards;
	}

	public void setBoard(IBoard board) {
		this.board = board;
	}

	public void setCoinWallet(ArrayList<ResourceType> coinWallet) {
		this.coinWallet = coinWallet;
	}

}