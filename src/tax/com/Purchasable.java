package tax.com;

public interface Purchasable {
	public double getShelfPrice();
	public double getTax();
	public String detail();
	public Purchasable newInstanceFromBean(Bean bean);
}

