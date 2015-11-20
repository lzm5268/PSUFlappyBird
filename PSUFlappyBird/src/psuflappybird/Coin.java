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
    ImageIcon myImage = new ImageIcon("src/images/coinLogo.gif");
    Image im = myImage.getImage();
    Bird bird;
    public Coin()
    {
 
    }
   
    public void draw(Graphics g, int x1, int y1){ 
    	g.drawImage(im, x1, y1, null);
        g.drawRect(x1, y1, 20, 20);
    }
    public Rectangle getBounds(){
		 return new Rectangle(x, y, DIAMETER, DIAMETER);		
		}
   
}