package psuflappybird;
import java.awt.*;
import javax.swing.*;


public class BirdFrame extends JFrame
{
	JPanel birdP;
        Bird birdy;
        Coin coin;
        public ImageIcon myImage;
    public Image coin1;
        
	public BirdFrame ()
	{
		super ("BirdFrame");
                birdP = new JPanel();
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(birdP,"Center");
                birdy = new Bird();
                coin = new Coin();
               //getContentPane().add(coin);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (1050, 1000);
		setVisible(true);
	}
}
