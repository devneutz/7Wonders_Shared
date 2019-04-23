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
	private ILobby lobby;
	
	
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


	public ILobby getLobby() {
		return lobby;
	}


	public void setLobby(ILobby lobby) {
		this.lobby = lobby;
	}


	public IPlayer getPlayer() {
		return player;
	}

	
}
