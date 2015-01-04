package model;

import java.util.Observable;

public class Board extends Observable {
	
	private Player player;
	private Tile[][] grid = new Tile[WIDTH][HEIGHT];
	private Trophy trophy;
	private Position activePosition = initialPosition;
	private boolean gameFinished = false;
	private HighScoreManager highScoreManager = new HighScoreManager();
	// constants 
	static final int WIDTH = 10; // in number of tiles
	static final int HEIGHT = 10; // in number of tiles
	static final int TOTAL_NUMBER_OF_ENEMIES = 4; 
	static final int TOTAL_NUMBER_OF_HELPERS = 4;
	// user input
	String difficultyLevel;
	// initial values
	static final int initialXPosition = 0;
	static final int initialYPosition = 0;
	static final Position initialPosition = new Position(initialXPosition, initialYPosition);
	static final int xTrophy = (int) (WIDTH*0.75);
	static final int yTrophy = (int) (HEIGHT*0.75);
	
	/*
	 * initialise board by creating tiles and placing enemies, helpers, the trophy, and the player
	 * and initialising the variables
	 */
	
	
	public void initBoard() {
		
		player = new Player(initialPosition, difficultyLevel);
		trophy = new Trophy();
		activePosition = initialPosition;
		gameFinished = false;
		highScoreManager.setHighScoreValue();
		
		int numberOfHelpers = 0;
		int numberOfEnemies = 0;
		
		for (int i=0; i<WIDTH; i++) {
			for (int j=0; j<HEIGHT; j++) {
				double random = Math.random();
				if (random < 0.2) {
					grid[i][j] = new Tile("road");
				} else {
					grid[i][j] = new Tile("grass");
				}
			}
		}
		grid[initialXPosition][initialYPosition].setPlayer(player);
		grid[xTrophy][yTrophy].setOpponent(trophy);	
		while (numberOfEnemies < TOTAL_NUMBER_OF_ENEMIES) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].getOpponent() == null) {
				grid[x][y].setOpponent(new Enemy());
				numberOfEnemies ++;
			}
		}
		while (numberOfHelpers < TOTAL_NUMBER_OF_HELPERS) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].getOpponent() == null) {
				grid[x][y].setOpponent(new Helper());
				numberOfHelpers ++;
			}
		}
		setChanged();
		notifyObservers();
	}

	/*
	 * check if game is over
	 */
	public boolean isGameOver() {
		return (player.getStepsLeft() == 0 && trophy.getWon());
	}
	
	
	/*
	 * compute destination from input direction
	 */
	public Position computeDestination(String direction) {
		Position position = player.getPosition();
		Position destination = position;
		switch(direction) {
		case "left": 	
			destination = position.plus(0,-1);
			break;
		case "right": 	
			destination = position.plus(0,+1);
			break;
		case "down": 	
			destination = position.plus(+1,0);
			break;
		case "up": 	
			destination = position.plus(-1,0);
			break;
		default: 
			break;
		}
		
		return destination;
	}
	
	/*
	 * return true if destination is in bounds
	 */
	public boolean isWithinBounds(Position destination) {
		int x = destination.getX();
		int y = destination.getY();
		return (	0 <= x 
				&& 	x < WIDTH 
				&& 	0 <= y 
				&& 	y < HEIGHT);
	}
	
	/*
	 * return true if destination is on a tile adjacent to player
	 */
	public boolean isAdjacent(Position destination) {
		Position position = player.getPosition();
		return(		position.plus(0, +1).equals(destination)
				|| 	position.plus(0, -1).equals(destination)
				|| 	position.plus(+1, 0).equals(destination)
				|| 	position.plus(-1, 0).equals(destination)); 
	}
	
	/*
	 * return true if destination is valid
	 */
	public boolean isValidDestination(Position destination) {
		return (isAdjacent(destination) && isWithinBounds(destination)) ;
	}
	
	/*
	 * given a destination, erase player from old tile, set it on new tile
	 * move player, and notify view
	 */
	public void makeMove(Position destination) {
		if (isValidDestination(destination)) {
			int oldX = player.getPosition().getX();
			int oldY = player.getPosition().getY();
			int newX = destination.getX();
			int newY = destination.getY();
			grid[oldX][oldY].setPlayer(null);
			player.move(destination); 
			grid[newX][newY].setPlayer(player); 
			if (grid[newX][newY].getTerrain() == "grass") {
				player.increaseStepsLeft(-1);
			}
			setChanged(); 
			notifyObservers(); 
			activePosition = player.getPosition();
		}
	}
	
	/*
	 * return true if there is an opponent on the player's tile
	 */
	public boolean isInteractionPossible() {
		int x = player.getPosition().getX();
		int y = player.getPosition().getY();
		return (grid[x][y].isInteractionPossible());
	}
	
	/*
	 * handle interaction between player and oppponent
	 */
	public void handleInteraction(Player player) {
		int x = player.getPosition().getX();
		int y = player.getPosition().getY();
		if (grid[x][y].isInteractionPossible()) {
			grid[x][y].handleInteraction(player);
		}
		setChanged();
		notifyObservers(player);
		if (player.getStepsLeft() == 0 || trophy.getWon()) { // check if game is finished
			gameFinished = true;
			highScoreManager.setScore(player.getScore());
		}
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public Tile[][] getGrid() {
		return grid;
	}
	
	public Tile getTile(int i, int j) {
		return grid[i][j];
	}
	
	public Trophy getTrophy() {
		return trophy;
	}
	
	public Position getActivePosition() {
		return activePosition;
	}
	
	public boolean getGameFinished() {
		return gameFinished;
	}
	
	public HighScoreManager getHighScoreManager() {
		return highScoreManager;
	}
	
	public Tile getActiveTile() {
		int x = activePosition.getX();
		int y = activePosition.getY();
		return grid[x][y];
	}
	
	public void setDifficultyLevel(String level) {
		this.difficultyLevel = level;
	}
	
}
