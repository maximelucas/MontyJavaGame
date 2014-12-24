package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Board;
import model.Position;
import model.Tile;

@SuppressWarnings("serial")
public class BoardRenderer extends JPanel implements Observer {
	
	// VARIABLES 
	
	// we want a square board with a fixed number of cells 
	private final int BOARD_HEIGHT = 500;
	private final int BOARD_WIDTH = BOARD_HEIGHT;
	private final int NUMBER_CELLS_PER_SIDE = 10;
	private final int CELL_SIZE = BOARD_HEIGHT/NUMBER_CELLS_PER_SIDE;
	
	TileRenderer[][] tileRenderers = new TileRenderer[NUMBER_CELLS_PER_SIDE][NUMBER_CELLS_PER_SIDE];
	private Icons icons = new Icons();

	
	// CONSTRUCTORS
	
	public BoardRenderer() {
		this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		this.setLayout(new GridLayout(NUMBER_CELLS_PER_SIDE, NUMBER_CELLS_PER_SIDE));
		
		for (int i=0; i<NUMBER_CELLS_PER_SIDE; i++) {
	 	 	for (int j=0; j<NUMBER_CELLS_PER_SIDE; j++) {
				tileRenderers[i][j] = new TileRenderer();
	 			this.add(tileRenderers[i][j]);
			}
		}
	}	
	
	// METHODS
	
	// implement Observer method update
	public void update(Observable observable, Object object) {
		System.out.print("board view notified of initialisation 1 \n");
		Board board = (Board) observable;
		
		if (object instanceof Position) {
			Position oldPos = (Position) object;
			Position newPos = board.getActivePosition();
			int oldX = oldPos.getX();
			int oldY = oldPos.getY();
			int newX = newPos.getX();
			int newY = newPos.getY();
			Tile oldTile = board.getTile(oldX, oldY);
			Tile newTile = board.getTile(newX,  newY);
			tileRenderers[oldX][oldY].update(oldTile);
			tileRenderers[newX][newY].update(newTile);
			
		} else if (object==null) {
			System.out.print("board view notified of initialisation 2\n");
			for (int i=0; i<NUMBER_CELLS_PER_SIDE; i++) {
		 	 	for (int j=0; j<NUMBER_CELLS_PER_SIDE; j++) {
		 	 		System.out.print(""+i);
	 	 			tileRenderers[i][j].update(board.getTile(i, j));
	 	 		}
	 	 	}
		} else {
			System.out.print("\n what happens ?\n");
		}
	}
	
	public void update(Observable observable) {
		System.out.print("board view notified of initialisation 2");
		Board board = (Board) observable;
		for (int i=0; i<NUMBER_CELLS_PER_SIDE; i++) {
	 	 	for (int j=0; j<NUMBER_CELLS_PER_SIDE; j++) {
 	 			tileRenderers[i][j].update(board.getTile(i, j));
 	 		}
 	 	}
	}
	
	// GETTERS
	
	public Icons getIcons() {
		return icons;
	}
	
	
	//SETTERS
	
}
