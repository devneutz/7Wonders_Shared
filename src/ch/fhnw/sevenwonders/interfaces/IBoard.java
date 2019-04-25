package ch.fhnw.sevenwonders.interfaces;

import java.io.Serializable;
import java.util.ArrayList;

import ch.fhnw.sevenwonders.enums.*;

public interface IBoard extends Serializable {
	
	// Methode zum Überprüfen, ob mit den angegebenen Ressourcen der Pyramidenteil gebaut werden kann
	Boolean canBuild(int inStep, ArrayList<ResourceType> inResources);
	
	String getImageName();
	
	ArrayList<ResourceType> getStepOneValue();
	
	ArrayList<ResourceType> getStepTwoValue();
}
