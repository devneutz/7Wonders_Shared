package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import ch.fhnw.sevenwonders.enums.*;
import ch.fhnw.sevenwonders.interfaces.*;

public class Player implements IPlayer {

	private transient final Logger logger = Logger.getLogger("");
	private String passwordHash;
	private String nickname;
	private ILobby lobby;
	private int militaryWarPoints;
	private ArrayList<ICard> cards;
	private ArrayList<ICard> CardStack;
	private IBoard board;
	private boolean cardPlayed;
	private ArrayList<ResourceType> coinWallet;

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
	public int compareTo(IPlayer player) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getIsAuthenticated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ILobby getLobby() {
		return this.lobby;
	}

	@Override
	public void setLobby(ILobby inLobby) {
		this.lobby = inLobby;	
	}
	
	

	public ArrayList<ResourceType> getCoinWallet() {
		return coinWallet;
	}

	public void setCoinWallet(ArrayList<ResourceType> coinWallet) {
		this.coinWallet = coinWallet;
	}

	public int getMilitaryWarPoints() {
		return militaryWarPoints;
	}

	public void setMilitaryWarPoints(int militaryWarPoints) {
		this.militaryWarPoints = militaryWarPoints;
	}
	
	//alle Karten Ressourcen
	public ArrayList<ResourceType> getCardResources() {
		ArrayList<ResourceType> cardResource = new ArrayList<ResourceType>();
		
		for(int x = 0; x < this.cards.size(); x++) {
			cardResource.addAll(this.cards.get(x).getValue());	
		
		}
		return cardResource;
	}
	
	//alle Spieler Ressourcen
	public ArrayList<ResourceType> getPlayerResources() {
		ArrayList<ResourceType> allResources = new ArrayList<ResourceType>();
		
		allResources.addAll(this.getCardResources());
		allResources.addAll(this.getBoard().getBoardResource());
				
		
		return allResources;
	}
	

	@Override
	public int evaluateVictoryCoin() {
		int c = 0;
		for(int x = 0; x < this.getCoinWallet().size(); x++) {
			if(this.getCoinWallet().get(x) == ResourceType.Coin) {
			c++;
			}				
		}
		return c/3;
	}

	@Override
	public int evaluateVictoryWonder() {
		int w = 0;
		for(int x = 0; x < this.getBoard().getBoardResource().size(); x++) {
			if(this.getBoard().getBoardResource().get(x) == ResourceType.VictoryPoint) {
			w++;
			}	
		}
		
		return w;
	}

	@Override
	public int evaluateVictoryDirect() {
		int d = 0;
		
		for(int x = 0; x < this.getCardResources().size(); x++) {
			if(this.getCardResources().get(x) == ResourceType.VictoryPoint) {
				d++;
				}
			}
		return d;
	}

	@Override
	//@JOE bitte Hilfe bei algo.
	public int evaluateVictoryResearch() {
		int r = 0, tafel = 0, zirkel =  0, zahnrad = 0; 
		
		for(int x = 0; x < this.getPlayerResources().size(); x++) {
				switch (this.getPlayerResources().get(x)) {
				
				case GearWheel:
					zahnrad++;
					break;
					
				case StonePanel:
					tafel++;
					break;
					
				case Compasses:
					zirkel++;
					break;
				}
				
		}
		
		return 0;
	}

	@Override
	public int evaluateVictoryTrade() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int evaluateVictoryGuilds() {
		// TODO Auto-generated method stub
		return 0;
	}


	public HashMap<String, Integer> evaluate() {
	
		HashMap<String, Integer> winPoints = new HashMap<String, Integer>();
		
		winPoints.put("Militärkonflikt", this.getMilitaryWarPoints());
		winPoints.put("Coins", this.evaluateVictoryCoin());
		winPoints.put("Weltwunder", this.evaluateVictoryWonder());
		winPoints.put("Profanbauten", this.evaluateVictoryDirect());
		winPoints.put("Forschungsgebäude", this.evaluateVictoryResearch());
		winPoints.put("Handelsgebäude", this.evaluateVictoryTrade());
		winPoints.put("Gilden", this.evaluateVictoryGuilds());
		
		return winPoints;
		
	}



}
