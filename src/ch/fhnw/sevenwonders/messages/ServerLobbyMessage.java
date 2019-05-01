package ch.fhnw.sevenwonders.messages;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.*;

public class ServerLobbyMessage extends Message {
	
	private IPlayer player;
	private LobbyAction action;
	private StatusCode statusCode;
	
	
	public ServerLobbyMessage(LobbyAction inAction) {
		this.action = inAction;
	}	
	
	@Override
	public void setPlayer(IPlayer inPlayer) {
		this.player = inPlayer;		
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
