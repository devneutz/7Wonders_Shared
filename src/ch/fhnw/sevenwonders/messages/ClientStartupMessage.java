package ch.fhnw.sevenwonders.messages;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ClientStartupMessage extends Message {

	private IPlayer player;
	private StartupAction action;
	
	public ClientStartupMessage(StartupAction inAction) {
		this.action = inAction;
	}
	
	@Override
	public void setPlayer(IPlayer inPlayer) {
		this.player = inPlayer;
	}
	
	public StartupAction getActionType() {
		return this.action;
	}
	
	public IPlayer getPlayer() {
		return this.player;
	}

}
