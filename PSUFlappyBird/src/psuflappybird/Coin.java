package psuflappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author mzk5401
 */
public class Coin extends Rectangle{
    private int DIAMETER = 25;
    private int x = ( Game.WIDTH / 2 ) - ( DIAMETER / 2 );		
    private int y =  Game.HEIGHT / 2;
    private int HEIGHT;
    private int WIDTH;
    public ImageIcon myImage;
    Bird bird;
    public Coin()
    {
 
    }
   
    public void draw(Graphics g){ 
    	myImage = new ImageIcon("src/images/coinLogo.png");
        Image im = myImage.getImage();
    	g.drawImage(im, 0, 0, null);
        g.drawRect(x, y, 30, 30);
    }
    public Rectangle getBounds(){
		 return new Rectangle(x, y, DIAMETER, DIAMETER);		
		}
   
}