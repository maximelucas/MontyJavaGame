package view;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	// VARIABLES
	
	private final String NAME = "Monty Java and the Holy Grail";
	
	private final int WINDOW_WIDTH = 1900;
	private final int WINDOW_HEIGHT = 1900;
	
	private final int BOARD_HEIGHT = 500;
	private final int BOARD_WIDTH = 500;
	
//	private final int CELL_SIDE = 40;
//	private final int NUMBER_CELLS_SIDE = BOARD_WIDTH/CELL_SIDE;
	
	private BoardRenderer boardRenderer = new BoardRenderer();
	private MenuPanel menuPanel = new MenuPanel();
	private InfoPanel infoPanel = new InfoPanel();
	
	private KeyListener keyListener;
	private ActionListener actionListener;
	
	// CONSTRUCTOR
	
	public MainWindow() {
		super();
		this.setTitle(NAME);
		this.setLayout(new BorderLayout());
		this.add(boardRenderer, BorderLayout.CENTER);
		this.add(menuPanel, BorderLayout.NORTH);
		this.add(infoPanel, BorderLayout.SOUTH);
        // ensure minimum size show all the components
		this.pack();
        this.setMinimumSize(getSize());
        this.setFocusable(true);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setFocusable(true);
		this.requestFocus();      // Give the panel focus.
		this.setLocationRelativeTo(null); //appear at the center of the screen
		this.setVisible(true);
		}
	
	// METHODS 
	
	public void askExitConfirmation() {
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
	
	public void showHighScore(String highScore) {
		String message = "Current High Score \n"
						+ highScore;
		JOptionPane.showMessageDialog(	this, 
										message, 
										"High Score", 
										JOptionPane.INFORMATION_MESSAGE);

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
