package model;

public class Player {
	
	private int score = 0;
	private int visionScope = 2;
	private Position position;
	private int stepsLeft;
	private int fightingSkill;
	private int jokingSkill;
	private String skillChoice;
	
	public Player(Position position, String difficultyLevel) {
		this.position = position;
		switch(difficultyLevel) {
		case "easy":	
			this.stepsLeft = 150; 
			this.fightingSkill = 5; 
			this.jokingSkill = 5;
			break;
		case "medium": 
			this.stepsLeft = 150; 
			this.fightingSkill = 2; 
			this.jokingSkill = 2;
			break;	
		case "difficult": 
			this.stepsLeft = 100; 
			this.fightingSkill = 2; 
			this.jokingSkill = 2;
			break;	
		case "impossible": 
			this.stepsLeft = 10; 
			this.fightingSkill = 1; 
			this.jokingSkill = 1;
			break;
		default:
			;
		}
	}
	
	public void setDifficulty(String difficultyLevel) {
		switch(difficultyLevel) {
		case "easy":	
			this.stepsLeft = 150; 
			this.fightingSkill = 5; 
			this.jokingSkill = 5;
			break;
		case "medium": 
			this.stepsLeft = 150; 
			this.fightingSkill = 2; 
			this.jokingSkill = 2;
			break;	
		case "difficult": 
			this.stepsLeft = 100; 
			this.fightingSkill = 2; 
			this.jokingSkill = 2;
			break;	
		case "impossible": 
			this.stepsLeft = 10; 
			this.fightingSkill = 1; 
			this.jokingSkill = 1;
			break;
		default:
			;
		}
	}
	
	public void move(Position destination) {
		setPosition(destination);
		stepsLeft -= 1;
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
