import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {
	File file = new File("Highscores.txt");
	public int scores[] = new int[10];
	private int i = 0;
	private String tmp;
	private int newScore;
	BufferedReader bReader = new BufferedReader(new FileReader(file));
	FileWriter fw = new FileWriter(file);
	FileReader fr = new FileReader(file);
	BufferedWriter bWriter = new BufferedWriter(fw);
	
	
	public FileOperation() throws FileNotFoundException,IOException{
		
	}//explicit constructor to make BufferReader work properly
	
	
	public void readIn() throws IOException{
		for (String line = bReader.readLine(); line != null; line = bReader.readLine()) {
            scores[i] = Integer.parseInt(line);
            System.out.println(scores[i] + " " + line);
            //System.out.println("HHHHHHHHH-------------HHHHHHHHHHHHIIIIIIII");
		}
		
	}//read from the .txt file
	
//	public void writeTo(int s) throws IOException{
//		fw.write(s);
//		fw.write("\n");
//		fw.close();
//	}
	
	public void testScore(){
		System.out.println("Hey!I'm alive!");
		
	}
	
}
