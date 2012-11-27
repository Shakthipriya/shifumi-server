package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Game extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = -597493107544900915L;

	@Id
	private long id;
	
	//@JoinColumn(name="id",nullable=true)
	@ManyToOne
	private Player playerOwner;
	
	//@JoinColumn(name="id",nullable=true)
	//@JoinTable(name="id")
	@ManyToOne
	private Player playerGuest;

	public Game(Player owner) {
		super();
		this.playerOwner = owner;
	}

	public long getId(){
		return id;
	}
	public Player getPlayerOwner() {
		return playerOwner;
	}
 
	public Player getPlayerGuest() {
		return playerGuest;
	}

	public boolean addGuest(Player guest) {
		if (playerGuest != null)
			return false;
		this.playerGuest = guest;
		save();
		return true;
	}

	/** persistance statique **/
	public static Finder<Long, Game> find = new Finder<Long, Game>(Long.class,
			Game.class);

	public static void create(Game game) {
		game.save();
	}

	public static Game findById(Long id) {
		return find.byId(id);
	}

	public static int count() {
		return find.findRowCount();
	}

	public static List<Game> all() {
		return find.all();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
	 
	/**
	 * games waiting player
	 * @return the list of games waitings players.
	 */ 
	public static List<Game> waiting() {
		return find.where().isNull("playerGuest").findList();
	}

}
