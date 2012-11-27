package controllers.shifumi.ressources;

import models.Choice;

import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;

import play.*;
import play.mvc.*;
import play.mvc.BodyParser.Json;

import views.html.*;
 
public class ChoiceRessource extends Controller {
  
  @BodyParser.Of(Json.class)
  public static Result availableActions() {
    ObjectNode result = play.libs.Json.newObject();
	ArrayNode actionsNode = result.putArray("choices");
    
    for(Choice choice:Choice.values()){
    	actionsNode.add(choice.toJson());
    }
    return ok(result);
  }
  
  
  
  
  
}