package model;

public class Helper extends Opponent {
	
	private static final int MIN_STEPS_BONUS = 5;
	private int stepsBonus;
	private String[] options = {"joke", "fight", "steps"};
	
	public Helper() {
		super();
		this.stepsBonus =  1 + (int)(3*(Math.random()*(MIN_STEPS_BONUS -1))); // generate magic between 5 and 15
	}
		
	
	/*
	 * based on the player's choice of interaction, increase 
	 * his skill points accordingly 
	 */
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
		
	public int getStepsBonus() {
		return stepsBonus;
	}
	
	public String[] getOptions() {
		return options;
	}
}
