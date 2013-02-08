package main.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class PanelPelota extends JPanel implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//set position for the ball and player1 ,2 pad
	private int ballX=10, ballY=200, jug1X=10, jug1Y=100, jug2X=230, jug2Y=100;
	Thread hilo;
	int to_right=5;
	int to_left= -5;
	int to_up=5;
	int to_down=-5;
	int ballWidth, ballHeight;
	//player movement
	boolean player1FlagUp,player1FlagDown, player2FlagUp, player2FlagDown;
	//Scores
	int play1Score =0, play2Score=0;
	
	boolean game, gameOver;
	
	
	public PanelPelota(){
		game = true;
		hilo = new Thread(this);
		hilo.start();
		
	}
	
	
	//draw balls
	public void paintComponent(Graphics gc){
		setOpaque(false);
		super.paintComponent(gc);
		
		//draw ball
		gc.setColor(Color.black);
		gc.fillOval(ballX, ballY, 8, 8);
		
		//draw pad
		gc.fillRect(jug1X,jug1Y,10,25);
		gc.fillRect(jug2X,jug2Y,10,25);
		
		//Draw scores;
		gc.drawString("Player1: "+play1Score,25,10);
		gc.drawString("Player2: "+play2Score,150,10);
		
		if(gameOver)
				gc.drawString("Game over",100,125);
		
	}
	
	//set position for the ball
	public void positionBall(int nx, int ny){
		ballX = nx;
		ballY = ny;
		ballWidth = this.getWidth();
		ballHeight = this.getHeight();
		repaint();
		
	}
	
	
	public void keyPressed(KeyEvent evt){
		
		
		switch(evt.getKeyCode()){
		case KeyEvent.VK_W:
			player1FlagUp = true;
			break;
		case KeyEvent.VK_S:
			player1FlagDown = true;
			break;
		//player2 movement
		case KeyEvent.VK_UP:
			player2FlagUp = true;
			break;
		case KeyEvent.VK_DOWN:
			player2FlagDown = true;
			break;
		}
	}
	//check when key released
	public void keyReleased(KeyEvent evt){
		
		
		switch(evt.getKeyCode()){
		case KeyEvent.VK_W:
			player1FlagUp = false;
			break;
		case KeyEvent.VK_S:
			player1FlagDown = false;
			break;
		
		//player2 movement
		case KeyEvent.VK_UP:
			player2FlagUp = false;
			break;
		case KeyEvent.VK_DOWN:
			player2FlagDown = false;
			break;
		}
	}
	//move player1
	public void movePlayer1(){
		if(player1FlagUp == true && jug1Y>=0)
			jug1Y +=to_down;
		if(player1FlagDown == true && jug1Y <=(this.getHeight()-25))
			jug1Y+= to_up;
		positionPlayer1(jug1X,jug1Y);
		
	}
	public void movePlayer2(){
		if(player2FlagUp == true && jug2Y>=0)
			jug2Y +=to_down;
		if(player2FlagDown == true && jug2Y <=(this.getHeight()-25))
			jug2Y+= to_up;
		positionPlayer2(jug2X,jug2Y);
		
	}
	public void positionPlayer1(int x, int y){
			this.jug1X=x;
			this.jug1Y=y;
			repaint();
	}
	public void positionPlayer2(int x, int y){
		this.jug2X=x;
		this.jug2Y=y;
		repaint();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean leftRight = false;
		boolean upDown = false;
		
		
		while(true){
			
			if(game){
			//move the ball from left to right
			if(leftRight){
				ballX += to_right;
				if(ballX >=(ballWidth -8))
					leftRight = false;
				}else{
					ballX += to_left;
					if(ballX <=0)
						leftRight = true;
							
			}
			
			
			//move the ball from up to down
			if(upDown){
				ballY += to_up;
				if(ballY >=(ballHeight -8))
					upDown = false;
				}else{
					ballY += to_down;
					if(ballY <=0)
						upDown = true;
								
			}
			//reposition the ball
			positionBall(ballX,ballY);
			
			//Delay
			try{ Thread.sleep(50);
			}catch(InterruptedException ex){		
			}
			
			movePlayer1();
			movePlayer2();
			
			if(ballX>=(ballWidth -8))
				play1Score++;
			if(ballX ==0)
				play2Score++;
			
			if(play1Score == 6 || play2Score ==6){
				gameOver= true;
				game = false;
			}
			
			
			//when ball hit player1 pad
			if(ballX == jug1X+10 && ballY >= jug1Y && ballY<=(jug1Y+25) )
				leftRight = true;
			
			//when ball hit player2 pad
			if(ballX == jug2X-5 && ballY >= jug2Y && ballY<=(jug2Y+25) )
				leftRight = false;
			
		}
			
			
		}	
			
	}
		
}
	


