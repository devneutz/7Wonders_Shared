package ch.fhnw.sevenwonders.interfaces;

import ch.fhnw.sevenwonders.enums.ActionType;

public interface IMessage {
	
	// Gibt den Aktions-enum Typen der Nachricht zur�ck
	ActionType getActionType();

}
