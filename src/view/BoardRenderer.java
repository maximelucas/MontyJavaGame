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
	
	private final int NUMBER_CELLS_PER_SIDE = 10;
	private final int CELL_SIZE = 45; //in px
	private final int BOARD_SIZE = CELL_SIZE*NUMBER_CELLS_PER_SIDE;
	
	TileRenderer[][] tileRenderers = new TileRenderer[NUMBER_CELLS_PER_SIDE][NUMBER_CELLS_PER_SIDE];
	private Icons icons = new Icons();

	public BoardRenderer() {
		setPreferredSize(new Dimension(BOARD_SIZE, BOARD_SIZE));
		setLayout(new GridLayout(NUMBER_CELLS_PER_SIDE, NUMBER_CELLS_PER_SIDE));
		setBackground(MainWindow.color3);
		for (int i = 0; i < NUMBER_CELLS_PER_SIDE; i++) {
	 	 	for (int j = 0; j < NUMBER_CELLS_PER_SIDE; j++) {
				tileRenderers[i][j] = new TileRenderer();
				add(tileRenderers[i][j]);
			}
		}
	}	
	
	
	public String askSkillChoice(Opponent opponent) {
    	int buttonPressed; // 0 joke, 1 fight, 2 steps
    	String choice = "";
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
    	
    	buttonPressed = JOptionPane.showOptionDialog(	this, //parent pane
    											message,
    											title,
    											JOptionPane.YES_NO_CANCEL_OPTION, //type of options
    											JOptionPane.QUESTION_MESSAGE, //type of message
    											null, //icon
    											options, //list of buttons
    											options[0]); //default focus on first button
    	switch(buttonPressed) {
    	case 0:
    		choice = "joke";
    		break;
    	case 1:
    		choice = "fight";
    		break;
    	case 2: 
    		choice = "steps";
    		break;
    	default:
    		;
    	}
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
			Position activePosition = board.getPlayer().getPosition();
			int scope = board.getPlayer().getVisionScope();	
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
	
	public Icons getIcons() {
		return icons;
	}
}
