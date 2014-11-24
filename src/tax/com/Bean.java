package tax.com;

public class Bean {
	int quantity = 0;
	String name = null;
	String unit = null;
	double price = 0;
	boolean imported = false;
	boolean exempted = false;
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isImported() {
		return imported;
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public boolean isExempted() {
		return exempted;
	}
	public void setExempted(boolean exempted) {
		this.exempted = exempted;
	}
	@Override
	public int hashCode() {
		int hashcode;
		hashcode = name==null?1:name.hashCode();
		hashcode += quantity;
		return hashcode;
	}
	@Override
	public boolean equals(Object e) {
		if (e == this)
			return true;
		if (!(e instanceof Bean)) {
			return false;
		}
		Bean bean = (Bean)e;
		return quantity == bean.getQuantity()
				&&imported == bean.isImported()
				&&exempted == bean.isExempted()
				&&price == bean.getPrice()
				&&(name==bean.getName()||(name!=null&&name.equals(bean.getName())));
	}
}
