import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.security.KeyStore.PrivateKeyEntry;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class PictureDrawer extends JPanel implements Runnable, MouseListener, function, ActionListener {
	private static final long serialVersionUID = 1L;

	// public Enemy enemyBall;
	public Player yellowBall;
	private int mouseClickX;
	private int mouseClickY;
	private int score;
	private int skillCount;
	private long time1, time2, tInterval;
	private int difficulty = 1;
	private boolean scoreBuilt = false;
	private boolean isrampage = false;
	private boolean isTimerOn = false;
	boolean isQuit = false;
	private Timer timer = new Timer(true);

	// Constructor
	public PictureDrawer(int i) {
		this.frame.setSize(1000, 600);
		this.frame.setLocation(100, 100);
		this.frame.setTitle("GULP----");
		this.frame.setDefaultCloseOperation(3);
		this.frame.setResizable(true);
		
		
	
		
		
		// Menu settings
		JMenuBar menubar1 = new JMenuBar();
		JMenuItem item1 = new JMenuItem("BACK 2 MENU");
		JMenuItem item2 = new JMenuItem("QUIT");
		JMenuItem item3 = new JMenuItem("LEADERBOARD");

		JMenu menu1 = new JMenu("MENU");
		this.frame.setJMenuBar(menubar1);
		menubar1.add(menu1);
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		item1.addActionListener(this);
		item1.setActionCommand("r");
		item2.addActionListener(this);
		item2.setActionCommand("q");
		item3.addActionListener(this);
		item3.setActionCommand("l");

		this.frame.add(this);
		setFocusable(true);
		addMouseListener(this);
		// this.enemyBall = new Enemy(120, 50, 60, 60,Color.red);
		this.yellowBall = new Player(500, 300, 50, 50, Color.yellow);
		difficulty = i;
		
		if(difficulty == 0){
			yellowBall.setSpeed(1.8);
			eInitialize();//put enemies on the panel
		}
		
		else if(difficulty == 1){
			yellowBall.setSpeed(1.4);
			eInitialize2();
		}
		
		else if(difficulty == 2){
			yellowBall.setSpeed(1.0);
			eInitialize3();
		}
		
		
		JLabel testLabel = new JLabel("CLick me");
		testLabel.setBounds(600, 600, 50, 30);
		setLayout(null);
		this.add(testLabel);

		Thread nThread = new Thread(this);
		nThread.start();

		this.frame.setVisible(true);
	}// Constructor

	// Enemy Initialize
	Enemy enemies[] = new Enemy[8];

	public void eInitialize() {
		enemies[0] = new Enemy(120, 130, 10, 10, new Color(18));
		enemies[1] = new Enemy(180, 30, 40, 40, new Color(19));
		enemies[2] = new Enemy(550, 77, 70, 70, new Color(20));
		enemies[3] = new Enemy(700, 45, 20, 20, new Color(21));
		enemies[4] = new Enemy(5, 550, 5, 5, new Color(22));
		enemies[5] = new Enemy(300, 400, 55, 55, new Color(17));
		enemies[6] = new Enemy(750, 230, 35, 35, new Color(16));
		enemies[7] = new Enemy(900, 500, 80, 80, new Color(8));
	}
	
	public void eInitialize2(){
		enemies[0] = new Enemy(120, 130, 100, 100, new Color(18));
		enemies[1] = new Enemy(180, 30, 40, 40, new Color(19));
		enemies[2] = new Enemy(550, 77, 70, 70, new Color(20));
		enemies[3] = new Enemy(700, 45, 20, 20, new Color(21));
		enemies[4] = new Enemy(5, 550, 70, 70, new Color(22));
		enemies[5] = new Enemy(300, 400, 55, 55, new Color(17));
		enemies[6] = new Enemy(750, 230, 35, 35, new Color(16));
		enemies[7] = new Enemy(900, 500, 80, 80, new Color(8));
	}
	
	public void eInitialize3(){
		enemies[0] = new Enemy(240, 80, 60, 60, new Color(18));
		enemies[1] = new Enemy(180, 30, 40, 40, new Color(19));
		enemies[2] = new Enemy(550, 77, 70, 70, new Color(20));
		enemies[3] = new Enemy(700, 45, 20, 20, new Color(21));
		enemies[4] = new Enemy(5, 550, 70, 70, new Color(22));
		enemies[5] = new Enemy(300, 400, 55, 55, new Color(17));
		enemies[6] = new Enemy(750, 230, 50, 50, new Color(16));
		enemies[7] = new Enemy(900, 500, 80, 80, new Color(8));
	}

	JFrame frame = new JFrame();
	int gameOver = 0;
	boolean leaderBoarding = false;// Whether the panel is displaying the high
									// scores

	// 菜单栏
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand().charAt(0)) {
		case 'r':
			this.frame.dispose();
			new FirstTry();
			break;
		case 'q':
			this.frame.dispose();
			isQuit = true;
			break;
		case 'l':
			leaderBoarding = true;
			break;
		}

	}

	Font font = new Font("Impact", Font.BOLD, 40);

	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint playerPaint = new GradientPaint(0, 0, yellowBall.getColor(), this.getWidth(), this.getHeight(),
				yellowBall.color);
		GradientPaint enemyPaint = new GradientPaint(0, 0, Color.PINK, this.getWidth(), this.getHeight(), Color.YELLOW);
		GradientPaint gradientPaint = new GradientPaint(0, 0, Color.blue, this.getWidth(), this.getHeight(),
				Color.CYAN);
		g2d.setPaint(gradientPaint);
		;
		g2d.fillRect(0, 0, 1000, 600);

		if (gameOver != 1 && !leaderBoarding) {
			g2d.setPaint(playerPaint);

			drawPlayer(g2d, this.yellowBall);

			for (Enemy eachEnemy : enemies) {
				if (isCollition(yellowBall, eachEnemy) == 2)
					score += 20;
			}
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("SCORE: " + score, 20, 510);
			g.drawString( (3 - skillCount) + "Times left", 20, 550);

			for (Enemy eachEnemy : enemies) {
				eachEnemy.randMove();
				g2d.setPaint(enemyPaint);
				drawPlayer(g2d, eachEnemy);
				gameOver = isCollition(yellowBall, eachEnemy);
			}
//			int m;
//			for(int i=0;i<8;i++){
////				int m=i+1;
//				Avoid(enemies[i],yellowBall);
////				enemies[i].directionX=(int) (enemies[i].directionX+0.001);
////				enemies[i].directionY=(int) (enemies[i].directionY+0.001);
////				while( m<8){
////				eisCollition(enemies[i], enemies[m]);
////				m++;
////				}
//				for(m = 0;m < 8;m++){
//					if(m != i)
//						eisCollition(enemies[i], enemies[m]);
//					else{
//						
//					}
//						
//				}
//			}
		} // end if
			// g.setFont();
		else if (gameOver == 1 && !leaderBoarding) {
			JButton retry = new JButton("RETRY");
			this.setLayout(null);
			retry.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
					new Difficulty();
					
				}
			});
