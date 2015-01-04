package view;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {
	
	private final MyButton newGame = new MyButton("New Game");
	private final MyButton highScores = new MyButton("High Scores");
	private final MyButton exit = new MyButton("Exit");
	
	private ActionListener actionListener;
	
	public MenuPanel() {
		setLayout(new FlowLayout());
		setBackground(MainWindow.color2);
		add(newGame);
		add(highScores);
		add(exit);
	}
	
	public ActionListener getActionListener() {
		return actionListener;
	}
	
	public void setActionListener(ActionListener actionListener) {
		this.actionListener = actionListener;
		newGame.addActionListener(actionListener);
		highScores.addActionListener(actionListener);
		exit.addActionListener(actionListener);
	}
	
}
