
/*This class is for the giving my random guesses and the creating Threads*/
import java.util.ArrayList;

public class Mastermind {
	
	private int hidden_number;
	ArrayList<Results> Guesses = new ArrayList<Results>();
	
	
	public Mastermind(int hidden_number){
		
		this.hidden_number=hidden_number;
	}
	
	public void play() {
		
		int ok=0;
		
		//My random guesses
		Guesses.add(new Results(1234,hidden_number));
		Guesses.add(new Results(5678,hidden_number));
		Guesses.add(new Results(9012,hidden_number));
	
		
		for (int i=0; i<Guesses.size(); i++){
				
			if(Guesses.get(i).getCorrect_location()==4){
				ok=1;
				Display display=new Display();
				display.GuessResult(Guesses, (i+1));
				break;
			}
		}
		if(ok!=1){
			Thread th1 = new Thread(new FindingGuess(0000, 2499, Guesses));
			Thread th2 = new Thread(new FindingGuess(2500, 4999, Guesses));
			Thread th3 = new Thread(new FindingGuess(5000, 7499, Guesses));
			Thread th4 = new Thread(new FindingGuess(7500, 9999, Guesses));

			th1.start();
			th2.start();
			th3.start();
			th4.start();
		}
	}
}