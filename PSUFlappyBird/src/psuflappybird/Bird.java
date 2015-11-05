/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
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
    
    public void Gravity(){

    }
    public void Image(){
       BufferedImage bird = null;
        try {
        bird = ImageIO.read(new File("football.gif"));
            } 
        catch (IOException e) {
    } 
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
