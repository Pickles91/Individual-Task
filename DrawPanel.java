package playball;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

class DrawPanel extends JPanel {
	
    private int oneX = 7;
    private int oneY = 7;
    private int obstacleX = 150;
    private int obstacleY = 100;
    boolean up = false;
    boolean down = true;
    boolean left = false;
    boolean right = true;
    int score = 0;
    private Tester testerInstance;
    
    public DrawPanel(Tester tester) {
    	this.testerInstance = tester;
        Random random = new Random();
        obstacleX = random.nextInt(283);
        obstacleY = random.nextInt(259);
    }

	public void paintComponent(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.RED);
        g.fillRect(3, 3, this.getWidth()-6, this.getHeight()-6);
        g.setColor(Color.WHITE);
        g.fillRect(6, 6, this.getWidth()-12, this.getHeight()-12);
        g.setColor(Color.GREEN);
        g.fillOval(oneX, oneY, 16, 16);
        g.setColor(Color.MAGENTA);
        g.fillRect(obstacleX, obstacleY, 20, 20); 

    }

    public void moveIt() {

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
        
     // Move the obstacle
        obstacleX += 2;
        if (obstacleX > getWidth()) {
            obstacleX = 0;
            Random random = new Random();
            obstacleY = random.nextInt(getHeight());
        }

     // Check collision with the obstacle
        if (oneX < obstacleX + 20 &&
                oneX + 16 > obstacleX &&
                oneY < obstacleY + 20 &&
                oneY + 16 > obstacleY) {
            // Handle collision (you can decrease score or take other actions)
        	testerInstance.t.stop(); // Stop the timer
            JOptionPane.showMessageDialog(null, "Game Over. You Lost");

            // Reset the score to zero
            score = 0-1;
            testerInstance.scoreLabel.setText("Score: " + score); // Update the score label

            // Reset the oval's position to its initial state
            oneX = 7;
            oneY = 7;

            // Restart the game
            testerInstance.t.restart();

            // So the oval doesn't just go with restarting
            testerInstance.go = false;
        }
        
     // Check if the oval hits the edge, and increment the score
        if (oneX >= 283 || oneX <= 7 || oneY >= 259 || oneY <= 7) {
            score++;
            // Update the scoreLabel with the current score
            testerInstance.scoreLabel.setText("Score: " + score);
            
         // Check if the score reaches 100
            if (score >= 5) {
            	testerInstance.t.stop(); // Stop the timer
                JOptionPane.showMessageDialog(null, "Congratulations! Game completed.");
             // Reset the score to zero
                score = 0;
                testerInstance.scoreLabel.setText("Score: " + score);

                // Reset the oval's position to its initial state
                oneX = 7;
                oneY = 7;

                // Restart the game
                testerInstance.t.restart();
                
                //So the oval doesn't just go with restarting
                testerInstance.go = false;
            }
        }  
          
        repaint();
    }
 }
