package Typing_Game;


import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TypingTuter extends JFrame implements ActionListener {

	JLabel lbltime;
	JLabel lblscore;
	JLabel lblWord;
	JTextField txtWord;
	JButton btnstart;
	JButton btnstop;

	Timer timer;
	int TimeRemaining;
	int score;
	boolean isRunning;
	String[] words;

	public TypingTuter(String[] words) {

		GridLayout layout = new GridLayout(3, 2);
		this.words = words;
		Font font = new Font("Constantia" + "", 1, 150);

		super.setLayout(layout);
		super.setTitle("Typing Master Pro");
		super.setSize(100, 200);

		lbltime = new JLabel("Time: ", JLabel.CENTER);
		lbltime.setFont(font);
		super.add(lbltime);

		lblscore = new JLabel("Score: ", JLabel.CENTER);
		lblscore.setFont(font);
		super.add(lblscore);

		lblWord = new JLabel();
		lblWord.setFont(font);
		super.add(lblWord);

		txtWord = new JTextField();
		txtWord.setFont(font);
		super.add(txtWord);

		btnstart = new JButton("Start ");
		btnstart.setFont(font);
		btnstart.addActionListener(this);
		super.add(btnstart);

		btnstop = new JButton("Stop");
		btnstop.addActionListener(this);
		btnstop.setFont(font);
		super.add(btnstop);

		super.setExtendedState(MAXIMIZED_BOTH);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);

		super.setVisible(true);

		setupGame();

	}

	public void setupGame() {

		timer = new Timer(5000, this);
		TimeRemaining = 5;
		score = 0;
		isRunning = false;

		txtWord.setEnabled(false);
		lbltime.setText("Time: ");
		lblscore.setText("Score: ");
		lblWord.setText("");
		txtWord.setText("");
		txtWord.setEnabled(false);
		btnstart.setText("Start: ");
		btnstop.setText("Stop: ");
		btnstop.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnstart) {

			handlestart();
		} else if (e.getSource() == btnstop) {
			handlestop();
		} else {
			handletimer();
		}

	}

	private void handletimer() {

		TimeRemaining--;

		if (lblWord.getText().equals(txtWord.getText()) && lblWord.getText().length() > 0) {
			score++;
		}
		lblscore.setText("Score: " + score);

		if (TimeRemaining < 0) {
			handlestop();
			return;
		}

		lbltime.setText("Time: " + TimeRemaining);

		txtWord.setText("");
		int idx = (int) (Math.random() * words.length);
		lblWord.setText(words[idx]);
	}

	private void handlestop() {

		timer.stop();

		int choice = JOptionPane.showConfirmDialog(this, "Wanna Replay");

		if (choice == JOptionPane.YES_OPTION) {
			setupGame();
		} else {
			if (choice == JOptionPane.NO_OPTION) {
				super.dispose();
			} else {

				if (TimeRemaining < 0) {
					setupGame();
				} else {
					timer.start();
				}
			}

		}
	}

	private void handlestart() {

		if (isRunning == false) {
			timer.start();
			txtWord.setEnabled(true);
			btnstart.setText("pause");
			btnstop.setEnabled(true);
			isRunning = true;
		} else {
			timer.stop();
			txtWord.setEnabled(false);
			btnstart.setText("Start");
			btnstop.setEnabled(false);

			isRunning = false;
		}
	}
	
}
