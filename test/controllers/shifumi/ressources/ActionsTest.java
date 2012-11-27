package controllers.shifumi.ressources;

import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.callAction;
import static play.test.Helpers.charset;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;
import static play.test.Helpers.status;

import org.codehaus.jackson.JsonNode;
import org.junit.Test;

import play.libs.Json;

public class ActionsTest {
 
	
	@Test
	public void check_that_service_retrieve_choices() {
		play.mvc.Result actions = callAction(controllers.shifumi.ressources.routes.ref.ChoiceRessource.availableActions());
		assertThat(status(actions)).isEqualTo(OK);
		
		assertThat(contentType(actions)).isEqualTo("application/json");
		assertThat(charset(actions)).isEqualTo("utf-8");
	    String actionsString=contentAsString(actions);
	    JsonNode json=Json.parse(actionsString);
	    
	    assertThat(json.findPath("choices")).isNotNull();
	    assertThat(json.findPath("choices")).hasSize(5);
	}
	
	
}
