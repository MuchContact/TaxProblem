package tax.com;

import org.junit.Test;

import junit.framework.Assert;

public class NumberFormaterTest {
	@Test
	public void round_0_889_With2Decimal_return_0_89(){
		Assert.assertEquals(.89, NumberFormater.roundWith2Decimals(0.889));
	}
	@Test
	public void round_0_881_With2Decimal_return_0_88(){
		Assert.assertEquals(.88, NumberFormater.roundWith2Decimals(0.881));
	}
	@Test
	public void round_1_1_With2Decimal_return_1_10(){
		Assert.assertEquals(1.10, NumberFormater.roundWith2Decimals(1.1));
	}
}
