package tax.com;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private static final String newLine="\r\n";
	
	private List<Item> items;
	
	public Cart() {
	}
	public Cart add(String source) {
		items = new ArrayList<Item>();
		RegItemParser parser = new RegItemParser(source);
		Bean bean = parser.parseToBean();
		items.add(Item.createFromBean(bean));
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
		for(Item item:items){
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
		for(Item item:items){
			totalFee += item.getShelfPrice();
		}
		return totalFee;
	}
	private double getTotalTax() {
		double totalTax=0;
		for(Item item:items){
			totalTax += item.getTax();
		}
		return totalTax;
	}
}
