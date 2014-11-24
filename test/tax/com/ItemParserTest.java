package tax.com;

import org.junit.Assert;
import org.junit.Test;

public class ItemParserTest {
	@Test
	public void parseNameFromBook_returnBook(){
		RegItemParser ip = new RegItemParser("1 book at 12.49");
		Assert.assertEquals("book",ip.parseName());
	}
	
}
