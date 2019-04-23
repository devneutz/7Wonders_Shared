package ch.fhnw.sevenwonders.messages;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.GameAction;
import ch.fhnw.sevenwonders.enums.StatusCode;
import ch.fhnw.sevenwonders.interfaces.ICard;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ServerGameMessage extends Message {

	private IPlayer player;
	private GameAction action;
	private StatusCode statusCode;
	private ArrayList<IPlayer> lobbyPlayers;
	private ArrayList<ICard> cards;

	public ServerGameMessage(GameAction inAction) {
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

	public ArrayList<IPlayer> getLobbyPlayers() {
		return lobbyPlayers;
	}

	public void setLobbyPlayers(ArrayList<IPlayer> lobbyPlayers) {
		this.lobbyPlayers = lobbyPlayers;
	}

	public ArrayList<ICard> getCards() {
		return cards;
	}

	public void setCards(ArrayList<ICard> cards) {
		this.cards = cards;
	}

	public IPlayer getPlayer() {
		return player;
	}
	
	public void determineWinner(ArrayList<IPlayer> players) {
		players = this.lobbyPlayers;
		//@Joe was zutun?
	}
	

}
