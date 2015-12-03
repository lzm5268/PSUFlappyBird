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
    
    Rectangle coin; 
    
    public Coin()
    {
 
    }
   
    public void draw(Graphics g, int x1, int y1){ 
    	g.drawImage(im, x1, y1, null);
    }
    public Rectangle makeCoin(int x, int y){
        coin = new Rectangle(19, 19, x, y);	
        
        return coin;
    }
    
    public Rectangle getCoin(){
        return coin;
    }
    
    
    
//     public Rectangle getTopRectangle(){
//        return top;
//    }
//    
//    public Rectangle getBottomRectangle(){
//        return bottom;
//    }
//   
}