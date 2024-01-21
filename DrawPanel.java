package playball;

import javax.swing.*;
import java.awt.*;
class DrawPanel extends JPanel {
	
    private int oneX = 7;
    private int oneY = 7;
    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;


    public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.RED);
        g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
        g.setColor(Color.WHITE);
        g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
        g.setColor(Color.GREEN);
        g.fillOval(oneX, oneY, 16, 16);

    }
   



    public void moveIt()
    {

        if(oneX >= 283){
            right = false;
            left = true;
        }
        if(oneX <= 7){
            right = true;
            left = false;
        }
        if(oneY >= 259){
            up = true;
            down = false;
        }
        if(oneY <= 7){
            up = false;
            down = true;
        }
        if(up){
            oneY--;
        }
        if(down){
            oneY++;
        }
        if(left){
            oneX--;
        }
        if(right){
            oneX++;
        }
        
        repaint();


    }
 }