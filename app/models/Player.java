package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Player extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7842716508849350297L;
	
	
	@Id
	public Long id;
	
	String name;
	
	public Player(String name){
		super();
		this.name=name;
	}
}
