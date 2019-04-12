package ch.fhnw.sevenwonders.messages;

import java.io.Serializable;

public abstract class Message implements Serializable{
	public String message;
	
	public Message(String inMessage) {
		this.message = inMessage;
	}
}
