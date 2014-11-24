package tax.com;


public class Good implements Purchasable{

	private String unit;
	private String name;
	private double price;
	private boolean imported;
	private TaxCalculable taxCalc;

	public Good(String name, String unit, double price, boolean imported, TaxCalculable tc) {
		this.name = name;
		this.unit = unit;
		this.price = price;
		this.imported = imported;
		this.taxCalc = tc;
	}

	public double getTax() {
		return taxCalc.getTax(price);
	}

	public double getShelfPrice() {
		return price+getTax();
	}

	public String getName() {
		return name;
	}

	public String getDecoration() {
		StringBuilder sb = new StringBuilder();
		if(imported)
			sb.append(" imported");
		if(unit!=null&&!unit.trim().equals(""))
			sb.append(" "+unit + " of");
		return sb.toString();
	}

	@Override
	public String detail() {
		// TODO Auto-generated method stub
		return null;
	}
}
