package model;

public class Helper extends Opponent {
	
	// VARIABLES
	
	private static final int MIN_MAGIC = 5;
	private int magic;
	private String[] options = {"joke", "fight", "magic"};
	
	// CONSTRUCTOR
	
	public Helper() {
		super();
		this.magic = 3*( 1 + (int)(Math.random()*(MIN_MAGIC -1))); // generate magic between 5 and 15
	}
	
	// METHODS
	
	public void interactWith(Player player) {
		String choice = player.getSkillChoice();
		if (choice=="fight") {
			this.increaseFightingSkill(player);
		} else if (choice=="joke") {
			this.increaseJokingSkill(player);
		} else if (choice=="magic") {
			this.increaseStepsLeft(player);
		}
	}
	
	public void increaseStepsLeft(Player player) {
		player.increaseStepsLeft(magic);
	}
		
	// GETTERS
	
	public int getMagic() {
		return magic;
	}
	
	public String[] getOptions() {
		return options;
	}
	
	// SETTERS

	public String toString() {
		return "help";
	}
}
