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
	
	public void setLobbyName(String lobbyName) {
		this.lobbyName = lobbyName;
	}
	
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	
	public void setLobbyMaster(IPlayer lobbyMaster) {
		this.lobbyMaster = lobbyMaster;
	}
}
