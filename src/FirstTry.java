import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * 
 * @author BIG BROTHER
 *
 */

/**
 * 
 * FirstTry 整个游戏的主窗口
 *
 */
public class FirstTry extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/**
	 * Constructor,set frame size,layout & BG color
	 */
	public FirstTry() {
		this.setSize(800,600);
		this.setTitle("Mr.Gulp");
		this.setLocation(100, 100);
		this.setLayout(null);
		//this.setBackground(Color.getHSBColor(100, 30, 30));
		ImageIcon img = new ImageIcon("title3.jpg");
		JLabel imgLabel = new JLabel(img);
		this.getLayeredPane().add(imgLabel, new Integer(Integer.MIN_VALUE));
		
		imgLabel.setBounds(0,0,this.getWidth(),this.getHeight()+20);
		Container cp = this.getContentPane();
		cp.setLayout(null);
		((JPanel) cp).setOpaque(false); 
		
		JPanel jp = (JPanel)this.getContentPane();
//		JPanel jp = new JPanel(){
//			public void paint(Graphics g) {
//				super.paint(g);
//				Toolkit tool = this.getToolkit();
//				Image img =tool.getImage("Gulp_title.jpg");
//				//super.paintComponent(g);
//				g.drawImage(img, 50, 50, 50,20,this);
//			}
//		};
		
		
		/**
		 * panel set to transparent
		 */
		//jp.setOpaque(false);

		JButton n = new JButton("close");
		JButton jason = new JButton("Lets move the circle!");
		jason.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == jason){
					FirstTry.this.dispose();
					//frame disposed and calls new pictureDrawer
					new Instructions();
				}
			}
		});
		
		n.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == n) {
				System.exit(0);
				}
			}
		});
		
		n.setLocation(375, 370);
		n.setSize(50, 50);
		jason.setLocation(325,300);
		jason.setSize(150, 50);
		this.add(jason);
		this.add(n);
		this.setResizable(true);
		this.setVisible(true);
	}
	
	

	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		FirstTry a = new FirstTry();
	}
		
}
