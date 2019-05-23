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
	private int militaryPoints = 0;
	private ArrayList<ICard> cards;
	private ArrayList<ICard> CardStack;
	private IBoard board;
	private ArrayList<ResourceType> coinWallet;
	
	private boolean hasPlayedCard;

	static final long serialVersionUID = 12L;

	public Player() {
		this.coinWallet = new ArrayList<ResourceType>();
		coinWallet.add(ResourceType.Coin);
		coinWallet.add(ResourceType.Coin);
		coinWallet.add(ResourceType.Coin);
		
		this.cards = new ArrayList<ICard>();
		this.CardStack = new ArrayList<ICard>();
	}

	@Override
	public void setPasswordHash(String pwHash) {
		this.passwordHash = pwHash;
	}

	@Override
	public String getPassword() {
		return this.passwordHash;
	}
	
	public boolean getHasPlayedCard() {
		return this.hasPlayedCard;
	}
	
	public void setHasPlayedCard(boolean inVal) {
		this.hasPlayedCard = inVal;
	}

	/**
	 * @author Matteo Farneti
	 * Ummuenzen der Karte, was dem Spieler 3 Coins bringt. Es findet keine Pruefung
	 * statt, da dies immer funktionieren muss.	 * 
	 */
	public void monetizeCard(ICard card) {

		addCoin();
		addCoin();
		addCoin();

		for (int i = 0; i < CardStack.size(); i++) {
			// Der Bildname ist immer eindeutig
			if (CardStack.get(i).getImageName().equals(card.getImageName())) {
				this.CardStack.remove(i);
				break;
			}
		}
	}

	/**
	 *@author Ismael
	 * Wenn die gewuenschte Karte gespielt wird, muss sie auch aus dem Kartendeck
	 * entfernt werden.
	 */
	public void playCard(ICard card) {
		if (card.isPlayable(this)) {
			for (int i = 0; i < this.CardStack.size(); i++) {
				if (CardStack.get(i).getImageName().equals(card.getImageName())) {
					this.CardStack.remove(i);
					
					//Falls die gespielte Kart Muenzen als Value hat
					this.addCoins(card.destroyCoins());
					
					//Wenn Karte Coins zum spielen benoetigt
					for (int x = 0; x < card.getCost().size(); x++) {
						if (card.getCost().get(x)==ResourceType.Coin) {
							this.payByCoins(1);
						}
					}
					
					// MilitaryPoints raufzaehlen
					for (int x = 0; x < card.getValue().size(); x++) {
						if (card.getValue().get(x)==ResourceType.MilitaryMight){
							this.addMilitaryPoint();
						}
					}
					
					this.cards.add(card);
								
						
					break;
				
				}
			}	
		}
	}
	/**
	 * @author Ismael
	 * Karte wird für den naechstmoeglichen Weltwunderstufen-Bau verwendet.
	 */
	public void useCardForBuilding(ICard card) {
	
		if (this.board.canBuild(this)) {
			switch(this.board.getNextStageToBuild()) {
			
			case 1: board.setStepOneBuilt(true);
					this.board.addBoardResource(this.board.getStepOneValue());
					for (int x = 0; x < this.board.getStepOneValue().size(); x++) {
						if (this.board.getStepOneValue().get(x)==ResourceType.MilitaryMight){
							this.addMilitaryPoint();
						}
					}
					break;
				
			case 2: board.setStepTwoBuilt(true);
					this.board.addBoardResource(this.board.getStepTwoValue());
					for (int x = 0; x < this.board.getStepTwoValue().size(); x++) {
						if (this.board.getStepTwoValue().get(x)==ResourceType.MilitaryMight){
							this.addMilitaryPoint();
						}
					}
					break;
			
			case 3: board.setStepThreeBuilt(true);
					this.board.addBoardResource(this.board.getStepThreeValue());
					for (int x = 0; x < this.board.getStepThreeValue().size(); x++) {
						if (this.board.getStepThreeValue().get(x)==ResourceType.MilitaryMight){
							this.addMilitaryPoint();
						}
					}
					break;
					
			}
			
			//Falls das gebaute Weltwunder Muenzen als Value gibt
			this.addCoins(board.destroyCoins());
			
			//Karte entfernen
			for (int i = 0; i < CardStack.size(); i++) {
				if (CardStack.get(i).getImageName().equals(card.getImageName())) {
					this.CardStack.remove(i);
					break;
				}
			}
		}
	}

	public ArrayList<ICard> getCards() {
		return this.cards;
	}

	public void setCards(ArrayList<ICard> cards) {
		this.cards.clear();
		this.cards.addAll(cards);
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
	
	public void setCardStack(ArrayList<ICard> inCards) {
		this.CardStack.clear();
		this.CardStack.addAll(inCards);
	}

	@Override
	public IBoard getBoard() {
		return board;
	}
	
	/**
	 * Vergleicht die Spieler anhand Ihrem Punktetotal
	 * @author Ismael
	 */ 
	public int compareTo(IPlayer player) {
		int comp = (this.evaluate().get("TOTAL") - player.evaluate().get("TOTAL"));
		
		if (comp > 0) {
			return 1;
		}
		
		else if (comp < 0) {
			return -1;
		}
		
		else {
			return 0;
		}
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
	
	public void addCoin() {
		this.coinWallet.add(ResourceType.Coin);
	}
	/**
	 * Coins erhalten durch bspw. Ummuenzen
	 * @author Ismael
	 */
	public void addCoins(int amount) {
		for (int x = 0; x < amount; x++) {
			this.coinWallet.add(ResourceType.Coin);
		}
	}
	
	/**
	 * Bezahlen mit Coins bspw. beim Erwerb von Karten
	 * @author Ismael
	 */
	public void payByCoins(int amount) {
		for (int x = 0; x < amount; x++) {
			this.coinWallet.remove(this.coinWallet.size()-1);
		}
		
	}
		

	public int getMilitaryWarPoints() {
		return militaryWarPoints;
	}
	
	
	public void addMilitaryWarPoints(int addValue) {
		this.militaryWarPoints += addValue;
	}
	
	public void setMilitaryWarPoints(int militaryWarPoints) {
		this.militaryWarPoints = militaryWarPoints;
	}
	
	public int getMilitaryPoints() {
		return militaryPoints;
	}
	
	public void setMilitaryPoints(int militaryPoints) {
		this.militaryPoints = militaryPoints;
	}
	
	public void addMilitaryPoint() {
		this.militaryPoints ++;
	}

	/**
	 * @author Ismael
	 * gibt alle Ressourcen der gespielten Karten aus, nicht beachtung von OR oder AND type
	 */
	public ArrayList<ResourceType> getCardResources() {
		ArrayList<ResourceType> cardResource = new ArrayList<ResourceType>();

		for (int x = 0; x < this.cards.size(); x++) {
			cardResource.addAll(this.cards.get(x).getValue());

		}
		return cardResource;
	}

	/**
	 * @author Ismael
	 * alle Ressourcen aus, die der Spieler zur Verfuegung hat (ohne Beachtung OR and AND Karten)
	 */
	public ArrayList<ResourceType> getPlayerResources() {
		ArrayList<ResourceType> allResources = new ArrayList<ResourceType>();

		allResources.addAll(this.getCardResources());
		allResources.addAll(this.getBoard().getBoardResource());

		return allResources;
	}

	public void setBoard(IBoard board) {
		this.board = board;
	}

	/**
	 * @author Ismael
	 * fuehrt den Militaerkampf fuer den aufgerufenen Spieler aus. Setzt seine MilitaryWarPoints dementsprechend
	 */
	public void militaryConflict(IPlayer neighbourLeft, IPlayer neighbourRight, Age age) {
		int thisM = this.militaryPoints, leftM = neighbourLeft.getMilitaryPoints(), rightM = neighbourRight.getMilitaryPoints(), result = 0;
		
		// Vergleichen der Staerken resp. Kampf mit links
		if (thisM-leftM < 0) {
			result--;
		} else if (thisM-leftM > 0) {
			if(age == Age.AgeI) {
				result++;
			} else {
				result += 3;
			}
		}
		
		//Vergleichen der Staerken resp Kampf mit rechts
		if (thisM-rightM < 0) {
			result--;
		} else if (thisM-rightM > 0) {
			if(age == Age.AgeI) {
				result++;
			} else {
				result += 3;
			}
		}
		
		
		//MilitaryWarPoints setzen
		this.militaryWarPoints = (this.militaryWarPoints + result);
		
		}

	/**
	 * @author Ismael
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
	 * @author Ismael
	 * Gibt die Gewinnpunkte aufgrund der Weltwunderbauten an
	 */
	@Override
	public int evaluateVictoryWonder() {
		int w = 0;
	
		for (int i = 0; i < this.getBoard().getBoardResource().size(); i++) {
			if (this.getBoard().getBoardResource().get(i).equals(ResourceType.VictoryPoint)) {
				w++;
			}
		}
		return w;
	}

	/**
	 * @author Ismael
	 * Gibt die Gewinnpunkte aufgrund gespielter Profankarten an
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
	 * @author Ismael
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
	 * @author Ismael
	 * Gibt alle Siegpunkte eines Spielers zurueck
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return compareTo((IPlayer)o);
	}
	
}