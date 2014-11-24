package tax.com;

import org.junit.Assert;
import org.junit.Test;


public class CartTest {
	@Test
	public void checkReceiptGivenItemsOfInput1(){
		Cart cart = new Cart(new RegItemParser());
		cart.add("1 book at 12.49")
			.add("1 music CD at 14.99")
			.add("1 chocolate bar at 0.85");
		Assert.assertTrue(cart.toString().contains("1 book: 12.49"));
		Assert.assertTrue(cart.toString().contains("1 music CD: 16.49"));
		Assert.assertTrue(cart.toString().contains("1 chocolate bar: 0.85"));
		Assert.assertTrue(cart.toString().contains("Sales Taxes: 1.50"));
		Assert.assertTrue(cart.toString().contains("Total: 29.83"));
	}
	@Test
	public void checkReceiptGivenItemsOfInput2(){
		Cart cart = new Cart(new RegItemParser());
		cart.add("1 imported box of chocolates at 10.00")
			.add("1 imported bottle of perfume at 47.50");
		Assert.assertTrue(cart.toString().contains("1 imported box of chocolates: 10.50"));
		Assert.assertTrue(cart.toString().contains("1 imported bottle of perfume: 54.65"));
		Assert.assertTrue(cart.toString().contains("Sales Taxes: 7.65"));
		Assert.assertTrue(cart.toString().contains("Total: 65.15"));
	}
	@Test
	public void checkReceiptGivenItemsOfInput3(){
		Parser parser = new RegItemParser();
		Cart cart = new Cart(parser);
		cart.add("1 imported bottle of perfume at 27.99")
			.add("1 bottle of perfume at 18.99")
			.add("1 packet of headache pills at 9.75")
			.add("1 box of imported chocolates at 11.25");
		Assert.assertTrue(cart.toString().contains("1 imported bottle of perfume: 32.19"));
		Assert.assertTrue(cart.toString().contains("1 bottle of perfume: 20.89"));
		Assert.assertTrue(cart.toString().contains("1 packet of headache pills: 9.75"));
		Assert.assertTrue(cart.toString().contains("1 imported box of chocolates: 11.85"));
		Assert.assertTrue(cart.toString().contains("Sales Taxes: 6.70"));
		Assert.assertTrue(cart.toString().contains("Total: 74.68"));
	}
}
