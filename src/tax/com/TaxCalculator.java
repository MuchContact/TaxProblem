package tax.com;

public class TaxCalculator implements TaxCalculable{
	private boolean imported = false;
	private boolean exempted = false;
	private Roundup round;
	
	public TaxCalculator(Roundup round) {
		this.round = round;
	}

	public void setImported(boolean imported) {
		this.imported = imported;
	}

	public void setExempted(boolean exempted) {
		this.exempted = exempted;
	}
	
	public void setRoundup(Roundup round){
		this.round = round;
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
		return roundup(priceWithoutTax*getTaxRate()) 
				+ priceWithoutTax;
	}

	public double roundup(double number) {
		return round.roundup(number);
	}

	public double getTax(double priceWithoutTax) {
		return roundup(priceWithoutTax*getTaxRate());
	}
}
