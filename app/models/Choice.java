package models;

import org.codehaus.jackson.node.ObjectNode;

public enum Choice {
	  SCISSOR,ROCK,PAPER,LIZARD,SPOCK;
	  
	  public ObjectNode toJson(){
		  ObjectNode choice = play.libs.Json.newObject();
		  choice.put("name", name());
		  return choice;
		    
	  }
}