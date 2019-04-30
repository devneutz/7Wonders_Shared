package ch.fhnw.sevenwonders.messages;


import ch.fhnw.sevenwonders.enums.GameAction;
import ch.fhnw.sevenwonders.enums.StatusCode;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ServerWarpointsMessage extends Message {

	private IPlayer player;
	private int warPoints;
	private GameAction action;
	
	
	public int getWinPoints() {
		return warPoints;
	}

	public void setWinPoints(int winPoints) {
		this.warPoints = winPoints;
	}

	public GameAction getAction() {
		return action;
	}

	public void setAction(GameAction action) {
		this.action = action;
	}


	private StatusCode statusCode;

	public ServerWarpointsMessage(GameAction inAction) {
		this.action = inAction;
	}

	@Override
	public void setPlayer(IPlayer inPlayer) {
		// TODO Auto-generated method stub
		
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


}
