package tap.gianninicinquilli.tapproject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DishTest {

	private Dish dish;

	@Before
	public void setUp() {
		dish = new Dish("id0", 2.50, "category", "description");
	}

	@Test
	public void testSetPrice() {
		dish.setPrice(5.23);
		assertEquals(5.23, dish.getPrice(), 0.1);
	}

	@Test
	public void testGetCategory() {
		assertEquals("category", dish.getCategory());
		dish.setCategory("new");
		assertEquals("new", dish.getCategory());
	}

	@Test
	public void testGetDescription() {
		assertEquals("description", dish.getDescription());
	}

	@Test
	public void testGetId() {
		assertEquals("id0", dish.getId());
	}
}
