import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField guessTextField;
	private JTextField resultTextField_1;
	private JTextField resultTextField_2;
	public int randomInteger;
	public int counter;
	
	public void checkGuess() {
		String guessText = guessTextField.getText();
		String message = "";
		String message2 = "";
		try {
			int guess = Integer.parseInt(guessText);
			counter++;
			if (guess > randomInteger) {
				message = "Your number is too high. Please try again!";
				resultTextField_1.setText(message);
			}
			else if (guess < randomInteger) {
				message = "Your number is too low. Please try again";
				resultTextField_1.setText(message);
			}
			else {
				message = "Congratulations! You are correct.";
				message2 = "It took you " + counter + " tries to guess the number!";
				resultTextField_1.setText(message);
				resultTextField_2.setText(message2);
				newGame();
			}
		}
		catch(Exception e) {
			resultTextField_1.setText("Enter a whole number between -100 and 1000");
		}
		finally {
			guessTextField.requestFocus();
			guessTextField.selectAll();
		}
	}
	public GuessingGame() {
		setVisible(true);
		setSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		
		JLabel titleLabel = new JLabel("High/Low Guessing Game");
		titleLabel.setForeground(Color.BLUE);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		titleLabel.setBounds(94, 58, 400, 60);
		getContentPane().add(titleLabel);
		
		JLabel lblNewLabel = new JLabel("Enter a number between -100 and 1000:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(12, 165, 400, 33);
		getContentPane().add(lblNewLabel);
		
		guessTextField = new JTextField();
		guessTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		guessTextField.setForeground(Color.RED);
		guessTextField.setHorizontalAlignment(SwingConstants.CENTER);
		guessTextField.setFont(new Font("DialogInput", Font.BOLD, 20));
		guessTextField.setBounds(424, 173, 116, 22);
		getContentPane().add(guessTextField);
		guessTextField.setColumns(10);
		
		resultTextField_1 = new JTextField();
		resultTextField_1.setBackground(Color.CYAN);
		resultTextField_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		resultTextField_1.setBounds(94, 298, 393, 33);
		getContentPane().add(resultTextField_1);
		resultTextField_1.setColumns(10);
		
		resultTextField_2 = new JTextField();
		resultTextField_2.setHorizontalAlignment(SwingConstants.CENTER);
		resultTextField_2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		resultTextField_2.setColumns(10);
		resultTextField_2.setBackground(Color.CYAN);
		resultTextField_2.setBounds(94, 331, 393, 33);
		getContentPane().add(resultTextField_2);
		
		JButton playAgainBtn = new JButton("Play Again!");
		playAgainBtn.setEnabled(false);
		playAgainBtn.setForeground(Color.BLUE);
		playAgainBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		playAgainBtn.setBackground(Color.PINK);
		playAgainBtn.setBounds(74, 468, 160, 43);
		getContentPane().add(playAgainBtn);
		
		JButton doneBtn = new JButton("Done!");
		doneBtn.setForeground(Color.BLUE);
		doneBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		doneBtn.setEnabled(false);
		doneBtn.setBackground(Color.PINK);
		doneBtn.setBounds(311, 468, 160, 43);
		getContentPane().add(doneBtn);
		
		JButton chkNumberBtn = new JButton("Check Number");
		chkNumberBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		chkNumberBtn.setForeground(Color.BLUE);
		chkNumberBtn.setFont(new Font("Dialog", Font.BOLD, 20));
		chkNumberBtn.setEnabled(false);
		chkNumberBtn.setBackground(Color.PINK);
		chkNumberBtn.setBounds(204, 220, 179, 43);
		getContentPane().add(chkNumberBtn);
	}
	
	private void newGame() {
		//Generate a random number between -100 and 1000 for the user to guess
		randomInteger = generateRandomNumber(-100, 1000);
		counter = 0;
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
