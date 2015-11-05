/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

import java.util.*;
import javax.swing.*;

/**
 *
 * @author jrc5713
 */

public class Bird {
    JButton bird = new JButton();
    int y = 250;
    int x = 175;
    int WIDTH = 30;
    int HEIGHT = 30;
    
    Timer t1 = new Timer();
    public void Gravity(){
         t1.scheduleAtFixedRate(new TimerTask() {
             int count = 0;
         public void run() {
         y = y - 50;
         bird.setBounds(y, 40, 40);
         gamePanel.repaint();
         count ++;
            }
        }, 500, 500);
        
    }
    public void Image(){
        
    }
    public void Position(){
        
    }
    
    //method to draw the "bird" to the game screen, updating its position
    public void draw(){
        
    }
    
    //method to allow "bird" to "jump" (move upwards) to navigate through the
    //game board
    public void jump(){
        
        bird.setBounds(x, y, WIDTH, HEIGHT);
    }
    
    //method to change y position of the "bird"
    public int setYPos(int change){
      y = y + change;
      return y;  
    }
}
