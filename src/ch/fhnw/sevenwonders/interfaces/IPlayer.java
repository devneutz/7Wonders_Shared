package ch.fhnw.sevenwonders.interfaces;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.models.Card;
import ch.fhnw.sevenwonders.models.Player;
import javafx.beans.property.IntegerProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public interface IPlayer extends Serializable, Comparable {

	// Ist der Benutzer authentifiziert? Sprich nach erfolgreichem Login der Fall
	boolean getIsAuthenticated();

	// Methode zur Festlegung des Password Hash
	void setPasswordHash(String pwHash);

	// gibt das gehashte Passwort zur�ck
	String getPassword();

	// Methode zur Festlegung des Spielernamen
	void setName(String name);

	// Methode zum Auslesen des Spielernamen
	String getName();

	ArrayList<ICard> getCardStack();
	
	void setCardStack(ArrayList<ICard> inStack);
	
	// provisorisch erstellt --> evtl. nicht ben�tigt
	ArrayList<ICard> getCards();

	void monetizeCard(ICard card);

	void playCard(ICard card);

	void useCardForBuilding(ICard card);

	// Methode zum Auslesen welches Board der Spieler nutzt
	IBoard getBoard();

	ILobby getLobby();

	void setLobby(ILobby inLobby);

	int getMilitaryWarPoints();

	void setMilitaryWarPoints(int militaryWarPoints);
	
	void addMilitaryWarPoints(int addValue);
	
	ArrayList<ResourceType> getCoinWallet();

	// finale Punktzahlberrechnung
	HashMap<String, Integer> evaluate();

	int evaluateVictoryCoin();

	int evaluateVictoryWonder();

	int evaluateVictoryDirect();

	int evaluateVictoryResearch();


	// listet alle verf�gbaren Ressourcen des Spielers auf (sowohl Board als auch
	// Cards)
	ArrayList<ResourceType> getPlayerResources();

	// listet alle verf�gbaren Ressourcen der gespielten Karten des Spielers
	ArrayList<ResourceType> getCardResources();
	
	void setCoinWallet(ArrayList<ResourceType> coinWallet);
	
	void setBoard(IBoard board);
	
	void setCards(ArrayList<ICard> cards);
	
	void militaryConflict(IPlayer neighbourLeft, IPlayer neighbourRight, Age age);
	
	void setHasPlayedCard(boolean inVal);
	 
	boolean getHasPlayedCard();
	
	int getMilitaryPoints();

	void addMilitaryPoint();
	
	void setMilitaryPoints(int militaryPoints);
	
	void addCoins(int amount);
	
	void payByCoins(int amount);
	

}
