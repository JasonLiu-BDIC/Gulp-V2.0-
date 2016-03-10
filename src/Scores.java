import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JPanel;

public class Scores extends JPanel {
	private int n;
	private int highScores[] = new int[10];
	public Scores() throws IOException{
	}
	
	

	public int getHighScrs(int i) throws FileNotFoundException, IOException{
		FileOperation fileOperation = new FileOperation();
		fileOperation.readIn();
		fileOperation.testScore();
		for(n = 0;n < 10;n++){
			highScores[n] = fileOperation.scores[n];
		}
		return highScores[i];
	}

	
	public void displayScores(Graphics g) throws FileNotFoundException, IOException{
		
		int position = 50;
    	int i;
    	g.setColor(Color.GRAY);
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	g.setColor(Color.GREEN);
    	g.setFont(new Font("OCR A Std", Font.BOLD, 40));
		for(i = 1;i <= 10;i++){
			g.drawString("NO." + i + ":"+getHighScrs(i - 1), 300, position);
			position +=50;
		}
}
 
    
}
