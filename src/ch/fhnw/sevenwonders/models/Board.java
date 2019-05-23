package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.enums.ValueCalculationType;
import ch.fhnw.sevenwonders.interfaces.IBoard;
import ch.fhnw.sevenwonders.interfaces.ICard;
import ch.fhnw.sevenwonders.interfaces.IPlayer;

/**
 * 
 * @author Joel Neutzner, Ismael Liuzzi, Matteo Farneti
 *
 */

public class Board implements IBoard {

	private String name;
	private ArrayList<ResourceType> boardResource;
	private ArrayList<ResourceType> stepOneValue;
	private ArrayList<ResourceType> stepOneCost;
	private ArrayList<ResourceType> stepTwoValue;
	private ArrayList<ResourceType> stepTwoCost;
	private ArrayList<ResourceType> stepThreeValue;
	private ArrayList<ResourceType> stepThreeCost;
	private String imageName;
	private boolean StepOneBuilt;
	private boolean StepTwoBuilt;
	private boolean StepThreeBuilt;

	public Board(String name, ArrayList<ResourceType> boardResource, ArrayList<ResourceType> stepOneValue,
			ArrayList<ResourceType> stepOneCost, ArrayList<ResourceType> stepTwoValue,
			ArrayList<ResourceType> stepTwoCost, ArrayList<ResourceType> stepThreeValue,
			ArrayList<ResourceType> stepThreeCost, String imageName) {
		this.name = name;
		this.boardResource = new ArrayList<ResourceType>();
		this.boardResource.addAll(boardResource);
		this.stepOneValue = new ArrayList<ResourceType>();
		this.stepOneValue.addAll(stepOneValue);
		this.stepOneCost = new ArrayList<ResourceType>();
		this.stepOneCost.addAll(stepOneCost);
		this.stepTwoValue = new ArrayList<ResourceType>();
		this.stepTwoValue.addAll(stepTwoValue);
		this.stepTwoCost = new ArrayList<ResourceType>();
		this.stepTwoCost.addAll(stepTwoCost);
		this.stepThreeValue = new ArrayList<ResourceType>();
		this.stepThreeValue.addAll(stepThreeValue);
		this.stepThreeCost = new ArrayList<ResourceType>();
		this.stepThreeCost.addAll(stepThreeCost);
		this.imageName = imageName;
		this.StepOneBuilt = false;
		this.StepTwoBuilt = false;
		this.StepThreeBuilt = false;
	}
	
	/**
	 * @author Matteo Farneti
	 * Prüft, ob die Kosten mit den vorhanden Ressourcen gedeckt werden und somit gebaut werden kann.
	 */
	@Override
	public Boolean canBuild(IPlayer p) {
		int inStep = this.getNextStageToBuild();
		
		ArrayList<ResourceType> tmpCost = new ArrayList<ResourceType>();
		
		switch (inStep) {
		case 1: tmpCost.addAll(this.stepOneCost); break;
		
		case 2: tmpCost.addAll(this.stepTwoCost); break;
		
		case 3: tmpCost.addAll(this.stepThreeCost); break;
		
		}
		
		ArrayList<ResourceType> tempCardsAndValues = new ArrayList<ResourceType>();
		ArrayList<ICard> tempCardsOr = new ArrayList<ICard>();
		ArrayList<Boolean> costFound = new ArrayList<Boolean>();
		boolean buildable = false;
		
		
		//alle Karten zuweisen
		for (int x = 0; x < p.getCards().size(); x++) {
			
			if (p.getCards().get(x).getValueCalculationType()== ValueCalculationType.Or) {
					tempCardsOr.add(p.getCards().get(x));
			} else {
					for(int y = 0; y < p.getCards().get(x).getValue().size(); y++) {
						tempCardsAndValues.add(p.getCards().get(x).getValue().get(y));
					}				
			}
			
		}
		
		//alle Boardressourcen zuweisen
		tempCardsAndValues.addAll(this.getBoardResource());
			
		//alle Coins zuweisen
		tempCardsAndValues.addAll(p.getCoinWallet());
		
		
		
		//Überpruefungsliste ob allle Ressourcen gedeckt werden konnten
		for(int x = 0 ; x < tmpCost.size(); x++){
			costFound.add(false);
		}
		
		//pruefen ob Resource vorhanden
		for (int x = 0; x < tmpCost.size(); x++) {
			
			for(int y = 0; y < tempCardsAndValues.size(); y++) {
				if(tmpCost.get(x).equals(tempCardsAndValues.get(y))) { 
					tempCardsAndValues.remove(y);
					costFound.set(x, true);
					break;
				}
			}
			
				
			if (!costFound.get(x)){
				for (int y = 0; y < tempCardsOr.size(); y++) {
					for (int z = 0; z < tempCardsOr.get(y).getValue().size(); z++) {
						if (tmpCost.get(x) == tempCardsOr.get(y).getValue().get(z)) { 
							tempCardsOr.remove(y);
							costFound.set(x, true);
							break;
						}
					}
				}
			}
			
		}
		
		
		if (costFound.contains(false)) {
			buildable = false;
		} else { buildable = true;
		}
		
		return buildable;		
	}

	@Override
	public String getImageName() {
		return imageName;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public ArrayList<ResourceType> getStepOneValue() {
		return stepOneValue;
	}

	@Override
	public ArrayList<ResourceType> getStepTwoValue() {
		return stepTwoValue;
	}

	public ArrayList<ResourceType> getStepThreeValue() {
		return stepThreeValue;
	}
	/**
	 * Gibt zurueck was der nächste Schritt für den Bau ist.
	 */
	public int getNextStageToBuild() {
		if (!this.StepOneBuilt) {
			return 1;
		}

		if (!this.StepTwoBuilt) {
			return 2;
		}

		if (!this.StepThreeBuilt) {
			return 3;
		}
		return 0;
	}

	@Override
	public Boolean getStepOneBuilt() {
		// TODO Auto-generated method stub
		return this.StepOneBuilt;
	}

	@Override
	public Boolean getStepTwoBuilt() {
		// TODO Auto-generated method stub
		return this.StepTwoBuilt;
	}

	@Override
	public Boolean getStepThreeBuilt() {
		// TODO Auto-generated method stub
		return this.StepThreeBuilt;
	}

	@Override
	public void setStepOneBuilt(boolean isBuilt) {
		this.StepOneBuilt = isBuilt;

	}

	@Override
	public void setStepTwoBuilt(boolean isBuilt) {
		this.StepTwoBuilt = isBuilt;

	}

	@Override
	public void setStepThreeBuilt(boolean isBuilt) {
		this.StepThreeBuilt = isBuilt;

	}

	
	/**
	 * Gibt alle Ressourcen des Boards aus
	 */
	public ArrayList<ResourceType> getBoardResource() {
		return boardResource;
	}

	public void addBoardResource(ArrayList<ResourceType> boardResource) {
		this.boardResource.addAll(boardResource);
	}
	
	/**
	 * @author Ismael
	 */
	public int destroyCoins() {
		int destroyed = 0;
		for (int x = 0; x < this.boardResource.size(); x++) {
			if (this.boardResource.get(x)== ResourceType.Coin) {
				this.boardResource.remove(x);
				x--;
				destroyed++;
			}
		}
		return destroyed;
	}

}
