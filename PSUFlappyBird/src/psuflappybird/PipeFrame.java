/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psuflappybird;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author elizabethkohler
 */
public class PipeFrame extends JFrame{

    Pipe topPipe;
    Pipe bottomPipe;
    
    public PipeFrame(){
        super("My First Frame");
        
        topPipe = new Pipe();
        getContentPane().add(topPipe);
        bottomPipe = new Pipe();
        getContentPane().add(bottomPipe);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900,600);
        setVisible(true);
    }
    
}
