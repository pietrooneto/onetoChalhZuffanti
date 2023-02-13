package testlab;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Controller{

	private char code;
	
	JFrame frame = new JFrame("Input");
	final JPanel panel= new JPanel();
    final JLabel label1 = new JLabel();
    final JLabel label2 = new JLabel("W | A | D | S | E FRENO");
    private int speed;

	
	public void createWindow() {
		
		frame.setSize(600, 100);
		frame.setVisible(true);
		panel.add(label1);
		panel.add(label2);
	    label1.setHorizontalAlignment(JLabel.CENTER);
	    label1.setVerticalAlignment(JLabel.CENTER);
	    label2.setVerticalAlignment(JLabel.BOTTOM);
	    label2.setVerticalTextPosition(JLabel.BOTTOM);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(panel);
		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				label1.setText("Key: "+e.getKeyChar() + " | velocità: " + Integer.toString(speed));
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				code = (char)(e.getKeyChar());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				code = ' ';
			}
			
		});
		
	}
	
	public char getCode() {
		
		return code;
	}
	
	
	public void recieveSpeed(int speed) {
		
		this.speed = speed;
		
		
	}
	
}