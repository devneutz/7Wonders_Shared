package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.interfaces.IBoard;

/**
 * 
 * @author Matte
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
	
	public Board (String name,
			ArrayList<ResourceType> boardResource,
			ArrayList<ResourceType> stepOneValue,
			ArrayList<ResourceType> stepOneCost,
			ArrayList<ResourceType> stepTwoValue,
			ArrayList<ResourceType> stepTwoCost,
			ArrayList<ResourceType> stepThreeValue,
			ArrayList<ResourceType> stepThreeCost,
			String imageName) {
		this.name = name;
		this.boardResource = boardResource;
		this.stepOneValue = stepOneValue;
		this.stepOneCost = stepOneCost;
		this.stepTwoValue = stepTwoValue;
		this.stepTwoCost = stepTwoCost;
		this.stepTwoValue = stepThreeValue;
		this.stepTwoCost = stepThreeCost;
		this.imageName = imageName;
	}
	@Override
	public Boolean canBuild(int inStep, ArrayList<ResourceType> inResources) {
		ArrayList<ResourceType> tempResources = new ArrayList<ResourceType>(inResources.size());
		for (ResourceType rt : inResources) tempResources.add(rt);
		boolean result = true;
		
		// Überprüft, ob die Kosten (StepOneCost) im Step 1 mit den verfügbaren Resourcen (inResources) gedeckt werden können.
		if (inStep == 1) {
			for (int i = 0; i < stepOneCost.size(); i++) {
				for (int j = 0; j < tempResources.size(); j++) {
					if (tempResources.get(j).equals(stepOneCost.get(i))) {
						tempResources.remove(j);
						result = true;
						break;
					}
					else {
						result = false;
					}
				}
			}
		}
		// Überprüft, ob die Kosten (StepTwoCost) im Step 2 mit den verfügbaren Resourcen (inResources) gedeckt werden können.
		if (inStep == 2) {
			for (int i = 0; i < stepTwoCost.size(); i++) {
				for (int j = 0; j < tempResources.size(); j++) {
					if (tempResources.get(j).equals(stepTwoCost.get(i))) {
						tempResources.remove(j);
						result = true;
						break;
					}
					else {
						result = false;
					}
				}
			}			
		}
		return result;
	}

	@Override
	public String getImageName() {
		return imageName;
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
	
	public int getNextStageToBuild() {
		if(!this.StepOneBuilt) {
			return 1;
		}
		
		if(!this.StepTwoBuilt) {
			return 2;
		}
		
		if(!this.StepThreeBuilt) {
			return 3;
		}
		return 0;
	}

}
