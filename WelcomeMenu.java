
/*I did GUI.Therefore this class is for the starting menu (first frame)*/
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class WelcomeMenu extends JFrame implements ActionListener {

	JLabel label1=new JLabel("~~WELCOME MY MASTERMIND GAME~~");
	JLabel label2=new JLabel("LET'S PLAY!");
	JLabel label3=new JLabel("|PRESS THE PLAY BUTTON|");
	JButton button1 = new JButton("PLAY");
	

	public WelcomeMenu() {
		super("WELCOME THE MASTERMIND");
		setLayout(null);
		
		label1.setLocation(200, 0);
        label1.setSize(500, 300);
        label1.setForeground(Color.blue);
        add(label1);
        
        label2.setLocation(270, 0);
        label2.setSize(500, 350);
        label2.setForeground(Color.blue);
        add(label2);
        
        label3.setLocation(230, 0);
        label3.setSize(500, 400);
        label3.setForeground(Color.blue);
        add(label3);
        
		button1.addActionListener(this);
		button1.setBounds(225, 240, 150, 100);
		add(button1);
		
		setSize(600, 600);
		getContentPane().setBackground(Color.pink);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new WelcomeMenu().setVisible(true);
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource() == button1) {
			Game newGame = new Game();
			newGame.setVisible(true);
			this.dispose();
		}	
	}
}