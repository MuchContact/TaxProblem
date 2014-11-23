package tax.com;

import org.junit.Test;

import junit.framework.Assert;

public class NumberFormaterTest {
	@Test
	public void round_0_889_With2Decimal_return_0_89(){
		NumberFormater nf = new NumberFormater();
		Assert.assertEquals(.89, nf.roundWith2Decimals(0.889));
	}
}
