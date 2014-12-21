package model;

import java.util.Observable;

public class Board extends Observable {
	
	// VARIABLES 
	
	final int WIDTH = 20;
	final int HEIGHT = 20;
	final int TOTAL_NUMBER_OF_ENEMIES = 4;
	final int TOTAL_NUMBER_OF_HELPERS = 4;	
	int DIFFICULTY_LEVEL = 1;
	final int initialXPosition = 0;
	final int initialYPosition = 0;
	final Position initialPosition = new Position(initialXPosition, initialYPosition);
	
	Player player;
	Tile[][] grid;
	
	// CONSTRUCTOR
	
	public Board() {

		int numberOfHelpers = 0;
		int numberOfEnemies = 0;
		
		//create player
		this.player = new Player(initialPosition, DIFFICULTY_LEVEL);
		// create all the tiles
		for (int i=0; i<WIDTH; i++) {
			for (int j=0; j<HEIGHT; i++) {
				this.grid[i][j] = new Tile("grass");
			}
		}
		// add player
		grid[initialXPosition][initialYPosition].setPlayer(player);
		// randomly add enemies (only on even coordinates to spread them)
		while (numberOfEnemies < TOTAL_NUMBER_OF_ENEMIES) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].getOpponent() != null) {
				grid[x][y].setOpponent(new Enemy());
				numberOfEnemies ++;
			}
		}
		// randomly add helpers (only on even coordinates to spread them)
		while (numberOfHelpers < TOTAL_NUMBER_OF_HELPERS) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].getOpponent() != null) {
				grid[x][y].setOpponent(new Helper());
				numberOfHelpers ++;
			}
		}
		
	}

	// METHODS 
	
	public Position computeDestination(String direction) {
		Position position = player.getPosition();
		switch(direction) {
		case "left" : 	position.add(-1,0);
						break;
		case "right" : 	position.add(+1,0);
						break;
		case "bottom" : position.add(0,-1);
						break;
		case "top" : 	position.add(0,+1);
						break;
		}
		return position;
	}
	
	public boolean isWithinBounds(Position destination) {
		int x = destination.getX();
		int y = destination.getY();
		return (1 <= x 
				&& x <= WIDTH 
				&& 1 <= y 
				&& y <= HEIGHT);
	}
	
	public boolean isAdjacent(Position destination) {
		Position position = player.getPosition();
		return (position.plus(0, +1).equals(destination)
				|| position.plus(0, -1).equals(destination)
				|| position.plus(+1, 0).equals(destination)
				|| position.plus(-1, 0).equals(destination));
	}
	
	public boolean isValidDestination(Position destination) {
		return (isAdjacent(destination) && isWithinBounds(destination)) ;
		
	}
	
	public void makeMove(Position destination) {
		if (isValidDestination(destination)) {
			int oldX = player.getXPosition();
			int oldY = player.getYPosition();
			int newX = destination.getX();
			int newY = destination.getY();
			grid[oldX][oldY].setPlayer(null);
			player.move(destination);
			grid[newX][newY].setPlayer(player);
			this.notifyObservers(player.getPosition());
			if (grid[newX][newY].isInteractionPossible()) {
				grid[newX][newY].handleInteraction(player, choice);
			}
		}
	}
	
	// GETTERS
	
	// SETTERS 
}
