package tax.com;

import org.junit.Assert;
import org.junit.Test;

public class TaxCalculatorTest {
	@Test
	public void get_tax_rate_at_0_15_when_item_is_imported_and_unexempted(){
		TaxCalculator tc = new TaxCalculator();
		tc.setImported(true);
		tc.setExempted(false);
		Assert.assertEquals(.15, tc.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_10_when_item_is_normal(){
		TaxCalculator tc = new TaxCalculator();
		tc.setImported(false);
		tc.setExempted(false);
		Assert.assertEquals(.10, tc.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_05_when_item_is_imported_and_unexempted(){
		TaxCalculator tc = new TaxCalculator();
		tc.setImported(true);
		tc.setExempted(true);
		Assert.assertEquals(.05, tc.getTaxRate(), .001);
	}
	@Test
	public void get_tax_rate_at_0_when_item_is_domain_and_exempted(){
		TaxCalculator tc = new TaxCalculator();
		tc.setImported(false);
		tc.setExempted(true);
		Assert.assertEquals(.00, tc.getTaxRate(), .001);
	}
	@Test
	public void get_priceWithTax_at_20_89_given_normal_item_at_18_99(){
		TaxCalculator tc = new TaxCalculator();
		tc.setImported(false);
		tc.setExempted(false);
		Assert.assertEquals(20.89, tc.getShelfPrice(18.99), .001);
	}
	@Test
	public void round_0_13_upToNearest_0_05_return_0_15(){
		TaxCalculator tc = new TaxCalculator();
		Assert.assertEquals(.15, tc.roundupToNearestFivePercent(.13), .001);
	}

}
