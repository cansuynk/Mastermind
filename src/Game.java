
/*This class is for the taking hidden number from the user (second frame)*/
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Game extends JFrame implements ActionListener {
	
	JLabel label1=new JLabel("!!!YOUR HIDDEN NUMBER CANNOT HAVE MORE THAN 4 DIGITS!!!");
	JLabel label2=new JLabel("ENTER YOUR HIDDEN NUMBER:");
	JTextField field1 = new JTextField("");
	
	JButton button1 = new JButton("FIND");
	JButton button2 = new JButton("CANCEL");

	public Game() {
		super("MASTERMIND");
		setLayout(null);
		
		label1.setLocation(100, 0);
        label1.setSize(500, 300);
        label1.setForeground(Color.red);
        add(label1);
        
        label2.setLocation(90,110);
        label2.setSize(500, 300);
        label2.setForeground(Color.blue);
        add(label2);
        
		button1.addActionListener(this);
		button2.addActionListener(this);

		setLayout(null);
		setLocation(500, 500);
		add(field1);
		field1.setBounds(270, 220, 150, 100);
		
		add(button1);
		button1.setBounds(150, 400, 100, 50);
		add(button2);
		button2.setBounds(300, 400, 100, 50);
		setSize(600, 600);
		getContentPane().setBackground(Color.cyan);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == button1) {
			try{
				if (field1.getText().length() < 5) {
					Mastermind game = new Mastermind(Integer.parseInt(field1.getText()));
					game.play();
					this.setVisible(false);
				}
			}
			catch(NumberFormatException e){}
		}
		if (arg0.getSource() == button2) {
			System.exit(1);
		}
	}
}