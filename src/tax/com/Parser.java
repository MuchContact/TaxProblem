package tax.com;

public abstract class Parser {
	protected String source;
	public void setTarget(String source){
		this.source = source;
	}
	public abstract String parseName();
	public abstract String parseUnit();
	public abstract int parseQuantity();
	public abstract double parsePrice();
	public abstract boolean parseExempted();
	public abstract boolean parseImported();
	
	public Bean parseToBean(){
		Bean bean = new Bean();
		bean.setName(parseName());
		bean.setPrice(parsePrice());
		bean.setUnit(parseUnit());
		bean.setExempted(parseExempted());
		bean.setImported(parseImported());
		bean.setQuantity(parseQuantity());
		return bean;
	}
}
