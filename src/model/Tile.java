package model;

public class Tile {
	
	// VARIABLES 
	
	private String terrain;
	private Opponent opponent;
	private Player player;
	
	// CONSTRUCTORS
	
	public Tile(String terrain) {
		this.terrain = terrain;
	}
	
	// METHODS 
	
	public boolean isInteractionPossible() {
		return (opponent != null);
	}
	
	public void handleInteraction(Player player) {
		this.opponent.interactWith(player);
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
	
	@Override 
	public String toString() {
		return "\n"+player + "\t"+opponent;
	}
}
