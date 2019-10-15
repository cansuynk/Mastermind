
/* This class is for the separation digits of hidden number and guesses, and the finding correct or wrong placed digits*/
public class Results {
	
	private int hiddennumber;
	private int digit_1;
	private int digit_2;
	private int digit_3;
	private int digit_4;
	
	private int number;
	private int guessdigit_1;
	private int guessdigit_2;
	private int guessdigit_3;
	private int guessdigit_4;
	
	private int wrong_locations;
	private int correct_locations;
	
	public Results(int number,int hiddennumber){
		this.number=number;
		this.hiddennumber=hiddennumber;
		
		this.separate_digits(number,hiddennumber);	
		this.outcome(digit_1,digit_2,digit_3,digit_4);
		
	}
	public void separate_digits(int number ,int hiddennumber){
		this.guessdigit_1=number/1000;
		this.guessdigit_2=(number/100)%10;
		this.guessdigit_3=(number/10)%10;
		this.guessdigit_4=number%10;	
		
		this.digit_1=this.hiddennumber/1000;
		this.digit_2=(this.hiddennumber/100)%10;
		this.digit_3=(this.hiddennumber/10)%10;
		this.digit_4=this.hiddennumber%10;
		
	}
	
	public int getHiddennumber() {
		return hiddennumber;
	}
	public int getNumber() {
		return number;
	}
	
	public void outcome(int digit1,int digit2,int digit3,int digit4){
		int correct_count=0;
		int wrong_count=0;
		if (digit1==guessdigit_1)
			correct_count++;
		if (digit2==guessdigit_2)
			correct_count++;
		if (digit3==guessdigit_3)
			correct_count++;
		if (digit4==guessdigit_4)
			correct_count++;
		
		if (guessdigit_1!=digit1 && ((guessdigit_1==digit2 && guessdigit_2!=digit2) 
								|| (guessdigit_1==digit3 && guessdigit_3!=digit3) 
								|| (guessdigit_1==digit4 && guessdigit_4!=digit4)))
			wrong_count++;	
		if (guessdigit_2!=digit2 && ((guessdigit_2==digit1 && guessdigit_1!=digit1) 
				|| (guessdigit_2==digit3 && guessdigit_3!=digit3) 
				|| (guessdigit_2==digit4 && guessdigit_4!=digit4)))
			wrong_count++;
		if (guessdigit_3!=digit3 && ((guessdigit_3==digit1 && guessdigit_1!=digit1) 
				|| (guessdigit_3==digit2 && guessdigit_2!=digit2) 
				|| (guessdigit_3==digit4 && guessdigit_4!=digit4)))
			wrong_count++;
		if (guessdigit_4!=digit4 && ((guessdigit_4==digit1 && guessdigit_1!=digit1) 
				|| (guessdigit_4==digit2 && guessdigit_2!=digit2) 
				|| (guessdigit_4==digit3 && guessdigit_3!=digit3)))
			wrong_count++;
		
		this.wrong_locations=wrong_count;
		this.correct_locations=correct_count;
	}
	
	public int getWrong_location() {
		return wrong_locations;
	}
	
	public int getCorrect_location() {
		return correct_locations;
	}
}
