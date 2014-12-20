package model;

public class Enemy extends Opponent{
	
	//  VARIABLES 
	final int MAX_JOKING_THRESHOLD = 10;
	final int MAX_FIGHTING_THRESHOLD = 10;
	int jokeThreshold;
	int fightThreshold;
	
	// CONSTRUCTOR
	
	public Enemy() {
		super();
		this.jokeThreshold = (int)(Math.random()*MAX_JOKING_THRESHOLD);
		this.fightThreshold = (int)(Math.random()*MAX_FIGHTING_THRESHOLD);
	}

	public Enemy(int bonus, int jokeThreshold, int fightThreshold) {
		super(bonus);
		this.jokeThreshold = jokeThreshold;
		this.fightThreshold = fightThreshold;
	}

	// METHODS
	
	public void interactWith(Player player, String choice) {
		if (choice=="fight" && player.fightingSkill > fightThreshold) {
			this.increaseFightingSkill(player);
		} else if (choice=="joke" && player.jokingSkill > jokeThreshold) {
			this.increaseJokingSkill(player);
		}
	}
	
	// GETTERS
	
	// SETTERS
	
}
