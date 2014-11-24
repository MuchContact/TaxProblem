package tax.com;

public class RoundupToNearestFivePercentImpl implements Roundup {

	@Override
	public double roundup(double number) {
		if(divisibleBy0_05(number)){
			return number;
		}
		return roundupToNearestFivePercent(number);
	}
	
	private boolean divisibleBy0_05(double dividend){
		boolean numberAfterSecondDecimalDigitEqualsZero=(dividend*100==(int)(dividend*100));
		boolean numberBeforeThirdDecimalDigitDivisibleBy0_05 = (int)(dividend*100)%5==0;
		return numberAfterSecondDecimalDigitEqualsZero&&
				numberBeforeThirdDecimalDigitDivisibleBy0_05;
	}
	private double roundupToNearestFivePercent(double number){
		number += .05;
		int result=(int)(number*100);
		int lastDigit=result%10;
		if(lastDigit>=5){
			result = result-(lastDigit-5);
		}else{
			result = result-(lastDigit-0);
		}
		return result/100d;
	}
}
