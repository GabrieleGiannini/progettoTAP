package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DishTest {

	private Dish dish;

	@Before
	public void setUp() {
		dish = new Dish("fakecategory");
	}

	@Test
	public void testSetPrice() {
		dish.setPrice(5.23);
		assertEquals(5.23, dish.getPrice(), 0.1);
	}

	@Test
	public void testGetCategory() {
		assertEquals("fakecategory", dish.getCategory());
		dish.setCategory("new");
		assertEquals("new", dish.getCategory());
	}

}
