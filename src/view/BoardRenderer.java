package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import model.Board;
import model.Position;

@SuppressWarnings("serial")
public class BoardRenderer extends JPanel implements Observer {
	
	// VARIABLES 
	
	// we want a square board with a fixed number of cells 
	int BOARD_HEIGHT;
	int BOARD_WIDTH = BOARD_HEIGHT;
	int NUMBER_CELLS_PER_SIDE = 10;
	int CELL_SIZE = BOARD_HEIGHT/NUMBER_CELLS_PER_SIDE;
	
	TileRenderer[][] tiles = new TileRenderer[NUMBER_CELLS_PER_SIDE][NUMBER_CELLS_PER_SIDE];
	
	// CONSTRUCTORS
	
	public BoardRenderer(int height) {
		BOARD_HEIGHT = height ;
		BOARD_WIDTH = BOARD_HEIGHT;
		this.setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
		this.setLayout(new GridLayout(NUMBER_CELLS_PER_SIDE, NUMBER_CELLS_PER_SIDE));
		
		for (int i=0; i<NUMBER_CELLS_PER_SIDE; i++) {
	 	 	for (int j=0; j<NUMBER_CELLS_PER_SIDE; j++) {
				tiles[i][j] = new TileRenderer();
				tiles[i][j].draw(Color.red, new ImageIcon("src/view/images/p.png"));
	 			this.add(tiles[i][j]);
			}
		}
	}	
	
	// METHODS
	
	public void initBoard() {
		
		
	}
	
	// implement Observer method update
	public void update(Board board, Object object) {
		if (object instanceof Position) {
			Position oldPos = (Position) object;
			Position newPos = board.getActivePosition();
			int oldX = oldPos.getX();
			int oldY = oldPos.getY();
			int newX = oldPos.getX();
			int newY = oldPos.getY();
			tiles[oldX][oldY].redraw();
			tiles[newX][newY].redraw();
			
		}
	}
	
	
	
	// GETTERS
	
	
	//SETTERS
	
}
