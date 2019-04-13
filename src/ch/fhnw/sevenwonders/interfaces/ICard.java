package ch.fhnw.sevenwonders.interfaces;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.Age;
import ch.fhnw.sevenwonders.enums.CardType;
import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;

public interface ICard {
	
	// Gibt das Zeitalter aus dem Enum "Age" zurück.
	Age getAge();
	
	// Gibt den Kartentyp aus dem Enum "CardType" zurück.
	CardType getCardType();
	
	// Wird die Karte zum Bau des Weltwunders verwendet?
	boolean getUsedForPyramid();
	
	// Gibt die Kosten einer bestimmten Karte zurück, welche in der Liste "ResourceType" gespeichert ist.
	ArrayList<ResourceType> getCost();
	
	// Gibt den Wert einer bestimmten Karte zurück, welche in der Liste "ResourceType" gespeichert ist.
	ArrayList<ResourceType> getValue();
	
	// Kann die gewünschte Karte gespielt werden bzw. sind genügend Resourcen vorhanden? Dieser Wert ist ebenfalls in der Liste "ResourceType" gespeichert.
	boolean isPlayable(ArrayList<ResourceType> array);
	
	// Gibt einen Wert aus dem enum "ValueCalculationType" zurück. Dieser Wert entscheidet wie die Resource zu zählen ist.
	ValueCalculationType getValueCalculationType();
	
	// Gibt den Namen der entsprechenden Resource zurück
	String getImageName();

}
