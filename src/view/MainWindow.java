package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	private final String NAME = "Monty Java and the Holy Grail";
	
	protected final static Color color1 = new Color(118,137,169);
	protected final static Color color2 = new Color(44,71,112);
	protected final static Color color3 = new Color(5,25,56);
	
	private BoardRenderer boardRenderer = new BoardRenderer();
	private MenuPanel menuPanel = new MenuPanel();
	private InfoPanel infoPanel = new InfoPanel();
	
	public MainWindow() {
		super();
		setTitle(NAME);
		setLayout(new BorderLayout());
		add(boardRenderer, BorderLayout.CENTER);
		add(menuPanel, BorderLayout.NORTH);
		add(infoPanel, BorderLayout.SOUTH);
        // ensure minimum size show all the components
		pack();
        setMinimumSize(getSize());
        setFocusable(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setFocusable(true);
		requestFocus();      	
		setLocationRelativeTo(null); 
		setVisible(true);
		}
	
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
	
	public int askEndOfGameChoice() {
		int choice;
		String[] options = {"New Game", "High Scores", "Exit"};
    	choice = JOptionPane.showOptionDialog(	this, 
								    			"What is next ?",
												"End of Game",
												JOptionPane.YES_NO_CANCEL_OPTION, 
												JOptionPane.QUESTION_MESSAGE, 
												null,
												options,
												options[0]);
    	return choice;
    	}
	
	public String askDifficulty() {
		String[] options = {"easy", "medium", "difficult", "impossible"};
		int buttonPressed;
    	buttonPressed = JOptionPane.showOptionDialog(	this, 
    													"Please choose the difficulty",
														"Welcome to the Holy Grail quest !",
														JOptionPane.YES_NO_CANCEL_OPTION,														JOptionPane.QUESTION_MESSAGE, //type of message
														null, 
														options,
														options[0]);
    	return options[buttonPressed];
	}
	
	public BoardRenderer getBoardRenderer() {
		return boardRenderer;
	}
	
	public InfoPanel getInfoPanel() {
		return infoPanel;
	}
	
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
}