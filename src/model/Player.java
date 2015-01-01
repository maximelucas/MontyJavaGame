package model;

public class Player {
	
	// VARIABLES 
	
	private Position position;
	private int score = 0;
	private int stepsLeft;
	private int fightingSkill;
	private int jokingSkill;
	private int visionScope = 2;
	private String skillChoice;
	
	// CONSTRUCTOR 
	
	public Player(Position position, int difficultyLevel) {
		this.position = position;
		
		switch(difficultyLevel) {
		case 1:	
			this.stepsLeft = 150; 
			this.fightingSkill = 5; 
			this.jokingSkill = 5;

		case 2: 
			this.stepsLeft = 150; 
			this.fightingSkill = 2; 
			this.jokingSkill = 2;
				
		case 3: 
			this.stepsLeft = 100; 
			this.fightingSkill = 2; 
			this.jokingSkill = 2;
				
		case 4: 
			this.stepsLeft = 10; 
			this.fightingSkill = 1; 
			this.jokingSkill = 1;
		}
	}
	
	// METHODS ------------------------------
	
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
	
	// GETTERS 
	
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
	
	// SETTERS
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public void setSkillChoice(int choice) {
		switch(choice) {
		case 0:
			this.skillChoice = "joke";
			break;
		case 1:
			this.skillChoice = "fight";
			break;
		case 2:
			this.skillChoice = "magic";
			break;
		default:
			;
		}
	}
	
	@Override
	public String toString() {
		return "play \t" + position + "\t"+ stepsLeft
				+ "\t"+ jokingSkill + "\t"+ score + "\n";
	}
}
