package ch.fhnw.sevenwonders.interfaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface ILobby extends Serializable {
		
		// startet die Lobby mit den angehörigen Playern als Liste.  
		void startLobby(List<IPlayer> list);
		
		void setLobbyName (String name);
		
		String getLobbyName();
		
		void setNumPlayers(int numPlayers);
		
		IPlayer getLobbyMaster();
		
		void setLobbyMaster(IPlayer inPlayer);
		
		int getNumPlayers();
		
		ArrayList<IPlayer> getLobbyPlayers();
		
		void addPlayer(IPlayer inPlayer);
		void removePlayer(IPlayer inPlayer);
}
