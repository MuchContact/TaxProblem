package tax.com;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private static final String newLine="\r\n";
	
	private List<Purchasable> items;

	private Parser parser;
	
	public Cart(Parser parser) {
		if(parser==null)
			throw new IllegalArgumentException("Error: Parser is null.");
		
		items = new ArrayList<Purchasable>();
		this.parser = parser;
	}
	public Cart add(String source) {
		parser.setTarget(source);
		items.add(parser.parseToPurchase());
		return this;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(itemsDetail());
		sb.append(salesTaxesDetail());
		sb.append(totalPriceDetail());
		return sb.toString();
	}
	private String itemsDetail() {
		StringBuilder sb = new StringBuilder();
		for(Purchasable item:items){
			sb.append(item.detail()+newLine);
		}
		return sb.toString();
	}
	private String salesTaxesDetail() {
		return String.format("Sales Taxes: %.2f%s", getTotalTax(), newLine);
	}
	private String totalPriceDetail() {
		return String.format("Total: %.2f%s", getTotalPrice(), newLine);
	}
	private double getTotalPrice() {
		double totalFee=0;
		for(Purchasable item:items){
			totalFee += item.getShelfPrice();
		}
		return totalFee;
	}
	private double getTotalTax() {
		double totalTax=0;
		for(Purchasable item:items){
			totalTax += item.getTax();
		}
		return totalTax;
	}
}
