package ch.fhnw.sevenwonders.messages;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.*;

public class ServerStartupMessage extends Message {

	private IPlayer player;
	private StartupAction action;
	private StatusCode statusCode;
	private ArrayList<ILobby> lobbies;
	
	public ServerStartupMessage(StartupAction inAction) {
		this.action = inAction;
	}
	
	@Override
	public void setPlayer(IPlayer inPlayer) {
		this.player = inPlayer;
	}
	
	public void setLobbies(ArrayList<ILobby> inLobbies) {
		this.lobbies = inLobbies;
	}
	
	public StartupAction getActionType() {
		return this.action;
	}
	
	public IPlayer getPlayer() {
		return this.player;
	}

	public StatusCode getStatusCode() {
		return this.statusCode;
	}
	
	public ArrayList<ILobby> getLobbies(){
		return this.lobbies;
	}
}
