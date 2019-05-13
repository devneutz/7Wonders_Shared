package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.Age;
import ch.fhnw.sevenwonders.enums.CardType;
import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;
import ch.fhnw.sevenwonders.interfaces.ICard;

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

	public Card(String name, Age age, CardType cardType, int usedStartingFrom,
			ValueCalculationType valueCalculationType, ArrayList<ResourceType> value, ArrayList<ResourceType> cost,
			boolean usedForPyramid, String imageName) {
		this.name = name;
		this.age = age;
		this.cardType = cardType;
		this.usedStartingFrom = usedStartingFrom;
		this.valueCalculationType = valueCalculationType;
		this.value = value;
		this.cost = cost;
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
		return value;
	}

	// Überprüft, ob die Kosten der Karte (ArrayList cost) mit den zur Verfügung
	// stehenden Resourcen gedeckt werden können.
	public boolean isPlayable(ArrayList<ICard> availableCards) {
		ArrayList<ICard> tempCardsAnd = new ArrayList<ICard>(availableCards.size());
		ArrayList<ICard> tempCardsOr = new ArrayList<ICard>(availableCards.size());
		ArrayList<ICard> tempCardsNull = new ArrayList<ICard>(availableCards.size());
		ArrayList<ResourceType> tempCardsAndValues = new ArrayList<ResourceType>();

		for (ICard c : availableCards) {
			if (c.getValueCalculationType() == ValueCalculationType.And) {
				tempCardsAnd.add(c);
			}
			if (c.getValueCalculationType() == ValueCalculationType.Or) {
				tempCardsOr.add(c);
			}
			if (c.getValueCalculationType() == null) {
				tempCardsNull.add(c);
			}
		}
		for (int c = 0; c < tempCardsAnd.size(); c++) {
			for (ResourceType rt : tempCardsAnd.get(c).getValue()) {
				tempCardsAndValues.add(rt);
			}
		}

		int numResults = this.getCost().size();
		
		if (numResults > 0) {
			for (int i = 0; i < this.getCost().size(); i++) {
				for (int m = 0; m < tempCardsNull.size(); m++) {
					if (this.getCost().get(i).equals(tempCardsNull.get(m).getValue().get(0))) {
						tempCardsNull.remove(m);
						numResults--;
					}
				}
			}
		}
		if (numResults > 0) {
			for (int i = 0; i < this.getCost().size(); i++) {
				for (int k = 0; k < tempCardsAndValues.size(); k++) {
					if (this.getCost().get(i).equals(tempCardsAndValues.get(k))) {
						tempCardsAndValues.remove(k);
						numResults--;
					}
				}
			}
		}
		if (numResults > 0) {
			for (int i = 0; i < this.getCost().size(); i++) {
				for (int j = 0; j < tempCardsOr.size(); j++) {
					for (int l = 0; l < tempCardsOr.get(j).getValue().size(); l++) {
						if (this.getCost().get(i).equals(tempCardsOr.get(j).getValue().get(l))) {
							tempCardsOr.remove(j);
							numResults--;
						}
					}
				}
			}
		}
		if (numResults == 0) {
			return true;
		} else {
			return false;
		}
	}

	public ValueCalculationType getValueCalculationType() {
		return valueCalculationType;
	}

	public String getImageName() {
		return imageName;
	}
}
