package view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EndOfGameDialogBox extends JOptionPane {
	
	    private final String[] options = {"New Game", "Exit", "High Scores"};
	    private final String title = "Game Over";
	    private final String message = "You lost ! \n What is next ?";
	    
	    
	    public EndOfGameDialogBox(JPanel parentPane) {
	    	JOptionPane.showOptionDialog(	parentPane, //parent pane
			    							message,
			    							title,
			    							JOptionPane.YES_NO_CANCEL_OPTION, //type of options
			    							JOptionPane.QUESTION_MESSAGE, // type of message
			    							null, //icon
			    							options,
			    							options[2]);
	    }
	    
	    //jop2.showMessageDialog(null, "Votre sexe est " + sexe[rang], "Etat civil", JOptionPane.INFORMATION_MESSAGE);

}
