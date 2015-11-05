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
}
