package test.jpmorgan.simplesale;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import test.jpmorgan.simplesale.entity.Message;
import test.jpmorgan.simplesale.util.MessageParser;

/**
 * The Class MessageParserTest.
 */
public class MessageParserTest {

	/**
	 * Should parse type 1 success.
	 */
	@Test
	public void shouldParseType1Success() {
		Message m = MessageParser.readJson("{\"product\":\"apple\",\"value\":\"£0.1\"}");

		// assert statements
		assertEquals("apple", m.getProductType());
		assertEquals(new BigDecimal("0.1"), m.getValue());
		assertEquals(false, m.getOperation().isPresent());
		assertEquals(false, m.getAmount().isPresent());
	}

	/**
	 * Should parse type 2 success.
	 */
	@Test
	public void shouldParseType2Success() {
		Message m = MessageParser.readJson("{\"product\":\"apple\",\"amount\":\"20\",\"value\":\"£0.1\"}");

		// assert statements
		assertEquals("apple", m.getProductType());
		assertEquals(new BigDecimal("0.1"), m.getValue());
		assertEquals(false, m.getOperation().isPresent());
		assertEquals(true, m.getAmount().isPresent());
		assertEquals(20, m.getAmount().get());
	}

	/**
	 * Should parse type 3 success.
	 */
	@Test
	public void shouldParseType3Success() {
		Message m = MessageParser.readJson("{\"operation\":\"add\",\"product\":\"apple\",\"value\":\"£0.1\"}");

		// assert statements
		assertEquals("apple", m.getProductType());
		assertEquals(new BigDecimal("0.1"), m.getValue());
		assertEquals(true, m.getOperation().isPresent());
		assertEquals("add", m.getOperation().get());
		assertEquals(false, m.getAmount().isPresent());
	}
}
