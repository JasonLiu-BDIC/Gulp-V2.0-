import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JPanel;

public class Scores extends JPanel {
	
	private int highScores[] = new int[]{0,0,0,0,0,0,0,0,0,0};

	
	void hiScrIni(int scr){
	for(int e = 0;e < highScores.length ;e++){
		if(highScores[e] < scr)
			e++;
		else
			highScores[e] = scr;
	}
	}
	public int getHighScrs(int i){
		return highScores[i];
	}
	
	
	
	
	public void displayScores(Graphics g){
    	int position = 50;
    	int i;
    	g.setColor(Color.GRAY);
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	g.setColor(Color.GREEN);
    	g.setFont(new Font("OCR A Std", Font.BOLD, 40));
//		g.drawString("NO.1"+getHighScrs(0), 300, position);
//		g.drawString("NO.2"+getHighScrs(1), 300, position);
//		g.drawString("NO.3"+getHighScrs(2), 300, position);
//		g.drawString("NO.4"+getHighScrs(3), 300, position);
//		g.drawString("NO.5"+getHighScrs(4), 300, position);
//		g.drawString("NO.6"+getHighScrs(5), 300, position);
//		g.drawString("NO.7"+getHighScrs(6), 300, position);
//		g.drawString("NO.8"+getHighScrs(7), 300, position);
//		g.drawString("NO.9"+getHighScrs(8), 300, position);
//		g.drawString("NO.10"+getHighScrs(9), 300, position);
		for(i = 1;i <= 10;i++){
			g.drawString("NO." + i + ":"+getHighScrs(i -1), 300, position);
			position +=50;
		}
}
 
    
}
