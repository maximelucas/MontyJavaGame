package model;

public class Player {
	
	private int score = 0;
	private int visionScope = 2;
	private Position position;
	private int stepsLeft;
	private int fightingSkill;
	private int jokingSkill;
	private String skillChoice;
	
	/*
	 * set skills according to difficulty level
	 */
	public Player(Position position, String difficultyLevel) {
		this.position = position;
		switch(difficultyLevel) {
		case "easy":	
			stepsLeft = 50; 
			fightingSkill = 8; 
			jokingSkill = 8;
			break;
		case "medium": 
			stepsLeft = 30; 
			fightingSkill = 2; 
			jokingSkill = 2;
			break;	
		case "difficult": 
			stepsLeft = 20; 
			fightingSkill = 2; 
			jokingSkill = 2;
			break;	
		case "impossible": 
			stepsLeft = 10; 
			fightingSkill = 1; 
			jokingSkill = 1;
			break;
		default:
			;
		}
	}

	
	public void move(Position destination) {
		setPosition(destination);
	}
	
	public void increaseScore(int amount) {
		score += amount;
	}
	
	public void increaseStepsLeft(int amount) {
		stepsLeft+= amount;
	}
	
	public void increaseFightingSkill(int amount) {
		fightingSkill += amount;
	}
	
	public void increaseJokingSkill(int amount) {
		jokingSkill += amount;
	}
	
	public Position getPosition() {
		return position;
	}
	
	public int getScore() {
		return score;
	}
	
	public int getStepsLeft() {
		return stepsLeft;
	}
	
	public int getFightingSkill() {
		return fightingSkill;
	}
	
	public int getJokingSkill() {
		return jokingSkill;
	}
	
	public String getSkillChoice() {
		return skillChoice;
	}
	
	public int getVisionScope() {
		return visionScope;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void setSkillChoice(String choice) {
		this.skillChoice = choice;
	}
}
