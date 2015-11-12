/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

//importing 
import javax.swing.*;
import javax.swing.border.*;
import javax.accessibility.*;
 
import java.awt.*;
import static java.awt.Color.RED;
import java.awt.event.*;
import java.util.Timer; 
import java.util.*; 

//creating layered panels to handle each of the objects (background, pipes, bird, highScore) 
//using ImageIcons to be the pipes, bird, and foot/iconToCollect

public class Game extends JPanel {

    private Bird b; 
    private Pipe p; 
    private Coin c; 
    
    private JFrame baseFrame;
    private JPanel gamePanel; 
    private JPanel resetPanel; 
    
    Rectangle top; 
    Rectangle bottom;
    
    private int x = 900;
    private int y = 600;
    
    Graphics g;
    

    public Game(){
        makeFrame(); 
        drawPipes();
        addToFrame();
        moveThings();
    }

    public void drawPipes(){
        
        Pipe p = new Pipe(); 
        p.makeRectangles();
        top = p.getTopRectangle(); 
        bottom = p.getBottomRectangle();
        gamePanel = new JPanel() {
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                g.setColor(Color.yellow);
                g.fillRect((int)top.getX(), (int) top.getY(), (int)top.getWidth(), (int)top.getHeight());
                g.fillRect((int)bottom.getX(), (int) bottom.getY(), (int)bottom.getWidth(), (int)bottom.getHeight());
            }
        };
        
        gamePanel.setLayout(new FlowLayout());
        gamePanel.setPreferredSize(new Dimension(x, y));
        
        gamePanel.setBackground(Color.red);
        


    }
    

    public void moveThings(){
        Timer movePipes = new Timer();
        movePipes.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){
                top.setLocation((int)top.getX()-50, (int)top.getY());
                g.fillRect((int)top.getX(), (int) top.getY(), (int)top.getWidth(), (int)top.getHeight());
                gamePanel.repaint();
            }
        }, 100,100);
    }
    
   
    
    public void makeFrame(){
        baseFrame = new JFrame("PSU Flappy Bird");
        baseFrame.setSize(900, 600);
        baseFrame.setLayout(new FlowLayout());
        baseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void addToFrame(){
        baseFrame.setLocationRelativeTo(null);
        baseFrame.add(gamePanel);
        baseFrame.setVisible(true);
    }
}
