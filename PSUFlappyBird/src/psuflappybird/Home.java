/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

import javax.swing.*;
import javax.swing.border.*;
import javax.accessibility.*;
 
import java.awt.*;
import static java.awt.Color.RED;
import java.awt.event.*;

//holds: nameField: JTextField 
//      startButton: JButton
//      startGame()

public class Home extends JPanel {
    private JFrame fullFrame;
    private JTextField nameField;
    private JButton startButton; 
    
    private JPanel gamePanel; 
    
    int x = 900; 
    int y = 500; 
    
    public Home(){
      
       initComponents(); 

    } 

    public void initComponents() {
        //include nameField and startButton
        fullFrame = new JFrame("PSU Flappy Bird");
        fullFrame.setSize(900, 600);
        fullFrame.setLayout(new FlowLayout());
        fullFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        gamePanel = new JPanel();
        gamePanel.setLayout(new FlowLayout());
        gamePanel.setPreferredSize(new Dimension(x, y));
      
        nameField = new JTextField(10);
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startGame();
            }
        });
        
        gamePanel.add(nameField);
        gamePanel.add(startButton);

        fullFrame.setLocationRelativeTo(null);
        fullFrame.add(gamePanel);
        fullFrame.setVisible(true);
        
    }
    
    public void startGame(){
        fullFrame.dispose(); 
        Game g = new Game(); 
        g.setVisible(true);
        
    }
    
    
}
