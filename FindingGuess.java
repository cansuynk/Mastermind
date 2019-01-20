
/*This class is for the Threads's guess routine*/
import java.util.ArrayList;

public class FindingGuess implements Runnable{
	
	int begin;
	int end;
	int count;
	ArrayList<Results> Guesses;
	
	public FindingGuess(int begin,int end,ArrayList<Results> Guesses) {
		this.count=3;
		this.begin=begin;
		this.end=end;
		this.Guesses=Guesses;
	}
	
	@Override
	public void run() {

		try {
			
			int ok=0;
			for (int currentnumber = begin; currentnumber <= end; currentnumber++) {
				ok=0;
				count++;
				for (int i=0; i<Guesses.size(); i++){
				
					Results guessResult = new Results(Guesses.get(i).getNumber(),currentnumber);
					if (guessResult.getWrong_location()==Guesses.get(i).getWrong_location() 
							&& guessResult.getCorrect_location()==Guesses.get(i).getCorrect_location()){
						ok=1;
					
					}
					else{
						ok=0;
						break;
					}
				}
				
				if (ok==1){
					
					Results guessResult1 = new Results(currentnumber, Guesses.get(0).getHiddennumber());
					Guesses.add(guessResult1);
					
					if(guessResult1.getCorrect_location()==4 && guessResult1.getWrong_location()==0){
						
						Display display=new Display();
						display.GuessResult(Guesses,this.count);
	
						if (Thread.interrupted()) {
							
							throw new InterruptedException();
						}
					}	
				}
			}
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}