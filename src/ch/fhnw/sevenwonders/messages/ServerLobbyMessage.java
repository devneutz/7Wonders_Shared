package ch.fhnw.sevenwonders.messages;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.*;

public class ServerLobbyMessage extends Message {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4046922165597357235L;
	
	private IPlayer player;
	private LobbyAction action;
	private ILobby lobby;
	private StatusCode statusCode;
	
	private ArrayList<IPlayer> opponents;
	
	public ArrayList<IPlayer> getOpponents(){
		return this.opponents;
	}
	
	public void setOpponents(ArrayList<IPlayer> inOpponents) {
		opponents.clear();
		this.opponents.addAll(inOpponents);
	}
	
	public ServerLobbyMessage(LobbyAction inAction) {
		this.action = inAction;
		this.opponents = new ArrayList<IPlayer>();
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
	
	public ILobby getLobby() {
		return this.lobby;
	}
	public void setLobby(ILobby inLobby) {
		this.lobby = inLobby;
	}
}
