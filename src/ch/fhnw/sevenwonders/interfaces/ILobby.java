package ch.fhnw.sevenwonders.interfaces;

import java.io.Serializable;
import java.util.List;

public interface ILobby extends Serializable {
		
		// startet die Lobby mit den angehörigen Playern als Liste.  
		void startLobby(List<IPlayer> list);

}
