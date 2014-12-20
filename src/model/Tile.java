package model;

public class Tile {
	
	// VARIABLES 
	
	String terrain;
	Opponent opponent;
	Player player;
	String object;
	
	// CONSTRUCTORS
	
	public Tile(String terrain) {
		this.terrain = terrain;
	}
	
	public Tile(String terrain, Opponent opponent) {
		this.terrain = terrain;
		this.opponent = opponent;
	}
	
	public Tile(String terrain, Opponent opponent, Player player) {
		this.terrain = terrain;
		this.opponent = opponent;
		this.player = player;
	}
	
	public Tile(String terrain, Opponent opponent, Player player, String object) {
		this.terrain = terrain;
		this.opponent = opponent;
		this.player = player;
		this.object = object;
	}
	
	// METHODS 
	
	public boolean isInteractionPossible() {
		return (opponent != null);
	}
	
	public void handleInteraction(Opponent opponent, Player player, String terrain) {
		opponent.interactWith(player, terrain);
	}
	
	// GETTERS 
	
	public String getTerrain() {
		return terrain;
	}
	
	public Opponent getOpponent() {
		return opponent;
	}
	
	public Player getPlayer() {	
		return player;
	}

	// SETTERS 
	
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	public void setOpponent(Opponent opponent) {
		this.opponent = opponent;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setObject(String object) {
		this.object = object;
	}
}
