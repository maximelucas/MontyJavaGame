package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Board;
import model.Enemy;
import model.Helper;
import model.Opponent;
import model.Player;
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
	
	public int askSkillChoice(Opponent opponent) {
    	int choice; // 0 joke, 1 fight, 2 magic
    	String message = "";
    	String title = "";
    	String[] options = {""};
    	
    	if (opponent instanceof Helper) {
    		Helper helper = (Helper) opponent;
    		options = helper.getOptions(); 
    		title = "Helper encountered";
    		message = "Someone wants to help you ! \n"+
    				  "Choose an option :";
    	} else if (opponent instanceof Enemy) {
    		Enemy enemy = (Enemy) opponent;
    		options = enemy.getOptions(); 
    		title = "Enemy encountered";
    		message = "This person will not let you pass !\n"+
    				  "Try to beat him with :";
    	}
    	
    	choice = JOptionPane.showOptionDialog(	this, //parent pane
    											message,
    											title,
    											JOptionPane.YES_NO_CANCEL_OPTION, //type of options
    											JOptionPane.QUESTION_MESSAGE, //type of message
    											null, //icon
    											options, //list of buttons
    											options[0]); //default focus on first button
    	return choice;
    }
	
	// implement Observer method update
	public void update(Observable observable, Object object) {
		Board board = (Board) observable;
		
		if (object instanceof Position) {
			Position newPos = (Position) object;
			Position oldPos = board.getActivePosition();
			int oldX = oldPos.getX();
			int oldY = oldPos.getY();
			int newX = newPos.getX();
			int newY = newPos.getY();
			Tile oldTile = board.getTile(oldX, oldY);
			Tile newTile = board.getTile(newX, newY);
			tileRenderers[oldX][oldY].update(oldTile);
			tileRenderers[newX][newY].update(newTile);
			
			for (int i=0; i<NUMBER_CELLS_PER_SIDE; i++) {
		 	 	for (int j=0; j<NUMBER_CELLS_PER_SIDE; j++) {
		 	 		int distanceOld = Position.manhattanDistance(new Position(i,j), oldPos);
		 	 		int distanceNew = Position.manhattanDistance(new Position(i,j), newPos);
		 	 	}
			}
			
		} else if (object==null) {
			System.out.print("ouiii\n");
			Position activePosition = board.getPlayer().getPosition();
			int scope = board.getPlayer().getVisionScope();	
			System.out.print(activePosition);
			System.out.print(scope);
			for (int i=0; i<NUMBER_CELLS_PER_SIDE; i++) {
		 	 	for (int j=0; j<NUMBER_CELLS_PER_SIDE; j++) {
		 	 		
	 	 			tileRenderers[i][j].update(board.getTile(i, j), 
	 	 										new Position(i,j), 
	 	 										activePosition,
	 	 										scope);
	 	 		}
	 	 	}
		} else if (object instanceof Player) {
			;
		}
	}
	

	
	// GETTERS
	
	public Icons getIcons() {
		return icons;
	}
	
	
	//SETTERS
	
}
