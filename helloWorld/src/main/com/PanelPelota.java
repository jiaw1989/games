package main.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelPelota extends JPanel implements Runnable{

	//set position for the ball
	private int ballX=10, ballY=200, jug1X=10, jug1Y=100, jug2X=230, jug2Y=100;
	Thread hilo;
	int to_right=5;
	int to_left= -5;
	int to_up=5;
	int to_down=-5;
	int ballWeight, ballHeight;
	//player movement
	boolean player1FlagUp,player1FlagDown, player2FlagUp, player2FlagDown;
	//Scores
	int play1Score =0, play2Score=0;
	
	boolean juego, gameOver;
	
	
	public PanelPelota(){
		juego = true;
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
		this.ballWeight = this.getWidth();
		this.ballHeight = this.getHeight();
		repaint();
		
	}
	
	
	public void keyPressed(KeyEvent evt){
		
		
		switch(evt.getKeyCode()){
		case KeyEvent.VK_W:
			player1FlagUp = true;
			break;
		case KeyEvent.VK_S:
			player1FlagDown = false;
			break;
		
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	

}
