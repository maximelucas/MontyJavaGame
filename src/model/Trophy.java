package model;

public class Trophy extends Opponent {

	// VARIABLES 
	private final static int JOKING_THRESHOLD = 15;
	private final static int FIGHTING_THRESHOLD = 15;
	private final static int BONUS = 25;
	private boolean won = false;
	
	// CONSTRUCTOR
	
	public Trophy() {
		//super(BONUS);
		this.setBonus(BONUS);
	}
	
	// METHODS
	
	public void interactWith(Player player) {
		if (player.getJokingSkill() > JOKING_THRESHOLD) {
			won = true;
			player.increaseScore(this.getBonus());
		} else if (player.getFightingSkill() > FIGHTING_THRESHOLD) {
			won = true;
			player.increaseScore(this.getBonus());
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
