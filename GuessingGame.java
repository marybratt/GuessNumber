import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class GuessingGame extends JFrame {
	public JTextField guessTextField;
	public JTextField resultTextField_1;
	public JTextField resultTextField_2;
	public int randomInteger;
	public int counter;
	
	public void checkGuess() {
		String guessText = guessTextField.getText();//brings in the user entered field into a string field
		String message = "";
		String message2 = "";
		try {
			// check to see if the user entered field is a number 
			int guess = Integer.parseInt(guessText);
			counter++;// increment counter each time thru
			
			if (guess > randomInteger) { // check if too high and put out message
				message = "Your number is too high. Please try again!";
				resultTextField_1.setText(message);
			}
			else if (guess < randomInteger) { // check if too low and put out message
				message = "Your number is too low. Please try again";
				resultTextField_1.setText(message);
			}
			else { // number is correct - put out message
				message = "Congratulations! You are correct.";
				message2 = "It took you " + counter + " tries to guess the number!";
				resultTextField_1.setText(message);
				resultTextField_2.setText(message2);
				newGame(); //call a new game
			}
		}
		//exception handling
		catch(Exception e) {
			resultTextField_1.setText("Enter a whole number between -100 and 1000");
		}
		finally {
			guessTextField.requestFocus();
			guessTextField.selectAll();
		}
	}
	public GuessingGame() { 
		// JFrame settings for the screen
		getContentPane().setBackground(Color.YELLOW);
		setSize(new Dimension(600, 600));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		repaint(); this.repaint();
		//Title
		JLabel titleLabel = new JLabel("High/Low Guessing Game");
		titleLabel.setForeground(Color.BLUE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		titleLabel.setBounds(94, 58, 400, 60);
		getContentPane().add(titleLabel);
		// label indicating the range for the number to be guessed
		JLabel lblNewLabel = new JLabel("Enter a number between -100 and 1000:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 165, 400, 33);
		getContentPane().add(lblNewLabel);
		// field that user inputs the guessed number
		guessTextField = new JTextField();
		//Action listener to accept the users input
		// if hit enter will check if number is high, low or correct
		guessTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		guessTextField.setForeground(Color.RED);
		guessTextField.setHorizontalAlignment(SwingConstants.CENTER);
		guessTextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		guessTextField.setBounds(424, 173, 116, 22);
		guessTextField.setColumns(10);
		guessTextField.requestFocus();
		getContentPane().add(guessTextField);

		//field to be used to output the messages to know if the number is high, low or correct
		resultTextField_1 = new JTextField();
		resultTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		resultTextField_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		resultTextField_1.setBackground(Color.YELLOW);
		resultTextField_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		resultTextField_1.setBounds(76, 298, 411, 33);
		resultTextField_1.setColumns(10);
		getContentPane().add(resultTextField_1);
		
		
		resultTextField_2 = new JTextField();
		resultTextField_2.setBorder(new EmptyBorder(0, 0, 0, 0));
		resultTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		resultTextField_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		resultTextField_2.setColumns(10);
		resultTextField_2.setBackground(Color.YELLOW);
		resultTextField_2.setBounds(76, 331, 411, 33);
		getContentPane().add(resultTextField_2);
		
		// button to show that they wish to play another game
		JButton playAgainBtn = new JButton("Play Again?");
		playAgainBtn.setForeground(Color.BLUE);
		playAgainBtn.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		playAgainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// clear all fields then start the game over
				resultTextField_2.setText(null);
				resultTextField_1.setText(null);
				guessTextField.setText(null);
				newGame();
			}
		});
		playAgainBtn.setBounds(203, 445, 169, 33);
		getContentPane().add(playAgainBtn);
		
		getContentPane().repaint();//used to fix problem with not all components showing on initial popup
		
		guessTextField.requestFocusInWindow(); // used to set cursor at the field to be entered
	}
	
	private void newGame() {
		//Generate a random number between -100 and 1000 for the user to guess
		randomInteger = generateRandomNumber(-100, 1000);
		counter = 0; // set the counter to 0 at beginning of game
		guessTextField.requestFocusInWindow(); // used to set cursor at the field to be entered
	}
	
	// generates the random number between the 2 numbers that were sent into method
	// then returns that number
	private static int generateRandomNumber(int number1, int number2) {
		int randomInteger = ThreadLocalRandom.current().nextInt(number1, number2);
		return randomInteger;
		}

	public static void main(String[] args) {
		GuessingGame getGame = new GuessingGame();
		getGame.newGame();
		getGame.setSize(new Dimension(600,600));
		getGame.setVisible(true);
		
	}
}
