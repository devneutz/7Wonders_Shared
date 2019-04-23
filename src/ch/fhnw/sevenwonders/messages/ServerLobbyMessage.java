package ch.fhnw.sevenwonders.messages;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.LobbyAction;
import ch.fhnw.sevenwonders.enums.StatusCode;
import ch.fhnw.sevenwonders.interfaces.ILobby;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ServerLobbyMessage extends Message {
	
	private IPlayer player;
	private LobbyAction action;
	private StatusCode statusCode;
	
	
	public ServerLobbyMessage(LobbyAction inAction) {
		this.action = inAction;
	}
	
	
	@Override
	public void setPlayer(IPlayer inPlayer) {
		// TODO Auto-generated method stub
		
	}


	public LobbyAction getAction() {
		return action;
	}


	public void setAction(LobbyAction action) {
		this.action = action;
	}


	public StatusCode getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}


	public IPlayer getPlayer() {
		return player;
	}

	
}
