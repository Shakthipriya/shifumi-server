package models;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import play.test.FakeApplication;
import play.test.Helpers;

public class GameTest {

	public static FakeApplication app;

	@BeforeClass
	public static void startApp() {
		app = Helpers.fakeApplication(Helpers.inMemoryDatabase());
		Helpers.start(app);

	}

	@AfterClass
	public static void stopApp() {
		Helpers.stop(app);
	}

	@After
	public void cleanDatabase() {
		for (Game game : Game.all()) {
			game.delete();
		}
	}

	@Test
	public void save_games_and_retrieve_thems() {
		int nb = Game.count();
		assertThat(Game.all()).hasSize(nb);
		Player p1 = createPlayer("toto");
		Player p2 = createPlayer("titi");
		Player p3 = createPlayer("tata");
		new Game(p1).save();
		new Game(p2).save();
		new Game(p3).save();
		assertThat(Game.all()).hasSize(nb + 3);
	}

	@Test
	public void save_games_and_count_thems() {
		int nb = Game.count();
		Player p1 = createPlayer("toto");
		Player p2 = createPlayer("titi");
		Player p3 = createPlayer("tata");
		
		new Game(p1).save();
		new Game(p2).save();
		new Game(p3).save();
		assertThat(Game.count()).isEqualTo(nb + 3);
	}

	@Test
	public void save_games_and_retrieve_available() {

		Player p1 = createPlayer("jean");
		Player p2 = createPlayer("pedro");
		Player p3 = createPlayer("emma");
		Player p4 = createPlayer("josianne");
		
		Game gameNotAvailable = new Game(p1);
		assertThat(gameNotAvailable.addGuest(p2)).isTrue();

		new Game(p3).save();
		new Game(p4).save();

		for (Game game : Game.all()) {
			System.out.println(game.getId());
			System.out.println(game.getPlayerOwner());
			System.out.println(game.getPlayerGuest());
		}

		assertThat(Game.waiting()).hasSize(2);
	}

	private Player createPlayer(String name) {
		Player p = new Player(name);
		p.save();
		return p;
	}

}
