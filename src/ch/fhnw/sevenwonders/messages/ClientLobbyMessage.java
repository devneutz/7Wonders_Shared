package ch.fhnw.sevenwonders.messages;

import java.util.List;

import ch.fhnw.sevenwonders.enums.LobbyAction;
import ch.fhnw.sevenwonders.interfaces.ILobby;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ClientLobbyMessage extends Message {
	
	private IPlayer player;
	private LobbyAction action;
	// private String PlayerName; = ist das nicht gleich Iplayer?
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
	
	public void startLobby() {
		// @Joe ist dieses Cast korrekt?
		List<IPlayer> list = (List<IPlayer>) this.player;
		this.lobby.startLobby(list);
	}
	
	public void createLobby(String name) {
		name = this.player.getName();
		this.action = LobbyAction.CreateLobby;
		
	}
	
	public void deleteLobby() {
		this.action = LobbyAction.DeleteLobby;
	}
	
	public void setAmountPlayers(int amount) {
		// @Joe what to do?
	}

	public String getPlayerName() {
		return player.getName();
	}
	
	public void setPlayerName(String name) {
		this.player.setName(name);
	}

	/*public String getPlayerName() {
		return this.PlayerName;
	}

	public void setPlayerName(String playerName) {
		this.PlayerName = playerName;
	}
	*/
		
	
}
