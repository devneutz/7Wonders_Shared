package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;
import java.util.List;

import ch.fhnw.sevenwonders.interfaces.ILobby;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class Lobby implements ILobby {
	
	private String lobbyName;
	private IPlayer lobbyMaster;
	private ArrayList<IPlayer> lobbyPlayers;
	private int numPlayers;

	@Override
	public void startLobby(List<IPlayer> list) {
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}
	
	@Override
	public String getLobbyName() {
		return this.lobbyName;
	}
	
	@Override
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	
		
	public int getNumPlayers() {
		return numPlayers;
	}

	@Override
	public void setLobbyMaster(IPlayer lobbyMaster) {
		this.lobbyMaster = lobbyMaster;
	}

	@Override
	public IPlayer getLobbyMaster() {
		return this.lobbyMaster;
	}
	
	@Override
	public String toString() {
		return lobbyName;
	}

	public ArrayList<IPlayer> getLobbyPlayers() {
		return lobbyPlayers;
	}

	public void setLobbyPlayers(ArrayList<IPlayer> lobbyPlayers) {
		this.lobbyPlayers = lobbyPlayers;
	}
	
	
}
