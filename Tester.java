package playball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tester implements ActionListener {

    JFrame frame;
    Timer t;;
    DrawPanel d = new DrawPanel();
    boolean play = true;
    boolean go = false;
    JPanel c = new JPanel();
    JButton start = new JButton("START");
    JButton stop = new JButton("STOP");
    JButton updn = new JButton("UP & DN");
    JButton ltrt = new JButton("LT & RT");
 
    public Tester() {
        frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(BorderLayout.CENTER, d);

        c.setPreferredSize(new Dimension(100,100));
        frame.getContentPane().add(BorderLayout.NORTH, c);
        
        c.add(start);
        c.add(stop);
        c.add(updn);
        c.add(ltrt);
        
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
                    // If currently moving upward, stop upward movement
                    d.up = false;
                    d.down = true; // Start moving downward
                } else {
                    // If currently moving downward, stop downward movement
                    d.up = true; // Start moving upward
                    d.down = false;
                }
            } else if (clicked.getText().equals("LT & RT")) {
                if (d.left) {
                    // If currently moving left, stop left movement
                    d.left = false;
                    d.right = true; // Start moving right
                } else {
                    // If currently moving right, stop right movement
                    d.left = true; // Start moving left
                    d.right = false;
                }
            }
        }
    }
}
