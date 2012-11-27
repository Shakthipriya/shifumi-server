package controllers.shifumi.ressources;

import models.Game;
import play.mvc.BodyParser;
import play.mvc.BodyParser.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class GameRessource extends Controller {

	@BodyParser.Of(Json.class)
	public static Result joinGame() {
		Game.create(new Game(null));
		return ok();
	}

}
