package ch.fhnw.sevenwonders.messages;

import ch.fhnw.sevenwonders.enums.StatusCode;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ServerGameMessage extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7146125031330659573L;
	private IPlayer player;
	private StatusCode statusCode;

	public ServerGameMessage() {	}

	@Override
	public void setPlayer(IPlayer inPlayer) {
		this.player = inPlayer;		
	}

	public IPlayer getPlayer() {
		return player;
	}
	
	public StatusCode getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(StatusCode statusCode) {
		this.statusCode = statusCode;
	}

}
