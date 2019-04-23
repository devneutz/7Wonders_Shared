package ch.fhnw.sevenwonders.messages;

import java.util.List;

import ch.fhnw.sevenwonders.enums.LobbyAction;
import ch.fhnw.sevenwonders.interfaces.ILobby;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ClientLobbyMessage extends Message {
	
	private IPlayer player;
	private LobbyAction action;
	private ILobby lobby;
	
	public ClientLobbyMessage(LobbyAction inAction) {
		this.action = inAction;
	}

	@Override
	public void setPlayer(IPlayer inPlayer) {
		// TODO Auto-generated method stub
		
	}
	
	public LobbyAction getActionType() {
		return this.action;
	}
	
	public ILobby getLobby() {
		return this.lobby;
	}
	
	

	public IPlayer getPlayer() {
		return player;
	}

	public String getPlayerName() {
		return player.getName();
	}
	
	public void setPlayerName(String name) {
		this.player.setName(name);
	}


	
}
