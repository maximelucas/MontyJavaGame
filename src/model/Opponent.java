package model;

public abstract class Opponent {
	
	// VARIBABLES
	
	private static final int MAX_BONUS = 5;
	private int bonus;
	
	// CONSTRUCTOR
	
	public Opponent() {
		this.bonus = 1 + (int)(Math.random()*(MAX_BONUS-1));
	}
	
	// METHODS
	
	public abstract void interactWith(Player player);
	
	public void increaseFightingSkill(Player player) {
		player.increaseFightingSkill(bonus);
	}
	
	public void increaseJokingSkill(Player player) {
		player.increaseJokingSkill(bonus);
	}
	
	// GETTERS
	
	public int getBonus() {
		return bonus;
	}
	
	// SETTERS

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}

