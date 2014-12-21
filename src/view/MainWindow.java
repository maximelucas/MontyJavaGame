package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
//import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {
	
	// VARIABLES
	
	final String NAME = "Monty Java and the Holy Grail";
	
	final int WINDOW_WIDTH = 700;
	final int WINDOW_HEIGHT = 700;
	
	final int BOARD_HEIGHT = 500;
	final int BOARD_WIDTH = 500;
	
	final int MENU_BAR_HEIGHT = 600;
	final int MENU_BAR_WIDTH = WINDOW_WIDTH;
	
	final int CELL_SIDE = 40;
	final int NUMBER_CELLS_SIDE = BOARD_WIDTH/CELL_SIDE;
	
	TileRenderer[][] board = new TileRenderer[NUMBER_CELLS_SIDE][NUMBER_CELLS_SIDE];
	
	// buttons	
	private final MyButton newGame = new MyButton("new game");
	private final MyButton pause = new MyButton("pause");
	private final MyButton reset = new MyButton("reset");
	
	// player state info
	JLabel lTimeLeft = new JLabel("Steps left");
	JTextField tfTimeLeft = new JTextField("");
	
	JLabel lJokingSkill = new JLabel("Joking skill");
	JTextField tfJokingSkill = new JTextField("");
	
	JLabel lFightingSkill = new JLabel("Fighting skill");
	JTextField tfFightingSkill = new JTextField("");
	
	JLabel lBag = new JLabel("Bag");
	JTextField tfBag = new JTextField("");
	
	
	// CONSTRUCTOR
	
	public MainWindow() {
		super();
		this.setTitle(NAME);
		//this.setMinimumSize(WINDOW_WIDTH, WINDOW_HEIGHT);
				
		this.add(makeBoardPanel(), BorderLayout.CENTER);
		this.add(makeMenuPanel(), BorderLayout.NORTH);
		this.add(makeTextPanel(), BorderLayout.SOUTH);
        
		this.pack();
        this.setMinimumSize(getSize());
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible(true);
		}
	
	public JPanel makeBoardPanel() {
		JPanel bpanel = new JPanel();
		bpanel.setBackground(Color.magenta);
		bpanel.add(new BoardRenderer(BOARD_HEIGHT), BorderLayout.CENTER);
		return bpanel;
		
	}
	
	public JPanel makeMenuPanel() {
		//Color myColor = new Color(23, 23, 23);
		JPanel menuPanel = new JPanel();
		//panel.setSize(MENU_BAR_WIDTH, MENU_BAR_HEIGHT);
		menuPanel.setBackground(Color.red);
		menuPanel.setLayout(new FlowLayout());
		menuPanel.add(newGame);
		menuPanel.add(pause);
		menuPanel.add(reset);	
		return menuPanel;
	}
	
	public JPanel makeTextPanel() {
		//Color myColor = new Color(23, 23, 23);
		JPanel panel = new JPanel();
		panel.setBackground(Color.green);
		panel.setLayout(new GridLayout(4,4));
		panel.add(lTimeLeft);
		panel.add(tfTimeLeft);
		panel.add(lJokingSkill);
		panel.add(tfJokingSkill);
		panel.add(lFightingSkill);
		panel.add(tfFightingSkill);
		panel.add(lBag);
		panel.add(tfBag);
		panel.setMaximumSize(new Dimension(10, MENU_BAR_HEIGHT));
		return panel;
	}

	
	// ELEMENTS
	
	public static void main(String[] args) {
		MainWindow fenetre = new MainWindow();
		
	}
	
}
