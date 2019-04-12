package ch.fhnw.sevenwonders.messages;

import java.io.Serializable;

import ch.fhnw.sevenwonders.interfaces.IPlayer;

public abstract class Message implements Serializable{
	public IPlayer player;
	
	public abstract void setPlayer(IPlayer inPlayer);
	
}
