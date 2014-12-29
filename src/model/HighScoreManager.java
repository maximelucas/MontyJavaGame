package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HighScoreManager {
	
	// VARIABLE 

	private int highScore;
	private int score;
	private String name;
	
	// CONSTRUCTOR 
	
	public HighScoreManager() {
		this.highScore = this.getHighScore();
	}
	
	//  METHODS 
	
	public boolean isHighScore() {
		return (score >= highScore && score>0);
	}
	
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
	
	public int getHighScore() {
		// format name:score
		BufferedReader reader = null;
		try {
			FileReader readFile = new FileReader("highscore.dat");
			reader = new BufferedReader(readFile);
			String line = reader.readLine();
			return Integer.parseInt(line.split(":")[1]);
			
		} catch (Exception e) {
			return Integer.parseInt("-1");
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
	
	public String getHighScoreText() {
		// format name:score
		BufferedReader reader = null;
		try {
			FileReader readFile = new FileReader("highscore.dat");
			reader = new BufferedReader(readFile);
			String line = reader.readLine();
			return line;
			
		} catch (Exception e) {
			return "-1";
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
	
	public void setScore(int score) {
		this.score = score;
	}
}
