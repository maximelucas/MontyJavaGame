package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoPanel extends JPanel {
	
	// VARIABLES 
	
	// player state info
	private final JLabel tTimeLeft = new JLabel("Steps left");
	private final JLabel tJokingSkill = new JLabel("Joking skill");
	private final JLabel tFightingSkill = new JLabel("Fighting skill");
	private final JLabel tBag = new JLabel("Bag");
	private final JLabel tScore = new JLabel("Score");
	
	private JLabel lInfoMessage = new JLabel("testtestestsetes");
	
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
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,2));
		panel.setBackground(Color.red);
		// creating the label with the actual value of the variables
		JLabel vTimeLeft = new JLabel("");
		JLabel vJokingSkill= new JLabel("");
		JLabel vFightingSkill = new JLabel("");
		JLabel vBag = new JLabel("");
		JLabel vScore = new JLabel("");
		
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

}
