/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

import java.awt.Color;
import java.awt.Graphics;
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
    
    public Pipe(){
        
        
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.fillRect(100, 0, 100, topBound);
        g.setColor(Color.yellow);
        g.fillRect(100, bottomBound, 100, (600-bottomBound));
    }
    
    
        
    
    
    public static int createOpening(){
        int max = 500;
        int min = 50;
        Random rand = new Random();
        int upperBound = rand.nextInt(max - min)+1;
        
        return upperBound;
    }
}
