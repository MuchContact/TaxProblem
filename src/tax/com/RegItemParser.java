package tax.com;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegItemParser{
	
	private String source;

	public RegItemParser(String source) {
		this.source = source;
	}

	
	public String parseName() {
		return "book";
	}
	
}
