package tax.com;

import org.junit.Assert;
import org.junit.Test;

public class CartTest {
	@Test
	public void checkReceiptGivenItemsOfInput1(){
		Cart cart = new Cart();
		cart.add("1 book at 12.49")
			.add("1 music CD at 14.99")
			.add("1 chocolate bar at 0.85");
		Assert.assertTrue(cart.toString().contains("1 book: 12.49"));
		Assert.assertTrue(cart.toString().contains("1 music CD: 16.49"));
		Assert.assertTrue(cart.toString().contains("1 chocolate bar: 0.85"));
		Assert.assertTrue(cart.toString().contains("Sales Taxes: 1.50"));
		Assert.assertTrue(cart.toString().contains("Total: 29.83"));
	}
}
