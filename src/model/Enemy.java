package model;

public class Enemy extends Opponent{
	
	private static final int MAX_JOKING_THRESHOLD = 10;
	private static final int MAX_FIGHTING_THRESHOLD = 10;
	private int jokeThreshold;
	private int fightThreshold;
	private String[] options = {"joke", "fight"};
	
	public Enemy() {
		super();
		this.jokeThreshold = 1 + (int) (Math.random()*(MAX_JOKING_THRESHOLD - 1));
		this.fightThreshold = 1 + (int) (Math.random()*(MAX_FIGHTING_THRESHOLD - 1));
	}

	public void interactWith(Player player) {
		String choice = player.getSkillChoice();
		if (choice=="fight" && player.getFightingSkill() > fightThreshold) {
			increaseFightingSkill(player);
			player.increaseScore(this.getBonus());
		} else if (choice=="joke" && player.getJokingSkill() > jokeThreshold) {
			this.increaseJokingSkill(player);
			player.increaseScore(this.getBonus());
		}
	}
	
	public String[] getOptions() {
		return options;
	}
	
	public String toString() {
		return "enem";
	}
	
}
