package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;
import java.util.logging.Logger;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.*;

public class Player implements IPlayer {

	private transient final Logger logger = Logger.getLogger("");
	private String passwordHash;
	private String nickname;
	
	static final long serialVersionUID = 12L;
	
	@Override
	public void setPasswordHash(String pwHash) {
		this.passwordHash = pwHash;
	}
	
	@Override
	public String getPassword() {
		return this.passwordHash;
	}

	@Override
	public void setName(String name) {
		this.nickname = name;
	}

	@Override
	public String getName() {
		return this.nickname;
	}

	@Override
	public ArrayList<ResourceType> getResource(ResourceType resource) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBoard getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getCardPlayed() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void setCardPlayed(Boolean cardPlayed) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void joinLobby(ILobby lobby) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createLobby(String lobbyName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLobby(ILobby lobby) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leaveLobby(String lobbyName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int compareTo(IPlayer player) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getIsAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

}
