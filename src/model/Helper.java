package model;

public class Helper extends Opponent {
	
	/*
	 * When the player encounters a Helper, the player is asked what skill he wants to
	 * improve (or get extra steps), and gets extra points in the skill of his choice 
	 */
	
	// VARIABLES
	
	private static final int MIN_STEPS_BONUS = 5;
	private int stepsBonus;
	private String[] options = {"joke", "fight", "steps"};
	
	// CONSTRUCTOR
	
	public Helper() {
		super();
		this.stepsBonus =  1 + (int)(3*(Math.random()*(MIN_STEPS_BONUS -1))); // generate magic between 5 and 15
	}
		
	// METHODS
	
	public void interactWith(Player player) {
		String choice = player.getSkillChoice();
		if (choice == "fight") {
			this.increaseFightingSkill(player);
		} else if (choice == "joke") {
			this.increaseJokingSkill(player);
		} else if (choice == "steps") {
			this.increaseStepsLeft(player);
		}
	}
	
	public void increaseStepsLeft(Player player) {
		player.increaseStepsLeft(stepsBonus);
	}
		
	// GETTERS
	
	public int getStepsBonus() {
		return stepsBonus;
	}
	
	public String[] getOptions() {
		return options;
	}
	
	// SETTERS

	public String toString() {
		return "help";
	}
}
