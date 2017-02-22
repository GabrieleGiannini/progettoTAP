package tap.gianninicinquilli.tapproject;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class OrderTest {

	private Order order;

	@Before
	public void setUp() throws Exception {
		order = new Order();
	}

	@Test
	public void testAddDish() {
		Dish dish = mock(Dish.class);
		order.add(dish);
		assertEquals(1, order.getDishes().size());
	}

	@Test
	public void testSetPrice() {
		assertEquals(0, order.getTotalPrice(), 0.1);
		order.setTotalPrice(25.0);
		assertEquals(25.0, order.getTotalPrice(), 0.1);
	}

}
