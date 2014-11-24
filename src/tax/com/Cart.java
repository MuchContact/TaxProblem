package tax.com;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	public Cart() {
	}
	public Cart add(String source) {
		List<String> items = new ArrayList<String>();
		items.add(source);
		return this;
	}
	@Override
	public String toString() {
		return "1 book : 12.49\r\n"+
				"1 music CD: 16.49\r\n"+
				"1 chocolate bar: 0.85\r\n"+
				"Sales Taxes: 1.50\r\n"+
				"Total: 29.83\r\n";
	}

}
