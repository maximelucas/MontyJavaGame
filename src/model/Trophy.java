package model;

public class Trophy extends Opponent {

	private final static int JOKING_THRESHOLD = 15;
	private final static int FIGHTING_THRESHOLD = 15;
	private final static int BONUS = 25;
	private boolean won = false;
	
	public Trophy() {
		//super(BONUS);
		this.setBonus(BONUS);
	}
	
	public void interactWith(Player player) {
		if (player.getJokingSkill() > JOKING_THRESHOLD) {
			won = true;
			player.increaseScore(this.getBonus());
		} else if (player.getFightingSkill() > FIGHTING_THRESHOLD) {
			won = true;
			player.increaseScore(this.getBonus());
		}
	}
	
	public boolean getWon() {
		return won;
	}
}
