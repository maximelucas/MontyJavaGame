package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;
import model.Player;
import model.Position;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel implements Observer {
	
	// VARIABLES 
	
	// player state info
	private final JPanel playerInfoPanel = new JPanel();
	private final JLabel tTimeLeft = new JLabel("Steps left");
	private final JLabel tJokingSkill = new JLabel("Joking skill");
	private final JLabel tFightingSkill = new JLabel("Fighting skill");
	private final JLabel tBag = new JLabel("Bag");
	private final JLabel tScore = new JLabel("Score");
	// creating the label with the actual value of the variables
	private JLabel vTimeLeft = new JLabel("");
	private JLabel vJokingSkill= new JLabel("");
	private JLabel vFightingSkill = new JLabel("");
	private JLabel vBag = new JLabel("");
	private JLabel vScore = new JLabel("");
	
	private JLabel lInfoMessage = new JLabel("New game !");
	
	// CONSTRUCTOR
	
	public InfoPanel() {
		// layout
		this.setLayout(new GridLayout(1,2));
		this.add(makePlayerInfoPanel());
		this.add(makeMessagePanel());
	}
	
	// METHODS 
	
	public JPanel makeMessagePanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,1));
		panel.add(lInfoMessage);
		return panel;
	}
	
	public JPanel makePlayerInfoPanel() {
		JPanel panel = playerInfoPanel;
		panel.setLayout(new GridLayout(5,2));
		panel.setBackground(Color.red);
		
		// adding all the labels to the panel
		panel.add(tTimeLeft);
		panel.add(vTimeLeft);
		panel.add(tJokingSkill);
		panel.add(vJokingSkill);
		panel.add(tFightingSkill);
		panel.add(vFightingSkill);
		panel.add(tBag);
		panel.add(vBag);
		panel.add(tScore);
		panel.add(vScore);
		return panel;
	}
	
	@Override
	public void update(Observable observable, Object object) {
		Board board = (Board) observable;
		if (object instanceof Player || object==null) {
			this.setVTimeLeft(board.getPlayer().getTimeLeft());
			this.setVJokingSkill(board.getPlayer().getJokingSkill());
			this.setVFightingSkill(board.getPlayer().getFightingSkill());
			this.setVBag(board.getPlayer().getPosition());
			this.setVScore(board.getPlayer().getScore());
		}
	}
	
	// GETTERS
	
	// SETTERS 
	
	public void setVTimeLeft(int value) {
		this.vTimeLeft.setText(Integer.toString(value));
	}
	
	public void setVJokingSkill(int value) {
		this.vJokingSkill.setText(Integer.toString(value));
	}
	
	public void setVFightingSkill(int value) {
		this.vFightingSkill.setText(Integer.toString(value));
	}

	public void setVBag(Position position) {
//		String content = "";
//		for (String element : bag) {
//			content += element;
//		}
		this.vBag.setText(position.toString());
	}
	
	public void setVScore(int value) {
		this.vScore.setText(Integer.toString(value));
	}
}
