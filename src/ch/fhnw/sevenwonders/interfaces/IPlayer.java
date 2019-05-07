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

	// provisorisch erstellt --> evtl. nicht benötigt
	ArrayList<ICard> getCards();

	Card getSelectedCard();

	void monetizeCard(ICard card, IPlayer player);

	void playCard(ICard card, IPlayer player);

	void useCardForBuilding(ICard card, IPlayer player, IBoard board);

	// Methode zum Auslesen welches Board der Spieler nutzt
	IBoard getBoard();

	// Methode zur Überprüfung ob Karte gespielt wurde
	boolean getCardPlayed();

	ILobby getLobby();

	void setLobby(ILobby inLobby);

	int getMilitaryWarPoints();

	void setMilitaryWarPoints(int militaryWarPoints);

	ArrayList<ResourceType> getCoinWallet();

	void setCoinWallet(ArrayList<ResourceType> coinWallet);

	// Methode zur Festlegung das Karte gespielt wurde
	void setCardPlayed(Boolean cardPlayed);

	// Methode zum Vergleichen der Spieler in einem Spiel um zu identifizieren
	// welcher Spieler gewonnen hat
	int compareTo(IPlayer player);

	// finale Punktzahlberrechnung
	HashMap<String, Integer> evaluate();

	int evaluateVictoryCoin();

	int evaluateVictoryWonder();

	int evaluateVictoryDirect();

	int evaluateVictoryResearch();

	int evaluateVictoryTrade();

	int evaluateVictoryGuilds();

	// listet alle verfügbaren Ressourcen des Spielers auf (sowohl Board als auch
	// Cards)
	ArrayList<ResourceType> getPlayerResources();

	// listet alle verfügbaren Ressourcen der gespielten Karten des Spielers
	ArrayList<ResourceType> getCardResources();

}
