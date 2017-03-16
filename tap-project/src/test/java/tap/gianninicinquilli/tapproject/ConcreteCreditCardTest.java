package tap.gianninicinquilli.tapproject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class ConcreteCreditCardTest {

	@Test
	public void testCreditCardGetNumber() {
		ConcreteCreditCard card = new ConcreteCreditCard("12345678900", null);
		assertEquals("12345678900", card.getCardNumber());
	}

	@Test
	public void testValidityIsTrueIfNotExpired() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2020, Calendar.JANUARY, 3);
		ConcreteCreditCard card = new ConcreteCreditCard("", calendar);
		assertTrue(card.isValid());
	}

	@Test
	public void testValidityIsFalseIfExpired() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2001, Calendar.JANUARY, 3);
		ConcreteCreditCard card = new ConcreteCreditCard("", calendar);
		assertFalse(card.isValid());
	}
}
