
package psuflappybird;

import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author jrc5713
 */

public class Bird extends JPanel{
    
    
    private int y = 250;
    private int x = 175;
    private int WIDTH = 30;
    private int HEIGHT = 30;
    private int jumpAmount = 10;
    private int gravity = -10;
    public Bird(){
        
    }
    
    public void Gravity(){
        this.setYPos(gravity);
    }
    public void Image(){
       
      
    }
    
    //method to draw the "bird" to the game screen, updating its position
    public void paintComponent(Graphics g){
        {
    	super.paintComponent(g); 
    	Image myImage = Toolkit.getDefaultToolkit().getImage("images/football.gif");
    	g.drawImage(myImage, 0, 0, this);    	
        g.fillRect(100,20,70,80);
        g.setColor(Color.yellow);
        g.drawString("text on a Panel", 100,150);

        }
    }
    
    //method to allow "bird" to "jump" (move upwards) to navigate through the
    //game board
    public void jump(){
        this.setYPos(jumpAmount);
        //bird.setBounds(x, y, WIDTH, HEIGHT);
    }
    
    //method to change y position of the "bird"
    private int setYPos(int change){
      y = y + change;
      return y;  
    }
}




