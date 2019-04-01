package ch.fhnw.sevenwonders.interfaces;
import ch.fhnw.sevenwonders.enums.*;
import java.util.ArrayList;

public interface IPlayer {	
	
	// Methode zur Festlegung des Password Hash
	void setPasswordHash(String pwHash);
	
	// Methode zur Festlegung des Spielernamen
	void setName(String name);
	
	// Methode zum Auslesen des Spielernamen
	String getName();
	
	// Methode zum Auslesen der Ressourcen welche der Spieler zur Verf�gung hat
	ArrayList<ResourceType> getResource(ResourceType resource);
	
	// Methode zum Auslesen welches Board der Spieler nutzt
	IBoard getBoard();
	
	// Methode zur �berpr�fung ob das definierte Passwort g�ltig ist
	Boolean isPasswordValid();
	
	// ??Joel fragen was damit gemeint ist ?? Wieso als R�ckgabe boolean und nicht das Objekt Card ?
	Boolean getCardPlayed();
	
	// ??Joel fragen was damit gemeint ist ?? Wieso als Eingabe boolean und nicht das Objekt Card ?
	void setCardPlayed(Boolean cardPlayed);
	
	// Methode zum Hinzuf�gen des Spielers in die mitgegebene Lobby
	void joinLobby(String lobby); //-> ILobby muss noch erstellt werden, danach umbenenen !
	
	// Methode zur Erstellung der Lobby
	void creatLobby(String lobbyName);
	
	// Methode zur L�schung der mitgegebenen Lobby
	void deleteLobby (String lobby); //-> ILobby muss noch erstellt werden, danach umbenenen !
	
	// Methode zum Aussteigen aus einer Lobby
	void leaveLobby(String lobbyName);
	
	// Methode zum Vergleichen der Spieler in einem Spiel um zu identifizieren welcher Spieler gewonnen hat
	int compareTo(IPlayer player);	
	
}
