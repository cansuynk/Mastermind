
/*This class is for the display of guesses and outcomes (third frame) */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Display extends JFrame implements ActionListener{
	
	private int count;
	
	JLabel label=new JLabel("RESULTS:");
	JButton button1 = new JButton("AGAIN");
	JButton button2 = new JButton("EXIT");
	
	public Display() {
		
		super("RESULTS");
		count=50;
		setVisible(true);
		setLayout(null);
		setSize(600, 600);
		getContentPane().setBackground(Color.green);
		setLocationRelativeTo(null);
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		add(button1);
		add(button2);
		button1.setBounds(150, 400, 100, 50);
		button2.setBounds(300, 400, 100, 50);
		
		label.setForeground(Color.red);
		label.setBounds(100, 50, 100, 50);
		add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void GuessResult(ArrayList<Results> Guesses,int tries) {
		
		JLabel label1 = new JLabel("Enter the hidden number:   "+Guesses.get(0).getHiddennumber());
		label1.setLocation(200,count);
        label1.setSize(200,100);
		add(label1);
		count=count+20;
		
		for (int i=0; i<((tries>Guesses.size())?Guesses.size():tries); i++){
			
			JLabel label2 = new JLabel("Guess  " + (i+1)+ ":   " + Guesses.get(i).getNumber() + "   " 
			+ Guesses.get(i).getWrong_location() + "W " + Guesses.get(i).getCorrect_location() + "C");
			label2.setLocation(210,count);
	        label2.setSize(200,100);
			add(label2);
			count=count+20;	
		}
		
		JLabel label3 = new JLabel("Found in " +((tries>Guesses.size())?Guesses.size():tries)
									+" guess in "+ tries +" tries.");
		label3.setLocation(200,count+20);
        label3.setSize(200,100);
		add(label3);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == button1) {
			this.dispose();
			WelcomeMenu menu =new WelcomeMenu();
			menu.setVisible(true);
		}
		if (arg0.getSource() == button2) {
			System.exit(1);
		}
	}
}