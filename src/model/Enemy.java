package model;

public class Enemy extends Opponent{
	
	private static final int MAX_JOKING_THRESHOLD = 10;
	private static final int MAX_FIGHTING_THRESHOLD = 10;
	private int jokeThreshold; // to be beaten by player to gain points
	private int fightThreshold; // to be beaten by player to gain points
	private String[] options = {"joke", "fight"};
	
	public Enemy() {
		super();
		this.jokeThreshold = 1 + (int) (Math.random()*(MAX_JOKING_THRESHOLD - 1));
		this.fightThreshold = 1 + (int) (Math.random()*(MAX_FIGHTING_THRESHOLD - 1));
	}

	/*
	 * based on the player's choice of interaction, check if players win, and increase 
	 * his skill points accordingly if so
	 */
	public void interactWith(Player player) {
		String choice = player.getSkillChoice();
		if (choice == "fight" && player.getFightingSkill() > fightThreshold) {
			increaseFightingSkill(player);
			player.increaseScore(getBonus());
		} else if (choice == "joke" && player.getJokingSkill() > jokeThreshold) {
			increaseJokingSkill(player);
			player.increaseScore(getBonus());
		}
	}
	
	public String[] getOptions() {
		return options;
	}
}
