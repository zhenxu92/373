// importing GUI libraries
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



// importing library to use TimeUnit class
import java.util.concurrent.TimeUnit;

/*
 * This program tests human's sensibility in
 * recognizing elapsed time.
 * author: Zhen Xu
 */


public  class TimedResponseGame extends JFrame
{
	private long startTime, elapsedTime;
	
	private JLabel instructionLabel, responseLabel;
	private JButton startButton, stopButton;
	
	// set the size of the GUI frame
	private static final int HEIGHT = 400;
	private static final int WIDTH = 700;

	private startButtonHandler startButtonHandler;
	private stopButtonHandler stopButtonHandler;
	
	// main constructor that frame out the components in the GUI window
	public TimedResponseGame()
	{	
		// declaring labels: instructionLabel gives the guideline of this game
		// response Label work as the output window for result of the game
		instructionLabel = new JLabel("Please Click Start, after 3 seconds, Click Stop.");
		responseLabel = new JLabel();

		//This section specifies the handlers for the buttons and adds an ActionListener.
		startButton = new JButton("Start! ");
		startButtonHandler = new startButtonHandler();
		startButton.addActionListener(startButtonHandler);
		startButton.setBackground(Color.GREEN);
		stopButton = new JButton("Stop! ");
		stopButtonHandler = new stopButtonHandler();
		stopButton.addActionListener(stopButtonHandler);
		stopButton.setBackground(Color.RED);
		
		// initiate pane and assign title
		setTitle("Timed Response Game");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(2, 2));

		//Grid layout requires that you add components to the content pane in the order they should appear
		pane.add(instructionLabel);
		pane.add(responseLabel);
		pane.add(startButton);
		pane.add(stopButton);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	// work as a task handler for start button, recording the current time
	private class startButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			startTime = System.nanoTime();
		}
	}
	// work as a tas handler for stop button, recording the current time, calculate the difference and response
	public class stopButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			elapsedTime = System.nanoTime() - startTime;
			long msTimeElapsed = TimeUnit.NANOSECONDS.toMillis(elapsedTime);
			long elapsedMilliseconds = msTimeElapsed - 3000;
			long millisecondsOff = Math.abs(elapsedMilliseconds);
			String response;
			/*
			 * if the value of millisecondsOff is less than or equal to 100, display, on a JLabel within the GUI,
			 *  a message of the form "Nice! You were only x milliseconds y." where x is the value of millisecondsOff and y is either "early" or "late". 
			 *  If the value of millisecondsOff is greater than 100, display a similar message, but without the "Nice!" and "only" text. For example, 
			 *  it might be "You were 257 milliseconds late."
			 */
			if (millisecondsOff <= 100)
				response = "Nice! You were only " + Long.toString(millisecondsOff) + "milliseconds";
			else 
				response = "You were " + Long.toString(millisecondsOff);
			if (elapsedMilliseconds <0)
				response += " early";
			else
				response += " late";
			responseLabel.setText(response);
		}
	}
	
	public static void main(String[] args)
	{
		TimedResponseGame rectObj = new TimedResponseGame();
	}

}