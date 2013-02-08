package main.com;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame {
	
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
		this.setResizable(false);
		//position of the window
		this.setBounds(new Rectangle(312,184,250,250));
		this.setMinimumSize(new Dimension(250,250));
		this.setMaximumSize(new Dimension(250,250));
		this.setContentPane(getJContentPane());
		this.setTitle("Pong");
		
		
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Main thisClass = new Main();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}
}