/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

import javax.swing.JFrame;

/**
 *
 * @author katiebradley
 */
public class MainFrame extends JFrame{
    
    Home gamePanel = new Home();
    
    public MainFrame(){
        
        super ("PSU Flappy Bird");
        
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(900,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(gamePanel);
    }
  
}
