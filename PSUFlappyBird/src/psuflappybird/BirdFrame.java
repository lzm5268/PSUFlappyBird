package psuflappybird;
import java.awt.*;
import javax.swing.*;


public class BirdFrame extends JFrame
{
	JPanel birdP;
        Bird birdy;
        
	public BirdFrame ()
	{
		super ("BirdFrame");
                birdP = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(birdP,"Center");
                birdy = new Bird();
                getContentPane().add(birdy);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (1050, 1000);
		setVisible(true);
                
	}
}
