package ch.fhnw.sevenwonders.messages;

import ch.fhnw.sevenwonders.enums.GameAction;
import ch.fhnw.sevenwonders.enums.StatusCode;
import ch.fhnw.sevenwonders.interfaces.IBoard;
import ch.fhnw.sevenwonders.interfaces.ICard;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ServerGameMessage extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7146125031330659573L;
	private IPlayer player;
	private StatusCode statusCode;

	private GameAction action;
	private ICard card;
	private IBoard board;
	
	public ServerGameMessage(GameAction inAction) {
		this.action = inAction;
	}

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
	
	public GameAction getAction() {
		return action;
	}

	public void setAction(GameAction action) {
		this.action = action;
	}
	
	public ICard getCard() {
		return card;
	}

	public void setCard(ICard card) {
		this.card = card;
	}

	public IBoard getBoard() {
		return board;
	}

	public void setBoard(IBoard board) {
		this.board = board;
	}

}
