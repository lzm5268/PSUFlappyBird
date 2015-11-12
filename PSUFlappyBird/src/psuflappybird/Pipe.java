/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.*;

/**
 *
 * @author jrc5713
 */
public class Pipe extends JPanel{

    int opening = createOpening();
    int topBound = opening;
    int bottomBound = opening + 150;
    
    Rectangle top; 
    Rectangle bottom;

    public Pipe(){
      
    }
    
    public void makeRectangles(){
        top = new Rectangle(900,0,100,topBound);
        bottom = new Rectangle(900, bottomBound, 100, (600-bottomBound));
    }
    
    public static int createOpening(){
        int max = 500;
        int min = 50;
        Random rand = new Random();
        int upperBound = rand.nextInt(max - min)+1;
        
        return upperBound;
    }
    
    public Rectangle getTopRectangle(){
        return top;
    }
    
    public Rectangle getBottomRectangle(){
        return bottom;
    }
    
    public void setTopRectangle(Rectangle top){
        this.top = top;
    }
    
    public void setBottomRectangle(Rectangle bottom){
        this.bottom = bottom; 
    }
}
