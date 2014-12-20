package model;

import java.util.ArrayList;

public class Player {
	
	// VARIABLES ---------------------------
	
	Position position;
	int score;
	int timeLeft;
	int fightingSkill;
	int jokingSkill;
	ArrayList<String> bag;
	
	
	
	// CONSTRUCTOR --------------------------
	
	public Player(Position position, int difficultyLevel) {
		this.position = position;
		this.score = 0;
		this.bag = new ArrayList<String>();
		
		switch(difficultyLevel) {
		case 1:	this.timeLeft = 150; 
				this.fightingSkill = 5; 
				this.jokingSkill = 5;

		case 2: this.timeLeft = 150; 
				this.fightingSkill = 2; 
				this.jokingSkill = 2;
				
		case 3: this.timeLeft = 100; 
				this.fightingSkill = 2; 
				this.jokingSkill = 2;
				
		case 4: this.timeLeft = 75; 
				this.fightingSkill = 1; 
				this.jokingSkill = 1;
		}
	}

	
	public Player(int timeLeft, int fightingSkill, int jokingSkill) {
		this.timeLeft = timeLeft; 
		this.fightingSkill = fightingSkill; 
		this.jokingSkill = jokingSkill;
		this.position = new Position(1,1);
		this.score = 0;
		this.bag = new ArrayList<String>();
	}
	
	// METHODS ------------------------------
	
	public void move(Position destination) {
		this.setPosition(destination);
	}
	
	public void increaseScore(int bonus) {
		score += bonus;
	}
	
	public void increaseTimeLeft(int bonus) {
		timeLeft+= bonus;
	}
	
	public void increaseFightingSkill(int bonus) {
		fightingSkill += bonus;
	}
	
	public void increaseJokingSkill(int bonus) {
		jokingSkill += bonus;
	}
	
	public void addToBag(String item) {
		bag.add(item);
	}
	
	// GETTERS 
	
	public Position getPosition() {
		return position;
	}
	
	public int getXPosition() {
		return position.getY();
	}
	
	public int getYPosition() {
		return position.getX();
	}
	
	public int getScore() {
		return score;
	}
	
	public int getTimeLeft() {
		return timeLeft;
	}
	
	public int getFightingSkill() {
		return fightingSkill;
	}
	
	public int getJokingSkill() {
		return jokingSkill;
	}
	
	public ArrayList<String> getBag() {
		return bag;
	}
	
	// SETTERS
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
}
