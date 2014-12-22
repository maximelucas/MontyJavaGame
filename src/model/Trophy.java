package model;

public class Trophy extends Opponent {

	// VARIABLES 
	public final int JOKING_THRESHOLD = 15;
	public final int FIGHTING_THRESHOLD = 15;
	private boolean won = false;
	
	
	// CONSTRUCTOR
	
	public Trophy() {
	}
	
	// METHODS
	
	public void interactWith(Player player) {
		if (player.getJokingSkill() > JOKING_THRESHOLD) {
			won = true;
		} else if (player.getFightingSkill() > FIGHTING_THRESHOLD) {
			won = true;
		}
	}
	
	// GETTERS
	
	public boolean getWon() {
		return won;
	}
		
	// SETTERS
	
	public String toString() {
		return "trop";
	}
	
}
