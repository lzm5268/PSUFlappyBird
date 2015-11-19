package psuflappybird;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author elizabethkohler
 */
public class HighScores {

   int highscores[] = new int[3];
   String names[] = new String[3];
   String filePath = "C:/Users/elizabethkohler/Desktop/HighScoresTable.rtf";

   public HighScores(){
   for(int i = 0; i < highscores.length; i++){
       highscores[i] = 0;
       names[i] = "null";
   }
   }

   public void updateScores(int score, String name){
       for(int i = 0; i < highscores.length; i++){
           if(score > highscores[i]){
               for(int j = 3; j > i; j--){
                   highscores[j] = highscores[j-1];
                   names[j] = names[j-1];
               }
               highscores[i] = score;
               names[i] = name;
               break;
           }else{
               continue;
           }
       }
   }
   
   public void readScores() {
       try {
           File f = new File(filePath);
           f.getParentFile().mkdirs(); 
           f.createNewFile();
           FileReader fr = new FileReader(f);
           BufferedReader in = new BufferedReader(fr);

           String str;
           int i = 0;

           while ((str = in.readLine()) != null)
           {
               names[i] = str;
               str = in.readLine();
               highscores[i] = Integer.parseInt(str);
               i++;
           }

           in.close();
       } 
       catch (FileNotFoundException e) {
           JOptionPane.showMessageDialog(null,"IOERROR: File NOT Found: " + filePath + "\n","", JOptionPane.WARNING_MESSAGE);
       } 
       catch (IOException e) 
       {
           JOptionPane.showMessageDialog(null,"IOERROR: " + e.getMessage() + "\n","", JOptionPane.WARNING_MESSAGE);
       }
   }

   public void writeScores() {
       try{
       FileWriter write = new FileWriter(filePath, true);
       PrintWriter print = new PrintWriter(write);
       for(int i = 0 ; i < highscores.length; i ++) {
           print.println(highscores[i]);
           print.println(names[i]);
       }
       print.close();
       } 
       catch(IOException e1) {JOptionPane.showMessageDialog(null,"IOERROR: " + e1.getMessage() + "\n","", JOptionPane.WARNING_MESSAGE);}
   }
}