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

	public double roundupToNearestFivePercent(double d) {
		// TODO Auto-generated method stub
		return 0.15;
	}

}
