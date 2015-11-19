
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
    
        ImageIcon myImage;
        private int DIAMETER = 25;					//Diameter of the bird
	private int X = 300;//( Game.WIDTH / 2 ) - ( DIAMETER / 2 );		//The x position of the bird. Should be exactly centered  
	private int y =  300;//Game.HEIGHT / 2;				//The STARTING y position of the bird. Will change constantly
	private int acceleration = 1;					//Used in the gravity simulation below
	private int speed = 2;		
    
    public Bird(){
    }
    public void Gravity(){
        //only moves if the bird is between the top and bottom of the window
		if ( ( y > 0 ) && ( y < Game.HEIGHT )) {
			speed += acceleration;	//the gravity,the speed is just increased by 1 all the time, even after a jump
			y += speed;	//The actual movement, y location equals (where it was) + (how far it should go)
		}
		//or else the game resets
		else {
			reset();											//rests bird's postion									//bird is dead! This is used in the Main method to reset the walls after a death
		}
    }
    public void reset(){	//called after the bird dies
		y = Game.HEIGHT / 2;	//resets position, speed, etc.
		speed = 2;
	}
    public void draw(Graphics g){
       {  
    	myImage = new ImageIcon("src/images/football.gif");
        Image im = myImage.getImage();
    	g.drawImage(im, 0, 0, null);
        g.drawRect(x, y, 30, 30);
        }
    }
    //This is called when the bird jumps (on mouse click). sets the speed to -17 
	public void jump(){
		speed = - 17;			
	}
    
    //method to change y position of the "bird
    public Rectangle getBounds(){
		 return new Rectangle(X, y, DIAMETER, DIAMETER);		//Gives a rectangle used to detect collisions in the Wall class
		}
}
//