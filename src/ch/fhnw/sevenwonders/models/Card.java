package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.Age;
import ch.fhnw.sevenwonders.enums.CardType;
import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;
import ch.fhnw.sevenwonders.interfaces.IBoard;
import ch.fhnw.sevenwonders.interfaces.ICard;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

/**
 * 
 * @author Matteo Farneti
 *
 */

public class Card implements ICard {

	private String name;
	private Age age;
	private CardType cardType;
	private int usedStartingFrom;
	private ValueCalculationType valueCalculationType;
	private ArrayList<ResourceType> value;
	private ArrayList<ResourceType> cost;
	private boolean usedForPyramid;
	private String imageName;
	
	static final long serialVersionUID = 12L;

	public Card(String name, Age age, CardType cardType, int usedStartingFrom,
			ValueCalculationType valueCalculationType, ArrayList<ResourceType> value, ArrayList<ResourceType> cost,
			boolean usedForPyramid, String imageName) {
		this.name = name;
		this.age = age;
		this.cardType = cardType;
		this.usedStartingFrom = usedStartingFrom;
		this.valueCalculationType = valueCalculationType;
		this.value = new ArrayList<ResourceType>();
		this.value.addAll(value);
		this.cost = new ArrayList<ResourceType>();
		this.cost.addAll(cost);
		this.usedForPyramid = usedForPyramid;
		this.imageName = imageName;
		
	}

	public String getName() {
		return name;
	}

	public Age getAge() {
		return age;
	}

	public CardType getCardType() {
		return cardType;
	}

	public int getUsedStartingFrom() {
		return usedStartingFrom;
	}

	public boolean getUsedForPyramid() {
		return usedForPyramid;
	}

	public ArrayList<ResourceType> getCost() {
		return cost;
	}

	public ArrayList<ResourceType> getValue() {
		return this.value;
	}

	/**
	 * Ueberprüft, ob die Kosten der Karte (ArrayList cost) mit den zur Verfuegung stehenden Resourcen gedeckt werden koennen.
	 * @author Ismael
	 */
	public boolean isPlayable(IPlayer p) {
		
		ArrayList<ResourceType> tempCardsAndValues = new ArrayList<ResourceType>();
		ArrayList<ICard> tempCardsOr = new ArrayList<ICard>();
		ArrayList<Boolean> costFound = new ArrayList<Boolean>();
		boolean playable = false;
		
		
		//alle Karten zuweisen
		for (int x = 0; x < p.getCards().size(); x++) {
			
			if (p.getCards().get(x).getValueCalculationType()== ValueCalculationType.Or) {
					tempCardsOr.add(p.getCards().get(x));
			} else {
					for(int y = 0; y < p.getCards().get(x).getValue().size(); y++) {
						tempCardsAndValues.add(p.getCards().get(x).getValue().get(y));
					}				
			}
			
		}
		
		//alle Boardressourcen zuweisen
		tempCardsAndValues.addAll(p.getBoard().getBoardResource());
			
		//alle Coins zuweisen
		tempCardsAndValues.addAll(p.getCoinWallet());
		
		
		
		//Überpruefungsliste ob allle Ressourcen gedeckt werden konnten
		for(int x = 0 ; x < this.cost.size(); x++){
			costFound.add(false);
		}
		
		//pruefen ob Resource vorhanden
		for (int x = 0; x < this.cost.size(); x++) {
			
			for(int y = 0; y < tempCardsAndValues.size(); y++) { 
				if(this.cost.get(x).equals(tempCardsAndValues.get(y))) { 
					tempCardsAndValues.remove(y);
					costFound.set(x, true);
					break;
				}
			}
			
				
			if (!costFound.get(x)){
				for (int y = 0; y < tempCardsOr.size(); y++) {
					for (int z = 0; z < tempCardsOr.get(y).getValue().size(); z++) {
						if (this.cost.get(x) == tempCardsOr.get(y).getValue().get(z)) { 
							tempCardsOr.remove(y);
							costFound.set(x, true);
							break;
						}
					}
				}
			}
			
		}
		
		
		if (costFound.contains(false)) {
			playable = false;
		} else { playable = true;
		}
		
		return playable;
	}

	public ValueCalculationType getValueCalculationType() {
		return valueCalculationType;
	}

	public String getImageName() {
		return imageName;
	}
}
