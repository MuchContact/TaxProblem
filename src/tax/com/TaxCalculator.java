package tax.com;

public class TaxCalculator {
	private boolean imported = false;
	private boolean exempted = false;
	
	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public void setExempted(boolean exempted) {
		this.exempted = exempted;
	}
	
	public double getTaxRate() {
		if(exempted&&!imported){
			return .00;
		}else if(exempted&&imported){
			return .05;
		}else if(!exempted&&!imported){
			return .10;
		}else{
			return .15;
		}
	}
	
	public double getShelfPrice(double priceWithoutTax) {
		return priceWithoutTax*getTaxRate() + priceWithoutTax;
	}

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
