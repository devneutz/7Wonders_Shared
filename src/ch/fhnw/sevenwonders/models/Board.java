package ch.fhnw.sevenwonders.models;

import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.ResourceType;
import ch.fhnw.sevenwonders.interfaces.IBoard;

/**
 * 
 * @author Joel Neutzner, Ismael Liuzzi
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
		this.stepTwoValue = new ArrayList<ResourceType>();
		this.stepThreeValue.addAll(stepThreeValue);
		this.stepTwoCost = new ArrayList<ResourceType>();
		this.stepThreeCost.addAll(stepThreeCost);
		this.imageName = imageName;
	}

	@Override
	public Boolean canBuild(int inStep, ArrayList<ResourceType> inResources) {
		ArrayList<ResourceType> tempResources = new ArrayList<ResourceType>(inResources.size());
		for (ResourceType rt : inResources)
			tempResources.add(rt);
		boolean result = true;

		// Überprüft, ob die Kosten (StepOneCost) im Step 1 mit den verfügbaren
		// Resourcen (inResources) gedeckt werden können.
		if (inStep == 1) {
			for (int i = 0; i < stepOneCost.size(); i++) {
				for (int j = 0; j < tempResources.size(); j++) {
					if (tempResources.get(j).equals(stepOneCost.get(i))) {
						tempResources.remove(j);
						result = true;
						break;
					} else {
						result = false;
					}
				}
			}
		}
		// Überprüft, ob die Kosten (StepTwoCost) im Step 2 mit den verfügbaren
		// Resourcen (inResources) gedeckt werden können.
		if (inStep == 2) {
			for (int i = 0; i < stepTwoCost.size(); i++) {
				for (int j = 0; j < tempResources.size(); j++) {
					if (tempResources.get(j).equals(stepTwoCost.get(i))) {
						tempResources.remove(j);
						result = true;
						break;
					} else {
						result = false;
					}
				}
			}
		}
		// Überprüft, ob die Kosten (StepThreeCost) im Step 3 mit den verfügbaren
		// Resourcen (inResources) gedeckt werden können.
		if (inStep == 3) {
			for (int i = 0; i < stepThreeCost.size(); i++) {
				for (int j = 0; j < tempResources.size(); j++) {
					if (tempResources.get(j).equals(stepThreeCost.get(i))) {
						tempResources.remove(j);
						result = true;
						break;
					} else {
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

	public ArrayList<ResourceType> getStepResource() {

		ArrayList<ResourceType> tempResources = new ArrayList<ResourceType>();

		if (this.getStepOneBuilt() == true) {
			for (int x = 0; x < this.getStepOneValue().size(); x++) {
				tempResources.add(this.getStepOneValue().get(x));
			}

		}

		if (this.getStepTwoBuilt() == true) {
			for (int x = 0; x < this.getStepTwoValue().size(); x++) {
				tempResources.add(this.getStepTwoValue().get(x));
			}

		}

		if (this.getStepThreeBuilt() == true) {
			for (int x = 0; x < this.getStepThreeValue().size(); x++) {
				tempResources.add(this.getStepThreeValue().get(x));
			}

		}

		return tempResources;
	}

	public ArrayList<ResourceType> getBoardResource() {
		return boardResource;
	}

	public void setBoardResource(ArrayList<ResourceType> boardResource) {
		this.boardResource = boardResource;
	}

}
