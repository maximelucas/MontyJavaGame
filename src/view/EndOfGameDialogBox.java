package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EndOfGameDialogBox extends JOptionPane {
	
	    private final String[] options = {"New Game", "High Scores", "Exit"};
	    private final String title = "Game Over";
	    private final String message = "You lost ! \n What is next ?";
	    private int choice;
	    
	    
	    public EndOfGameDialogBox(JPanel parentPane) {
	    	choice = JOptionPane.showOptionDialog(	parentPane, //parent pane
					    							message,
					    							title,
					    							JOptionPane.YES_NO_CANCEL_OPTION, //type of options
					    							JOptionPane.QUESTION_MESSAGE, //type of message
					    							null, //icon
					    							options, //list of buttons
					    							options[0]); //default focus on first button
	    }
	    
	    //jop2.showMessageDialog(null, "Votre sexe est " + sexe[rang], "Etat civil", JOptionPane.INFORMATION_MESSAGE);

	    
	    public int getChoice() {
	    	return choice;
	    }
}
