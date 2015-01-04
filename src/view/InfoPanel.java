package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Board;
import model.Player;

@SuppressWarnings("serial")
public class InfoPanel extends JPanel implements Observer {
	
	// player state info
	private final JPanel playerInfoPanel = new JPanel();
	private final JLabel tTimeLeft = new JLabel("Steps left");
	private final JLabel tJokingSkill = new JLabel("Joking skill");
	private final JLabel tFightingSkill = new JLabel("Fighting skill");
	private final JLabel tScore = new JLabel("Score");
	// creating the label with the actual value of the variables
	private JLabel vTimeLeft = new JLabel("");
	private JLabel vJokingSkill= new JLabel("");
	private JLabel vFightingSkill = new JLabel("");
	private JLabel vScore = new JLabel("");
	
	public InfoPanel() {
		setLayout(new GridLayout(1,2));
		add(makePlayerInfoPanel());
		add(makeMessagePanel());
	}
	
	public JPanel makeMessagePanel() {
		JPanel panel = new JPanel();
		panel.setBackground(MainWindow.color2);
		panel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, MainWindow.color2));
		return panel;
	}
	
	public JPanel makePlayerInfoPanel() {
		JPanel panel = playerInfoPanel;
		panel.setLayout(new GridLayout(4,2));
		panel.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, MainWindow.color1));
		panel.setBackground(MainWindow.color1);
		panel.setForeground(MainWindow.color3);
		
		panel.add(tTimeLeft);
		panel.add(vTimeLeft);
		panel.add(tJokingSkill);
		panel.add(vJokingSkill);
		panel.add(tFightingSkill);
		panel.add(vFightingSkill);
		panel.add(tScore);
		panel.add(vScore);
		return panel;
	}
	
	/*
	 * update player info after each turn 
	 */
	@Override
	public void update(Observable observable, Object object) {
		Board board = (Board) observable;
		if (object instanceof Player || object==null) {
			this.setVTimeLeft(board.getPlayer().getStepsLeft());
			this.setVJokingSkill(board.getPlayer().getJokingSkill());
			this.setVFightingSkill(board.getPlayer().getFightingSkill());
			this.setVScore(board.getPlayer().getScore());
		}
	}
	
	public void setVTimeLeft(int value) {
		this.vTimeLeft.setText(Integer.toString(value));
	}
	
	public void setVJokingSkill(int value) {
		this.vJokingSkill.setText(Integer.toString(value));
	}
	
	public void setVFightingSkill(int value) {
		this.vFightingSkill.setText(Integer.toString(value));
	}

	public void setVScore(int value) {
		this.vScore.setText(Integer.toString(value));
	}
}
