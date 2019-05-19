package ch.fhnw.sevenwonders.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.*;

public interface IBoard extends Serializable {

	// Methode zum Überprüfen, ob mit den angegebenen Ressourcen der Pyramidenteil
	// gebaut werden kann
	Boolean canBuild(IPlayer p);

	String getImageName();

	ArrayList<ResourceType> getStepOneValue();

	ArrayList<ResourceType> getStepTwoValue();

	ArrayList<ResourceType> getStepThreeValue();

	int getNextStageToBuild();

	Boolean getStepOneBuilt();

	Boolean getStepTwoBuilt();

	Boolean getStepThreeBuilt();

	void setStepOneBuilt(boolean isBuilt);

	void setStepTwoBuilt(boolean isBuilt);

	void setStepThreeBuilt(boolean isBuilt);
	
	void addBoardResource(ArrayList<ResourceType> boardResource);

	ArrayList<ResourceType> getBoardResource();

}
