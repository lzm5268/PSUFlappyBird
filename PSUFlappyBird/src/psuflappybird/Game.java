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
    
    private ArrayList<Rectangle> pipesOnScreenTop = new ArrayList<Rectangle>();
    private ArrayList<Rectangle> pipesOnScreenBot = new ArrayList<Rectangle>();
    
    
    private JFrame baseFrame;
    private JPanel gamePanel; 
    private JPanel resetPanel; 
    
    Rectangle top; 
    Rectangle bottom;
    
    private int x = 900;
    private int y = 600;
    private double topX; 
    private double topY; 
    private double botY; 
    private double botX;
    private int score;
    
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
        
        
        topX = top.getX(); 
        topY = top.getY();
        botX = bottom.getX(); 
        botY = bottom.getY(); 
        
        pipesOnScreenTop.add(top);
        pipesOnScreenBot.add(bottom);
        
        gamePanel = new JPanel() {
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                
                //for all the pipes on the screen
                for(int i = 0; i < pipesOnScreenTop.size(); i++){
                    //get the top rectangle
                    top = pipesOnScreenTop.get(i);
                    //get the bot rectangle
                    bottom = pipesOnScreenBot.get(i);
                    //fill the top and bottom boxes
                    g.fillRect((int)top.getX(), (int)top.getY(), (int)top.getWidth(), (int)top.getHeight());
                    g.fillRect((int)bottom.getX(), (int)bottom.getY(), (int)bottom.getWidth(), (int)bottom.getHeight());
                    
                    //if it is the last pipe in the array, and it's moved far enough
                    //make another pipe
                    //number after top.getx() is the space between pipes
                    if((i == pipesOnScreenTop.size()-1) && top.getX() < 450) {
                        Pipe p = new Pipe(); 
                        p.makeRectangles();
                        top = p.getTopRectangle(); 
                        bottom = p.getBottomRectangle();
                        pipesOnScreenTop.add(top);
                        pipesOnScreenBot.add(bottom);     
                    }
                    
                    //if the pipe is off screen, get rid of it in array 
                    if( top.getX() == 0){
                        pipesOnScreenTop.remove(i);
                        pipesOnScreenBot.remove(i);
                        //System.out.println(pipesOnScreenTop.size());
                    }
                    
                }
                //drawing one pipe
                g.setColor(Color.yellow);
                g.fillRect((int)topX, (int)topY, (int)top.getWidth(), (int)top.getHeight());
                g.fillRect((int)botX, (int)botY, (int)bottom.getWidth(), (int)bottom.getHeight());
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
                //want to reset back 
                //get the Pipe from the array
                //set top x
                //set bot x 
                for(int i = 0; i < pipesOnScreenTop.size(); i++){
                    //move the top rectangle
                    top = pipesOnScreenTop.get(i);
                    top.setLocation((int)top.getX()-1, (int)top.getY());
                    //move the bot rectangle
                    bottom = pipesOnScreenBot.get(i);
                    bottom.setLocation((int)bottom.getX()-1, (int)bottom.getY());
                }
                
                gamePanel.repaint();
            }
        }, 20,20);
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
