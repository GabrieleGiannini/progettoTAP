package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class CartTest {
	private Cart cart;
	private Dish dish1;
	private Dish dish2;
	private Bank bank;
	private CreditCard creditCard;
	
	@Before
	public void setup(){
		dish1 = spy(new Dish("Food1"));
		dish2 = spy(new Dish("Food2"));
		bank = mock(Bank.class);
		creditCard = mock(CreditCard.class);
		cart = new Cart(bank,creditCard);
		cart.add(dish1);
		cart.add(dish2);
		when(dish1.getPrice()).thenReturn(10.5);
		when(dish2.getPrice()).thenReturn(6.0);
	}
	
	@Test
	public void testCalculateTotal(){
		assertEquals(16.5,cart.calculateTotal(),0);
	}
	
	@Test
	public void testPayAccepted(){
		when(bank.acceptPayment(creditCard)).thenReturn(true);
		when(bank.receivedPayment(anyDouble())).thenReturn(true);
		boolean accept = cart.pay();
		verify(bank,times(1)).acceptPayment(creditCard);
		assertTrue(accept);
	}
	
	@Test
	public void testPayNotAccepted(){
		when(bank.acceptPayment(creditCard)).thenReturn(false);
		when(bank.receivedPayment(anyDouble())).thenReturn(false);
		boolean accept = cart.pay();
		verify(bank,times(1)).acceptPayment(creditCard);
		assertFalse(accept);
	}

}
