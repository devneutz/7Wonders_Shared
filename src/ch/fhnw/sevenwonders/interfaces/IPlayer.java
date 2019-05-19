package ch.fhnw.sevenwonders.interfaces;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.models.Card;
import ch.fhnw.sevenwonders.models.Player;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public interface IPlayer extends Serializable {

	// Ist der Benutzer authentifiziert? Sprich nach erfolgreichem Login der Fall
	boolean getIsAuthenticated();

	// Methode zur Festlegung des Password Hash
	void setPasswordHash(String pwHash);

	// gibt das gehashte Passwort zurück
	String getPassword();

	// Methode zur Festlegung des Spielernamen
	void setName(String name);

	// Methode zum Auslesen des Spielernamen
	String getName();

	ArrayList<ICard> getCardStack();
	
	void setCardStack(ArrayList<ICard> inStack);
	
	// provisorisch erstellt --> evtl. nicht benötigt
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

	ArrayList<ResourceType> getCoinWallet();

	// Methode zum Vergleichen der Spieler in einem Spiel um zu identifizieren
	// welcher Spieler gewonnen hat
	int compareTo(IPlayer player);

	// finale Punktzahlberrechnung
	HashMap<String, Integer> evaluate();

	int evaluateVictoryCoin();

	int evaluateVictoryWonder();

	int evaluateVictoryDirect();

	int evaluateVictoryResearch();


	// listet alle verfügbaren Ressourcen des Spielers auf (sowohl Board als auch
	// Cards)
	ArrayList<ResourceType> getPlayerResources();

	// listet alle verfügbaren Ressourcen der gespielten Karten des Spielers
	ArrayList<ResourceType> getCardResources();
	
	void setCoinWallet(ArrayList<ResourceType> coinWallet);
	
	void setBoard(IBoard board);
	
	void setCards(ArrayList<ICard> cards);
	
	public void militaryConflict(IPlayer neighbourLeft, IPlayer neighbourRight, Age age);
	
	void setHasPlayedCard(boolean inVal);
	 
	boolean getHasPlayedCard();

}
