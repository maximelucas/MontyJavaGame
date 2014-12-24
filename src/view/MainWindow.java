package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	
	//TileRenderer[][] board = new TileRenderer[NUMBER_CELLS_SIDE][NUMBER_CELLS_SIDE];
	

	
	// CONSTRUCTOR
	
	public MainWindow() {
		super();
		this.setTitle(NAME);
		//this.setMinimumSize(WINDOW_WIDTH, WINDOW_HEIGHT);
				
		this.add(makeBoardPanel(), BorderLayout.CENTER);
		this.add(new MenuBar(), BorderLayout.NORTH);
		this.add(new InfoPanel(), BorderLayout.SOUTH);
        
		this.pack();
        this.setMinimumSize(getSize());
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
		}
	
	public JPanel makeBoardPanel() {
		JPanel bpanel = new JPanel();
		bpanel.setBackground(Color.magenta);
		bpanel.add(new BoardRenderer(), BorderLayout.CENTER);
		return bpanel;
		
	}
	

	
	// GETTERS 
	
}
