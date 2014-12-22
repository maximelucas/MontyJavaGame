package model;

import java.util.Observable;

import view.MainWindow;

public class Board extends Observable {
	
	
	public static void main(String[] args) {

    	
    	// View theView = new View();
        //Model theModel = new Model();
        //Controller theController = new Controller(theView,theModel);
        //theView.setVisible(true);
                
		
		Board board = new Board();
		System.out.print("test\n");
		for (int i=0; i<board.WIDTH; i++) {
			for (int j=0; j<board.HEIGHT; j++) {
				if (board.grid[i][j].getPlayer() != null) {
					System.out.print(board.getGrid()[i][j].getPlayer()+" ");
				} else {
				System.out.print(board.getGrid()[i][j].getOpponent()+" ");
				}
			}
			System.out.print("\n");
			
		}
		
		MainWindow gui = new MainWindow();

		board.makeMove(new Position(0,1));
		
		System.out.print("test\n");
		for (int i=0; i<board.WIDTH; i++) {
			for (int j=0; j<board.HEIGHT; j++) {
				if (board.grid[i][j].getPlayer() != null) {
					System.out.print(board.getGrid()[i][j].getPlayer()+" ");
				} else {
				System.out.print(board.getGrid()[i][j].getOpponent()+" ");
				}
			}
			System.out.print("\n");
			
		}
		
	}
	
	// VARIABLES 
	
	final int WIDTH = 20;
	final int HEIGHT = 20;
	final int TOTAL_NUMBER_OF_ENEMIES = 4;
	final int TOTAL_NUMBER_OF_HELPERS = 4;	
	int DIFFICULTY_LEVEL = 1;
	final int initialXPosition = 0;
	final int initialYPosition = 0;
	final Position initialPosition = new Position(initialXPosition, initialYPosition);
	final int xTrophy = (int) (WIDTH*0.75);
	final int yTrophy = (int) (HEIGHT*0.75);
	
	private Player player = new Player(initialPosition, DIFFICULTY_LEVEL);
	private Tile[][] grid = new Tile[WIDTH][HEIGHT];
	private Trophy trophy = new Trophy();
	private Position activePosition = initialPosition;
	
	
	// CONSTRUCTOR
	
	public Board() {
		

		int numberOfHelpers = 0;
		int numberOfEnemies = 0;
		
		// create all the tiles
		for (int i=0; i<WIDTH; i++) {
			for (int j=0; j<HEIGHT; j++) {
				this.grid[i][j] = new Tile("grass");
			}
		}
		// add player
		grid[initialXPosition][initialYPosition].setPlayer(player);
		// add trophy
		grid[xTrophy][yTrophy].setOpponent(trophy);	
		// randomly add enemies (only on even coordinates to spread them)
		while (numberOfEnemies < TOTAL_NUMBER_OF_ENEMIES) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].getOpponent() == null) {
				grid[x][y].setOpponent(new Enemy());
				numberOfEnemies ++;
			} else {
				System.out.print("admn \n");

			}
		}
		// randomly add helpers (only on even coordinates to spread them)
		while (numberOfHelpers < TOTAL_NUMBER_OF_HELPERS) {
			int x = 2*(1 + (int)(Math.random()*(WIDTH/2-1)));
			int y = 2*(1 + (int)(Math.random()*(HEIGHT/2-1)));
			if (grid[x][y].getOpponent() == null) {
				grid[x][y].setOpponent(new Helper());
				numberOfHelpers ++;
			}
		}
	}

	// METHODS 
	
	public boolean isGameOver() {
		return (player.getTimeLeft()==0);
	}
	
	public Position computeDestination(String direction) {
		Position position = player.getPosition();
		switch(direction) {
		case "left" : 	position.add(-1,0);
						break;
		case "right" : 	position.add(+1,0);
						break;
		case "down" : position.add(0,-1);
						break;
		case "up" : 	position.add(0,+1);
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
			this.setChanged();
			this.notifyObservers(player.getPosition()); // sends new position
			activePosition = player.getPosition();
		}
	}
	
	public void handleInteraction(Player player) {
		int x = player.getXPosition();
		int y = player.getYPosition();
		if (grid[x][y].isInteractionPossible()) {
			grid[x][y].handleInteraction(player);
		}
		
	}
	// GETTERS
	
	public Player getPlayer() {
		return player;
	}
	
	public Tile[][] getGrid() {
		return grid;
	}
	
	public Trophy getTrophy() {
		return trophy;
	}
	
	public Position getActivePosition() {
		return activePosition;
	}
	
	// SETTERS 
}
