package ch.fhnw.sevenwonders.messages;

import ch.fhnw.sevenwonders.enums.GameAction;
import ch.fhnw.sevenwonders.interfaces.ICard;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

public class ClientGameMessage extends Message {

	private IPlayer player;
	private GameAction action;
	private ICard card;
	
	public ClientGameMessage(GameAction inAction) {
		this.action = inAction;
	}
	
	
	@Override
	public void setPlayer(IPlayer inPlayer) {
		// TODO Auto-generated method stub
		
	}
			
	
	public ICard getCard() {
		return card;
	}


	public void setCard(ICard card) {
		this.card = card;
	}


	public GameAction getAction() {
		return action;
	}


	public void setAction(GameAction action) {
		this.action = action;
	}
	
	
	public IPlayer getPlayer() {
		return player;
	}


	public String getPlayerName() {
		return player.getName();
	}
	
	public void setPlayerName(String name) {
		this.player.setName(name);
	}

}