//			retry.setBounds(325, 400, 100, 80);
			this.add(retry);
			gameOver(g2d);
		} 
		else if (leaderBoarding) {
			Scores scores = null;
			
			if(scoreBuilt == false){
			try {
					scores = new Scores();
					scores.displayScores(g2d);
				} catch (IOException e) {
					e.printStackTrace();
				}//catch statement
			}
			else{
				try {
					scores.displayScores(g2d);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}//else if statement

	}
	
	/**
	 * draw player or enemy in panel
	 * 
	 * @param g
	 * @param player
	 * @param color
	 */
	public void drawPlayer(Graphics g, Player player) {
		// g.setColor(color);
		Graphics2D g2d = (Graphics2D) g;
		// g2d.setXORMode(Color.WHITE);
		g2d.fillOval(player.x, player.y, player.w, player.h);
	}



	public void run() {
		//time1 = System.currentTimeMillis();
		while (!isQuit) {
			//if timer is not activating and the plaer is in rampage state
			if(isrampage && !isTimerOn){
				isTimerOn = true;
				timer.schedule(new TimerTask() {
					
					@Override
					public void run() {
						setNoralStat();
						isTimerOn = false;
					}
				}, 5000);
			}
			
			
			
			playerMoveToMouseClick(yellowBall, this); // 黄球向着鼠标点击的方向跑
			try {
				Thread.sleep(5L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			paintImmediately(0, 0, getWidth(), getHeight()); // repaint
																// immediately----------------------------------------------------------------------
			time2 = System.currentTimeMillis();
			tInterval = time2 - time1;
			if (tInterval == 5) {
//				System.out.println("Hey Jude");
				time2 = time1;
			}
		}
	}



	public int getMouseClickX() {
		return this.mouseClickX;
	}

	public void setMouseClickX(int mouseClickX) {
		this.mouseClickX = mouseClickX;
	}

	public int getMouseClickY() {
		return this.mouseClickY;
	}

	public void setMouseClickY(int mouseClickY) {
		this.mouseClickY = mouseClickY;
	}

	/**
	 * mouseClick return getX & getY location
	 */
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2 && skillCount < 3){
			yellowBall.setSpeed(yellowBall.getSpeed() + 1);
			yellowBall.setColor(Color.white);
			//System.out.println("Double clicked");
			skillCount++;
		}
		setMouseClickX(e.getX());
		setMouseClickY(e.getY());
		isrampage = true;
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public void setNoralStat(){
		isrampage = false;
		yellowBall.setColor(Color.yellow);
		if(difficulty == 0){
			yellowBall.setSpeed(1.8);
		}
		else if(difficulty == 1){
			yellowBall.setSpeed(1.4);
		}
		else {
			yellowBall.setSpeed(1.0);
		}
	}
//	//set difficulty
//	public void setDif(int d){
//		difficulty = d;
//			
//	}

}
