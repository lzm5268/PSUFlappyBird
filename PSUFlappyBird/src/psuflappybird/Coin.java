/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Coin extends JPanel{
    
    private int x;
    private int y;
    private int HEIGHT;
    private int WIDTH;
    public ImageIcon myImage;
    public Image coin;
    public Rectangle coinBox;
    
    public Coin()
    {
        
    }
    
    
    public void paitComponent(Graphics g)
    {
        //if this doesnt work getr rid of the first forward slash
        myImage = new ImageIcon(getClass().getResource("/images/penn-state.png"));
        coin = myImage.getImage();
        
        super.paintComponent(g); 
    	g.drawImage(coin, 0, 0, this);    	
        g.fillRect(100,20,70,80);
        g.setColor(Color.blue);
        g.drawString("text on a Panel", 1500,170);
    }
    
}
