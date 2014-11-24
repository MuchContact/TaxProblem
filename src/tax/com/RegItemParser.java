package tax.com;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegItemParser extends Parser{
	private static final String PATTERN = "([0-9]+)(.+ of)?(.+) at\\s+([0-9]+\\.[0-9]+)";
	
	//private String source;
	
	private static List<String> exemptedDic;
	
	static {
		exemptedDic = new ArrayList<String>();
		exemptedDic.add("chocolate");
		exemptedDic.add("pills");
		exemptedDic.add("book");
	}
	public RegItemParser() {
	}
	public RegItemParser(String source) {
		this.source = source;
	}
	public String parseName() {
		if(!checkValid(source))
			return null;
		return source.replaceAll(PATTERN, "$3").replace("imported", "").trim();
	}
	private boolean checkValid(String source){
		if(source==null)
			return false;
		Pattern pat = Pattern.compile(PATTERN);
		Matcher match = pat.matcher(source);
		return match.matches();
	}
	public String parseUnit() {
		if(!checkValid(source))
			return null;
		return source.replaceAll(PATTERN, "$2").replace("imported", "").replace("of", "").trim();
	}
	public int parseQuantity() {
		if(!checkValid(source))
			return 0;
		return Integer.valueOf(source.replaceAll(PATTERN, "$1"));
	}
	public double parsePrice() {
		if(!checkValid(source))
			return 0;
		return Double.valueOf(source.replaceAll(PATTERN, "$4"));
	}
	public boolean parseExempted() {
		if(!checkValid(source))
			return false;
		for(String each:exemptedDic){
			if(source.contains(each))
				return true;
		}
		return false;
	}
	public boolean parseImported() {
		if(!checkValid(source))
			return false;
		
		return source.contains("imported");
	}
}
