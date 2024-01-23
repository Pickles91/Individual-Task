package playball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tester implements ActionListener, KeyListener {

    JFrame frame;
    static Timer t;
    boolean play = true;
    static boolean go = false;
    JPanel c = new JPanel();
    JButton start = new JButton("START");
    JButton stop = new JButton("STOP");
    JButton updn = new JButton("UP & DN");
    JButton ltrt = new JButton("LT & RT");
    static JLabel scoreLabel;
    DrawPanel d = new DrawPanel();
    int score = 0;

 
    public Tester() {
        frame = new JFrame("Ball Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, d);

        c.setPreferredSize(new Dimension(100,100));
        frame.getContentPane().add(BorderLayout.NORTH, c);
        
        scoreLabel = new JLabel("Score: " + score);
        
        c.add(start);
        c.add(stop);
        c.add(updn);
        c.add(ltrt);
        c.add(scoreLabel);
        
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(300, 400);
        frame.setLocation(375, 55);
        start.addActionListener(this);
        stop.addActionListener(this);
        updn.addActionListener(this);
        ltrt.addActionListener(this);
        t = new Timer(5, this);
        t.start();
        
        start.setFocusable(false);
        stop.setFocusable(false);
        updn.setFocusable(false);
        ltrt.setFocusable(false);
        
        frame.addKeyListener(this);
        frame.setFocusable(true);
        frame.requestFocusInWindow();
    }
    
    public void doit() {
    	System.out.println("moving it");
    	d.moveIt();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            if (go) {
                doit();
            }
        } else if (e.getSource() instanceof JButton) {
        	
            JButton clicked = (JButton) e.getSource();
            
            if (clicked.getText().equals("START")) {
                go = true;
            } else if (clicked.getText().equals("STOP")) {
                go = false;
                
                
                
            } else if (clicked.getText().equals("UP & DN")) {
                if (d.up) {
                    d.up = false;
                    d.down = true; 
                } else {
                    d.up = true; 
                    d.down = false;
                }
                
            } else if (clicked.getText().equals("LT & RT")) {
                if (d.left) {
                    d.left = false;
                    d.right = true;
                } else {
                    d.left = true; 
                    d.right = false;
                }
            }
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		 int keyCode = e.getKeyCode();

	        if (keyCode == KeyEvent.VK_UP) {
	            // Handle up key press
	            d.up = true;
	            d.down = false;
	            System.out.println("Up Clicked");
	        } else if (keyCode == KeyEvent.VK_DOWN) {
	            // Handle down key press
	            d.up = false;
	            d.down = true;
	            System.out.println("Down Clicked");
	        } else if (keyCode == KeyEvent.VK_LEFT) {
	            // Handle left key press
	            d.left = true;
	            d.right = false;
	            System.out.println("Left Clicked");
	        } else if (keyCode == KeyEvent.VK_RIGHT) {
	            // Handle right key press
	            d.left = false;
	            d.right = true;
	            System.out.println("Right Clicked");
	        }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
