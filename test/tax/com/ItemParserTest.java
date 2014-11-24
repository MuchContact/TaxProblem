package tax.com;

import org.junit.Assert;
import org.junit.Test;

import tax.com.reuse.Bean;
import tax.com.reuse.RegItemParser;

public class ItemParserTest {
	@Test
	public void parseNameFromBook_returnBook(){
		RegItemParser ip = new RegItemParser("1 book at 12.49");
		Assert.assertEquals("book",ip.parseName());
	}
	@Test
	public void parseNameFromCD_returnCD(){
		RegItemParser ip = new RegItemParser("1 music CD at 14.99");
		Assert.assertEquals("music CD",ip.parseName());
	}
	@Test
	public void parseNameFromChocolate_returnChocolate(){
		RegItemParser ip = new RegItemParser("1 chocolate bar at 0.85");
		Assert.assertEquals("chocolate bar",ip.parseName());
	}
	@Test
	public void parseNameFromHeadachePills_returnHeadachePills(){
		RegItemParser ip = new RegItemParser("1 packet of headache pills at 9.75");
		Assert.assertEquals("headache pills",ip.parseName());
	}
	
	@Test
	public void parsePacketUnit(){
		RegItemParser ip = new RegItemParser("1 packet of headache pills at 9.75");
		Assert.assertEquals("packet",ip.parseUnit());
	}
	@Test
	public void parseEmptyUnit(){
		RegItemParser ip = new RegItemParser("1 chocolate bar at 0.85");
		Assert.assertEquals("",ip.parseUnit());
	}
	@Test
	public void parseBottleUnit(){
		RegItemParser ip = new RegItemParser("1 bottle of perfume at 18.99");
		Assert.assertEquals("bottle",ip.parseUnit());
	}
	
	@Test
	public void parseQuantityGiven_1_return_1(){
		RegItemParser ip = new RegItemParser("1 bottle of perfume at 18.99");
		Assert.assertEquals(1,ip.parseQuantity());
	}
	
	@Test
	public void parsePriceGiven_18_99_return_18_99(){
		RegItemParser ip = new RegItemParser("1 bottle of perfume at 18.99");
		Assert.assertEquals(18.99,ip.parsePrice(), .00);
	}
	
	@Test
	public void parsePriceGiven_0_85_return_0_85(){
		RegItemParser ip = new RegItemParser("1 bottle of perfume at 0.85");
		Assert.assertEquals(.85,ip.parsePrice(), .00);
	}
	@Test
	public void parseExemptedEqualsTrueGivenFood(){
		RegItemParser ip = new RegItemParser("1 chocolate bar at 0.85");
		Assert.assertTrue(ip.parseExempted());
	}
	@Test
	public void parseExemptedEqualsFalseGivenPerfume(){
		RegItemParser ip = new RegItemParser("1 bottle of perfume at 0.85");
		Assert.assertFalse(ip.parseExempted());
	}
	@Test
	public void parseImportedEqualsFalseGivenDomainPerfume(){
		RegItemParser ip = new RegItemParser("1 bottle of perfume at 0.85");
		Assert.assertFalse(ip.parseImported());
	}
	@Test
	public void parseImportedEqualsTrueGivenImportedPerfume(){
		RegItemParser ip = new RegItemParser("1 imported bottle of perfume at 27.99");
		Assert.assertTrue(ip.parseImported());
	}
	@Test
	public void parseBeanGivenImportedPerfume(){
		RegItemParser ip = new RegItemParser("1 imported bottle of perfume at 27.99");
		Bean bean = new Bean();
		bean.setExempted(false);
		bean.setImported(true);
		bean.setName("perfume");
		bean.setQuantity(1);
		bean.setUnit("bottle");
		bean.setPrice(27.99);
		Assert.assertEquals(bean , ip.parseToBean());
	}
	
}
