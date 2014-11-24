package tax.com;

public class TaxCalculatorFactory {
	
	private static final TaxCalculator basicTaxCalc;
	private static final TaxCalculator noTaxCalc;
	private static final TaxCalculator importedNoTaxCalc;
	private static final TaxCalculator importedBasicTaxCalc;
	
	static{
		Roundup round = new RoundupToNearestFivePercentImpl();
		
		basicTaxCalc = new TaxCalculator(round);
		basicTaxCalc.setExempted(false);
		basicTaxCalc.setImported(false);
		
		noTaxCalc = new TaxCalculator(round);
		noTaxCalc.setExempted(true);
		noTaxCalc.setImported(false);
		
		importedNoTaxCalc = new TaxCalculator(round);
		importedNoTaxCalc.setExempted(true);
		importedNoTaxCalc.setImported(true);
		
		importedBasicTaxCalc = new TaxCalculator(round);
		importedBasicTaxCalc.setExempted(false);
		importedBasicTaxCalc.setImported(true);
		
		
	}
	public static TaxCalculator getTaxCalcInstance(){
		return getTaxCalcInstance(false, false);
	}
	public static TaxCalculator getTaxCalcInstance(boolean isImported, boolean isExempt){
		if(isExempt&&isImported)
			return importedNoTaxCalc;
		else if(isExempt&&!isImported)
			return noTaxCalc;
		else if(!isExempt&&isImported)
			return importedBasicTaxCalc;
		else
			return basicTaxCalc;
	}
}
