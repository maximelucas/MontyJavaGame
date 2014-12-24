package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

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
	private MenuBar menuBar = new MenuBar();
	private InfoPanel infoPanel = new InfoPanel();
	
	private KeyListener keyListener;
	
	// CONSTRUCTOR
	
	public MainWindow() {
		super();
		this.setTitle(NAME);
		this.add(boardRenderer, BorderLayout.CENTER);
		this.add(menuBar, BorderLayout.NORTH);
		this.add(infoPanel, BorderLayout.SOUTH);
        // ensure minimum size show all the components
		this.pack();
        this.setMinimumSize(getSize());
        this.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        this.setFocusable(true);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
		}
	
	// GETTERS 
	
	public BoardRenderer getBoardRenderer() {
		return boardRenderer;
	}
	
	public InfoPanel getInfoPanel() {
		return infoPanel;
	}
	
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
}
