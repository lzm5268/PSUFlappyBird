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
    
    //new instance of bird
        Bird bird = new Bird();
        Coin coin = new Coin();
    
    private ArrayList<Rectangle> pipesOnScreenTop = new ArrayList<Rectangle>();
    private ArrayList<Rectangle> pipesOnScreenBot = new ArrayList<Rectangle>();
    
    private ArrayList<Rectangle> coinsOnScreen = new ArrayList<Rectangle>();
    
    
    
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
    private int birdX;
    private int birdY;
    
    private JLabel score;
    
    Graphics g;
    

    public Game(){
        makeFrame(); 
        drawPipes();
        addToFrame();
        processKeys();
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
        birdX = bird.getBirdX();
        birdY = bird.getBirdY();
        
        pipesOnScreenTop.add(top);
        pipesOnScreenBot.add(bottom);
        
        gamePanel = new JPanel() {
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                
                //add Beaver Stadium as the background
                ImageIcon myImage = new ImageIcon("src/images/beaverStadium.jpg");
                Image im = myImage.getImage();
                g.drawImage(im, 0, 0, null);
                
                //create a JLabel to display the score
                score = new JLabel("Score:");
                score.setForeground(Color.white);
                gamePanel.add(score);
                
                //try to make bird show up on screen
                //Bird b1 = new Bird();
                bird.draw(g, birdX, birdY);
                        
                        
                        
                //for all the pipes on the screen
                for(int i = 0; i < pipesOnScreenTop.size(); i++){
                    //get the top rectangle
                    top = pipesOnScreenTop.get(i);
                    //get the bot rectangle
                    bottom = pipesOnScreenBot.get(i);
                    //fill the top and bottom boxes
                    g.fillRect((int)top.getX(), (int)top.getY(), (int)top.getWidth(), (int)top.getHeight());
                    g.fillRect((int)bottom.getX(), (int)bottom.getY(), (int)bottom.getWidth(), (int)bottom.getHeight());
                    
                    //draw the coin between the pipes
                    coin.draw(g, (int) bottom.getX() + 30, (int) bottom.getY() - 75);
                   
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
              
                        
                        //making the coin
                        coin.makeCoin((int) top.getX(), (int) top.getY());
                        coinsOnScreen.add(coin.getCoin());
                    }
                    
                    //if the pipe is off screen, get rid of it in array 
                    if( top.getX() == 0){
                        pipesOnScreenTop.remove(i);
                        pipesOnScreenBot.remove(i);
                        coinsOnScreen.remove(i); 
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
        
    }
    

    public void moveThings(){
        Timer movePipes = new Timer();
        movePipes.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run(){
                
                for(int i = 0; i < pipesOnScreenBot.size(); i++){
                    Rectangle r1 = pipesOnScreenBot.get(i);
                    intersects(r1, bird);
                }
                
                for(int i = 0; i < pipesOnScreenTop.size(); i++){
                    Rectangle r1 = pipesOnScreenTop.get(i);
                    intersects(r1, bird);
                }
                
               

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
                
                //make bird fall down from gravity
                birdY = bird.fall(); 
                
                
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
    
    public void intersects(Rectangle r1, Rectangle r2){
        if(r1.getBounds().intersects(r2.getBounds())){
            
            gamePanel.setVisible(false);
            baseFrame.setVisible(false);
            
            baseFrame.dispose();
           
            System.out.println("rl and r2 intesect");
        } 
        else {
            System.out.println("no intersect");
        }
    }
   
    //action listener for jumping
    private void processKeys(){
    KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(
        new KeyEventDispatcher()  { 
            public boolean dispatchKeyEvent(KeyEvent e){
                if(e.getID() == KeyEvent.KEY_PRESSED){
                    e.getKeyCode();
                    System.out.println("key pressed");
                    System.out.println(e.getKeyCode());
                    if(e.getKeyCode() == 38){
                        //jumps
                        birdY = bird.jump();
                    }
                }
                return false;
            } 
    });
}
    
}
