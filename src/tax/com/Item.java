package tax.com;

public class Item implements Purchasable{

	private Good good;
	private int quantity;

	public Item(Good good, int quantity) {
		this.good = good;
		this.quantity = quantity;
	}

	public double getShelfPrice() {
		return quantity*good.getShelfPrice();
	}

	public double getTax() {
		return quantity*good.getTax();
	}

	public static Item createFromBean(Bean bean) {
		TaxCalculable tc = TaxCalculatorFactory.getTaxCalcInstance(bean.isImported(), bean.isExempted());
		return new Item(
				new Good(bean.getName(),
						bean.getUnit(),
						bean.getPrice(),
						bean.isImported(),
						tc)
				, bean.getQuantity());
	}
	@Override
	public String detail() {
		return String.format("%d%s %s: %.2f", 
				quantity, good.getDecoration(), 
				good.getName(), getShelfPrice());
	}
}
