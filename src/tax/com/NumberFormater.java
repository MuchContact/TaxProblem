package tax.com;

import java.math.BigDecimal;
import java.text.NumberFormat;

public class NumberFormater {

	public double roundWith2Decimals(double number) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(2);
		nf.setMinimumFractionDigits(2);
		return new BigDecimal(nf.format(number)).doubleValue();
	}

}
