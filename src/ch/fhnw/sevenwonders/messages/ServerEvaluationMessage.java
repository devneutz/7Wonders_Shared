package ch.fhnw.sevenwonders.messages;


import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.GameAction;
import ch.fhnw.sevenwonders.enums.StatusCode;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ServerEvaluationMessage extends Message {

	private IPlayer player;
	private GameAction action;
	private ArrayList<IPlayer> opponents;

	public GameAction getAction() {
		return action;
	}

	public void setAction(GameAction action) {
		this.action = action;
	}


	private StatusCode statusCode;

	public ServerEvaluationMessage(GameAction inAction) {
		this.action = inAction;

		this.opponents = new ArrayList<IPlayer>();
	}

	@Override
	public void setPlayer(IPlayer inPlayer) {
		this.player = inPlayer;		
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
	
	public void setOpponents(ArrayList<IPlayer> inOpponents) {
		this.opponents.clear();
		this.opponents.addAll(inOpponents);
	}

	public ArrayList<IPlayer> getOpponents(){
		return this.opponents;
	}

}
