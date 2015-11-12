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
    private JTextArea directions;
    private JPanel directionsPanel = new JPanel();
    private JPanel startPanel; 
    
    int x = 900; 
    int y = 500; 
    
    public Home(){
      
       initComponents(); 

    } 

    public void initComponents() {
        //include nameField and startButton
        fullFrame = new JFrame("PSU Flappy Bird");
        fullFrame.setSize(900, 600);
        fullFrame.setLayout(new BorderLayout());
        fullFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        startPanel = new JPanel();
        //startPanel.setLayout(new FlowLayout());
        startPanel.setPreferredSize(new Dimension(x, y));
      
        nameField = new JTextField(10);

       
        directions = new JTextArea("This is a test of the text area. We are seeing if the lines will work.");

        directions.setSize(600, 600);
        
        directionsPanel.add(directions);
        directions.setLineWrap(true);
        directions.setWrapStyleWord(true);
        
        
        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                startGame();
            }
        });
        
        startPanel.add(nameField);
        startPanel.add(startButton);

        //fullFrame.setLocationRelativeTo(null);
        fullFrame.add(startPanel, BorderLayout.SOUTH);
        fullFrame.add(directionsPanel, BorderLayout.NORTH);
        fullFrame.setVisible(true);
        
    }
    
    public void startGame(){
        fullFrame.dispose(); 
        //Game g = new Game(); 
        PipeFrame g = new PipeFrame();
        g.setVisible(true);
        
    }
    
    
}
