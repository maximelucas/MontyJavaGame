package model;

public class Board {
	
	// VARIABLES 
	
	final int WIDTH = 20;
	final int HEIGHT = 20;
	final int TOTAL_NUMBER_OF_ENEMIES = 4;
	final int TOTAL_NUMBER_OF_HELPERS = 4;	
	int DIFFICULTY_LEVEL = 1;
	final Position initialPosition = new Position(1,1);
	
	Player player;
	Tile[][] grid;
	
	// CONSTRUCTOR
	
	// METHODS 
	
	public Board() {
		this.player = new Player(initialPosition, DIFFICULTY_LEVEL);
		
		int numberOfEnemies = 0;
		int numberOfHelpers = 0;
		// create all the tiles
		for (int i=1; i <= WIDTH; i++) {
			for (int j=1; j <= HEIGHT; i++) {
				this.grid[i][j] = new Tile("grass");
			}
		}
		// add player
		grid[1][1].setPlayer(player);
		// randomly add enemies (only on even coordinates to spread them)
		while (numberOfEnemies <= TOTAL_NUMBER_OF_ENEMIES) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].opponent != null) {
				grid[x][y].setOpponent(new Enemy());
				numberOfEnemies ++;
			}
		}
		while (numberOfHelpers <= TOTAL_NUMBER_OF_HELPERS) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].opponent != null) {
				grid[x][y].setOpponent(new Helper());
				numberOfHelpers ++;
			}
		}
		
	}
	
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
	
	public boolean isDestinationWithinBounds(Position destination) {
		int x = destination.getX();
		int y = destination.getY();
		return (1 <= x 
				&& x <= WIDTH 
				&& 1 <= y 
				&& y <= HEIGHT);
	}
	
	public boolean isDestinationAdjacent(Position destination) {
		Position position = player.getPosition();
		return (position.plus(0, +1).equals(destination)
				|| position.plus(0, -1).equals(destination)
				|| position.plus(+1, 0).equals(destination)
				|| position.plus(-1, 0).equals(destination));
	}
	
	public boolean isValidDestination(Position destination) {
		return (isDestinationAdjacent(destination) && isDestinationWithinBounds(destination)) ;
		
	}
	
	public void updateBoard(Position destination) {
		int oldX = player.getXPosition();
		int oldY = player.getYPosition();
		int newX = destination.getX();
		int newY = destination.getY();
		grid[oldX][oldY].setPlayer(null);
		player.move(destination);
		grid[newX][newY].setPlayer(player);
	}
	
	// GETTERS
	
	// SETTERS 
}
