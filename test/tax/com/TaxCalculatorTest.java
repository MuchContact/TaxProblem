package tax.com;

import org.junit.Assert;
import org.junit.Test;

public class TaxCalculatorTest {
	
	@Test
	public void get_tax_rate_at_0_15_when_item_is_imported_and_unexempted(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(true, false);
		Assert.assertEquals(.15, tc.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_10_when_item_is_normal(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(false, false);
		Assert.assertEquals(.10, tc.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_05_when_item_is_imported_and_unexempted(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(true, true);
		Assert.assertEquals(.05, tc.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_when_item_is_domain_and_exempted(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(false, true);
		Assert.assertEquals(.00, tc.getTaxRate(), .001);
	}
	@Test
	public void round_0_13_upToNearest_0_05_return_0_15(){
		Assert.assertEquals(.15, TaxCalculatorFactory.getTaxCalcInstance().roundup(.13), .0001);
	}	
	@Test
	public void round_0_16_upToNearest_0_05_return_0_20(){
		Assert.assertEquals(.20, TaxCalculatorFactory.getTaxCalcInstance().roundup(.16), .0001);
	}
	@Test
	public void round_0_15_upToNearest_0_05_return_0_15(){
		Assert.assertEquals(.15, TaxCalculatorFactory.getTaxCalcInstance().roundup(.15), .0001);
	}
	@Test
	public void round_0_151_upToNearest_0_05_return_0_20(){
		Assert.assertEquals(.20, TaxCalculatorFactory.getTaxCalcInstance().roundup(.151), .0001);
	}
	@Test
	public void round_0_624_upToNearest_0_05_return_0_65(){
		Assert.assertEquals(.65, TaxCalculatorFactory.getTaxCalcInstance(false, true).roundup(.624), .0001);
	}
	@Test
	public void get_priceWithTax_at_20_89_given_normal_item_at_18_99(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(false, false);
		Assert.assertEquals(20.89, tc.getShelfPrice(18.99), .0001);
	}
	@Test
	public void get_priceWithTax_at_16_49_given_normal_item_at_14_99(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(false, false);
		Assert.assertEquals(16.49, tc.getShelfPrice(14.99), .0001);
	}
	@Test
	public void get_priceWithTax_at_32_19_given_imported_and_unexempted_item_at_27_99(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(true, false);
		Assert.assertEquals(32.19, tc.getShelfPrice(27.99), .0001);
	}
	@Test
	public void get_priceWithTax_at_12_49_given_unimported_and_exempted_item_at_12_49(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(false, true);
		Assert.assertEquals(12.49, tc.getShelfPrice(12.49), .0001);
	}
	@Test
	public void get_priceWithTax_at_0_85_given_unimported_and_exempted_item_at_0_85(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(false, true);
		Assert.assertEquals(.85, tc.getShelfPrice(.85), .0001);
	}
	@Test
	public void get_priceWithTax_at_11_85_given_imported_and_exempted_item_at_11_25(){
		TaxCalculator tc = TaxCalculatorFactory.getTaxCalcInstance(true, true);
		Assert.assertEquals(11.85, tc.getShelfPrice(11.25), .0001);
	}

}
