package ch.fhnw.sevenwonders.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.Age;
import ch.fhnw.sevenwonders.enums.CardType;
import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;
import ch.fhnw.sevenwonders.models.Card;

public interface ICard extends Serializable {
	
	// Gibt das Zeitalter aus dem Enum "Age" zur�ck.
	Age getAge();
	
	// Gibt den Kartentyp aus dem Enum "CardType" zur�ck.
	CardType getCardType();
	
	// Wird die Karte zum Bau des Weltwunders verwendet?
	boolean getUsedForPyramid();
	
	// Gibt die Kosten einer bestimmten Karte zur�ck, welche in der Liste "ResourceType" gespeichert ist.
	ArrayList<ResourceType> getCost();
	
	// Gibt den Wert einer bestimmten Karte zur�ck, welche in der Liste "ResourceType" gespeichert ist.
	ArrayList<ResourceType> getValue();
	
	// Kann die gew�nschte Karte gespielt werden bzw. sind gen�gend Resourcen vorhanden? Dieser Wert ist ebenfalls in der Liste "ResourceType" gespeichert.
	boolean isPlayable(IPlayer p);
	
	// Gibt einen Wert aus dem enum "ValueCalculationType" zur�ck. Dieser Wert entscheidet wie die Resource zu z�hlen ist.
	ValueCalculationType getValueCalculationType();
	
	// Gibt den Namen der entsprechenden Resource zur�ck
	String getImageName();

}
