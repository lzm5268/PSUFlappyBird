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
import java.awt.event.*;

//creating layered panels to handle each of the objects (background, pipes, bird, highScore) 
//using ImageIcons to be the pipes, bird, and foot/iconToCollect




public class Game extends JPanel {

    private Bird b; 
    private Pipe p; 
    private Coin c; 
    
    private JFrame baseFrame;
    private JPanel gamePanel; 
    private JPanel resetPanel; 
    
}
