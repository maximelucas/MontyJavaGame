package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Enemy;
import model.Helper;
import model.Opponent;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	// VARIABLES
	
	private final String NAME = "Monty Java and the Holy Grail";
	
	private final int WINDOW_WIDTH = 700;
	private final int WINDOW_HEIGHT = 700;
	
	private final int BOARD_HEIGHT = 500;
	private final int BOARD_WIDTH = 500;
	
	private final int MENU_BAR_HEIGHT = 600;
	private final int MENU_BAR_WIDTH = WINDOW_WIDTH;
	
	private final int CELL_SIDE = 40;
	private final int NUMBER_CELLS_SIDE = BOARD_WIDTH/CELL_SIDE;
	
	private BoardRenderer boardRenderer = new BoardRenderer();
	private MenuPanel menuPanel = new MenuPanel();
	private InfoPanel infoPanel = new InfoPanel();
	
	private KeyListener keyListener;
	private ActionListener actionListener;
	
	// CONSTRUCTOR
	
	public MainWindow() {
		super();
		this.setTitle(NAME);
		this.add(boardRenderer, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.add(infoPanel, BorderLayout.SOUTH);
        // ensure minimum size show all the components
		this.pack();
        this.setMinimumSize(getSize());
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setFocusable(true);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
		}
	
	// METHODS 
	
	public void askExitConfirmation() {
		JOptionPane jop = new JOptionPane();    	
		int choice = JOptionPane.showConfirmDialog(	this, 
													"Do you really want to close ?",
													"Confirm exit ? ", 
													JOptionPane.YES_NO_CANCEL_OPTION, 
													JOptionPane.QUESTION_MESSAGE);
		if (choice==JOptionPane.YES_OPTION) {
			// close and clean everything
			dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		}
	}
	
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
	
	// GETTERS 
	
	public BoardRenderer getBoardRenderer() {
		return boardRenderer;
	}
	
	public InfoPanel getInfoPanel() {
		return infoPanel;
	}
	
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
	
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
	}
}
