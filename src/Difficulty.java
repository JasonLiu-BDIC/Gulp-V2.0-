import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Difficulty extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public Difficulty(){
		this.frame.setSize(1000, 600);
		this.frame.setLocation(100, 100);
		this.frame.setDefaultCloseOperation(3);
		this.frame.setResizable(false);
		this.frame.add(this);
		this.frame.setVisible(true);
		JButton easy = new JButton("EASY");
		JButton medium = new JButton("MEDIUM");
		JButton hard = new JButton("HARD");
		setLayout(null);
		
		easy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PictureDrawer pd = new PictureDrawer(0);
//				pd.setDif(0);
				
			}
		});
		medium.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PictureDrawer pd = new PictureDrawer(1);
//				pd.setDif(1);
				
			}
		});
		hard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				PictureDrawer pd = new PictureDrawer(2);
//				pd.setDif(2);
			}
		});
		easy.setBounds(325, 200, 100,80);
		medium.setBounds(325,300,100,80);
		hard.setBounds(325, 400, 100, 80);
		
		this.add(easy);
		this.add(medium);
		this.add(hard);
		
	}
	
	
	JFrame frame = new JFrame("SELECT A DIFFICULTY");
	Font font = new Font("OCR A Std", Font.BOLD, 20);
	@Override
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.black);
		g.setFont(font);
		g.setColor(Color.green);
		g.drawString("SELECT A DIFFICULTY!", 340,100);
		g.drawString("< For rookies!", 450, 240);
		g.drawString("< You think you're good enough?", 450, 340);
		g.drawString("< Seriously?", 450, 440);
		
	}
}
