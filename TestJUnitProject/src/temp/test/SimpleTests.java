package temp.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SimpleTests {

	static String throwAnException() throws Exception
	{
		throw new Exception("Failing");
	}
	@Test
	void testThatShouldPass() 
	{
		assertEquals("string", "string");
	}
	@Test
	void testThatShouldFail() 
	{
		assertEquals("string", "otherString");
	}
	@Test
	void testThatShouldFailWithAnException() throws Exception
	{
		assertEquals("string", throwAnException());
	}

}
