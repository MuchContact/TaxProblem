package tax.com;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class NumberFormater {

	public static double roundWith2Decimals(double number) {
		return roundWithDecimals(2, number);
	}
	
	public static double roundWithDecimals(int decimalNum, double number) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(decimalNum);
		return new BigDecimal(nf.format(number)).doubleValue();
	}
}
