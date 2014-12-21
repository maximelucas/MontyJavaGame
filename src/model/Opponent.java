package model;

public abstract class Opponent {
	
	// VARIBABLES
	final int MAX_BONUS = 3;
	private int bonus;
	private Player player;
	
	// CONSTRUCTOR
	
	public Opponent() {
		this.bonus = 1 + (int)(Math.random()*(MAX_BONUS-1));
	}
	
	public Opponent(int bonus) {
		this.bonus = bonus;
	}
	
	// METHODS
	
	public abstract void interactWith(Player player, String choice);
	
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
	
	public Player getPlayer() {
		return player;
	}
	
	// SETTERS

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}

