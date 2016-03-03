import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Instructions extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Instructions(){
		this.frame.setSize(1000, 600);
		this.frame.setLocation(100, 100);
		this.frame.setDefaultCloseOperation(3);
		this.frame.setResizable(false);
		this.frame.add(this);
		this.frame.setVisible(true);
		
	
		
		JButton toTheNext = new JButton("Alright,I got it");
		//content.add(toTheNext);
		setLayout(null);
		toTheNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == toTheNext){
					frame.dispose();
					new Difficulty();
				}
				
			}
		});
		toTheNext.setBounds(425, 400, 150, 50);//x = 425,y = 400
		//toTheNext.setLocation(400,500);
		//toTheNext.setSize(50,80);
		this.add(toTheNext);
	}

	
	JFrame frame = new JFrame("HOW TO PLAY");
	Font font = new Font("OCR A Std", Font.BOLD, 25);
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		this.setBackground(Color.black);
		g.setFont(font);
		g.setColor(Color.green);
		g.drawString("Move around by clicking at your destination!", 40,100);
		g.drawString("Avoid the bigger ones and try to eat the small ones!", 40, 200);
		g.drawString("Have fun!", 40, 300);
		
		
	}

}
