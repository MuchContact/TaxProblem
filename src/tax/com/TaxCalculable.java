package tax.com;

public interface TaxCalculable {
	public double getTax(double priceWithoutTax);
	public double getShelfPrice(double priceWithoutTax);
}
