package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighScoreManager {
	
	// VARIABLE 

	private String highScore; // format name:highscore
	private int highScoreValue; //just the value of the high score
	private int score; //current score
	
	// CONSTRUCTOR 
	
	public HighScoreManager() {
		this.highScore = this.getHighScore();
		this.highScoreValue = Integer.parseInt(highScore.split(":")[1]);
	}
	
	//  METHODS 
	
	/*
	 * return true if current score beats high score
	 */
	public boolean isHighScore() {
		return (score >= highScoreValue && score > 0);
	}
	
	/*
	 * write new high score to file
	 */
	public void storeScore(String name) {
		File scoreFile = new File("highscore.dat");
		if (!scoreFile.exists()) {
			try {
				scoreFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		BufferedWriter writer = null;
		try {
			FileWriter writeFile = new FileWriter(scoreFile);
			writer = new BufferedWriter(writeFile);
			writer.write(name+":"+score+"\n");
		} catch (Exception e) {
			;
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					;
				}
			}
		}
	}
	
	/*
	 * get existing high score from file
	 */
	public String getHighScore() {
		// format name:score
		BufferedReader reader = null;
		try {
			FileReader readFile = new FileReader("highscore.dat");
			reader = new BufferedReader(readFile);
			String line = reader.readLine();
			return line;
			
		} catch (Exception e) {
			return "name:-1";
		} finally {
			if (reader!=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void setHighScore() {
		this.highScore = this.getHighScore();
	}
	
	public void setHighScoreValue() {
		this.highScoreValue = Integer.parseInt(this.getHighScore().split(":")[1]);
	}
	
	public void setScore(int score) {
		this.score = score;
	}
}
