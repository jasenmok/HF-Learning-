
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class StartFrame implements ActionListener,Runnable
{
	JFrame frame,frame2;
	JButton button;

	Thread t = new Thread(this);
	Play play = new Play();



	//main function
	public static void main(String[] args)
	{
		StartFrame SF = new StartFrame();
		SF.MakingFrame();
		//SF.newf();
	}

    //making start frame
	public void MakingFrame()
	{
		frame = new JFrame("BatVillans");
		JLabel jl = new JLabel();
		frame.setSize(1000,520);
		jl.setIcon(new ImageIcon("tyty.jpg"));
		frame.add(jl);
		button = new JButton("Start");
		//button.setSize(100,300);
		button.addActionListener(this);
		frame.getContentPane().add(BorderLayout.SOUTH, button);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	//this making new frame
	public void newf()
	{
		button.setVisible(false);
		frame.setVisible(false);
		frame.dispose();

		
		frame2 = new JFrame("BatVillans");
		frame2.setSize(1000,520);
		frame2.addKeyListener(play);
		frame2.add(play);
		
		frame2.setResizable(false);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setVisible(true);
		//
	}

	//game loop
	public void run()
	{
		for(; ;)
		{
		try
		{
		//System.out.println("Running......Draw part......");
		t.sleep(5);
		play.increment();
		//play.Collision();
		frame2.repaint();
		}
		catch(InterruptedException e)
		{}
		}
	}

	//When start button clicked
	public void actionPerformed(ActionEvent event)
	{

		//close StartFrame
		
		//Start new Frame
		newf();	
		t.start();
	}
}
