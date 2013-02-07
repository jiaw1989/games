package main.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class main extends JFrame {
	
//	private static final long serialVersionUID = 1L;
	
	private JPanel jContentPane = null;
	private PanelPelota panel = null; // this is the panel for the game
	
	private PanelPelota getPanel(){
		if (panel == null){
			panel = new PanelPelota(); // the panel is created
		}
		return panel;
	}
	
	
	public Main(){	
		super();
		initialize();
		
		this.addKeyListener(new KeyAdapter(){
			
			public void KeyPressed(KeyEvent evt){
				formKeyPressed(evt);
				
			}
			//key release
			public void KeyReleased(KeyEvent evt){
				formKeyReleased(evt);
				
			}
		});
		
		
	}
	private void formKeyPressed(KeyEvent evt){
		panel.keyPressed(evt);
	}
	private void formKeyReleased(KeyEvent evt){
		panel.keyPressed(evt);
	}
	
	private void initialize(){
		
	}
}


