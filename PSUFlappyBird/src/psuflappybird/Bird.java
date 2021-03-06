
package psuflappybird;

import javax.imageio.ImageIO;
import javax.swing.Timer;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;

/**
 *
 * @author jrc5713
 */

public class Bird extends Rectangle{
    
        private int DIAMETER = 25;					//Diameter of the bird
	final private int x = 450;//( Game.WIDTH / 2 ) - ( DIAMETER / 2 );		//The x position of the bird. Should be exactly centered  
	private int y = 300;//Game.HEIGHT / 2;				//The STARTING y position of the bird. Will change constantly
	private int acceleration = 1;					//Used in the gravity simulation below
	private int speed = 2;	
        Rectangle bird;
        ImageIcon myImage = new ImageIcon("src/images/football.gif");
        Image im = myImage.getImage();
        Graphics g;
    
    public Bird(){
    }
    
    public void reset(){	//called after the bird dies
	y = Game.HEIGHT / 2;	//resets position, speed, etc.
	speed = 2;
    }
    
    public void draw(Graphics g, int x1, int y1){
       {  
            g.drawImage(im, x1, y1, null);
            g.drawRect(x1, y1, 40, 30);
        }
    }
    //This is called when the bird jumps (on mouse click). sets the speed to -17 
	public int jump(){
            y = y - 60;
            this.setLocation(x, y);
        
            return y;			
	}
    
    //method to change y position of the "bird
    public Rectangle getBounds(){
    	 return new Rectangle(x, y, DIAMETER, DIAMETER);		//Gives a rectangle used to detect collisions in the Wall class
    }
    
    public int fall()
    {
        y = y + 2;
        this.setLocation(x, y);
        
        return y; 
    }
    
    public int getBirdX()
    {
        return x;
    }
    
    public int getBirdY()
    {
        return y;
    }
}