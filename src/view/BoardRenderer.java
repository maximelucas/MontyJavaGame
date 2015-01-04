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
import model.Position;

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
	
	/*
	 * show dialog bow when interaction occurs, 
	 * to ask for user's interaction choice
	 * return string choice
	 */
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
    	
    	buttonPressed = JOptionPane.showOptionDialog(	this, 
		    											message,
		    											title,
		    											JOptionPane.YES_NO_CANCEL_OPTION, 
		    											JOptionPane.QUESTION_MESSAGE, 
		    											null, 
		    											options, 
		    											options[0]);
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
	
	/*
	 * update the board display when turn is played
	 */
	public void update(Observable observable, Object object) {
		Board board = (Board) observable;
		
		if (object==null) {
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
		}
	}
	
	public Icons getIcons() {
		return icons;
	}
}
