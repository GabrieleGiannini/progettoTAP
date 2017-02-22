package tap.gianninicinquilli.tapproject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {

	private Restaurant restaurant;

	@Before
	public void setUp() throws Exception {
		restaurant = new Restaurant("001", "L'osteria dell'oca", "via Mario Rossi 12", "Padova");
	}

	@Test
	public void testGetId() {
		assertEquals("001", restaurant.getId());
	}

	@Test
	public void testGetName() {
		assertEquals("L'osteria dell'oca", restaurant.getName());
	}

	@Test
	public void testGetAddress() {
		assertEquals("via Mario Rossi 12", restaurant.getAddress());
	}

	@Test
	public void testGetCity() {
		assertEquals("Padova", restaurant.getCity());
	}
}
