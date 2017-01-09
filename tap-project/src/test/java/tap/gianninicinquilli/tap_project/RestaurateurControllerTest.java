package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class RestaurateurControllerTest {
	
	private RestaurateurController resController;
	private RestaurateurProfile resProfile;
	private List<Dish> menu;
	private Database database;
	private Dish dish2;
	private Dish dish1;
	
	@Before
	public void setup(){
		dish1 = spy(new Dish("Food1"));
		dish2 = spy(new Dish("Food2"));
		menu = new ArrayList<Dish>();
		menu.add(dish1);
		database = mock(Database.class);
		resProfile = mock(RestaurateurProfile.class);
		resController = new RestaurateurController(resProfile,database);
		when(database.getMenuOf(resProfile.getRestaurant())).thenReturn(menu);
	}
	
	@Test
	public void getMenuTest(){
		resController.getMenuFromDB();
		verify(database,times(1)).getMenuOf(resProfile.getRestaurant());
		assertEquals(menu,resController.getMenuFromDB());
	}

	@Test
	public void addFoodToMenuNotAlreadyExistsTestCase() {
		List<Dish> menu = new ArrayList<Dish>(this.menu);
		resController.addFoodToMenu(dish2);
		menu.add(dish2);
		verify(database,times(2)).getMenuOf(resProfile.getRestaurant());
		assertEquals(menu, resController.getMenuFromDB());
	}
	
	@Test
	public void addFoodToMenuAlreadyExistsTestCase() {
		List<Dish> menu = new ArrayList<Dish>(this.menu);
		resController.addFoodToMenu(dish1);
		verify(database,times(1)).getMenuOf(resProfile.getRestaurant());
		assertEquals(menu, resController.getMenuFromDB());
	}
	
	@Test
	public void changePriceToFoodIsInMenuTestCase(){
		double newPrice = resController.changePriceToFood(dish1,7.5);
		when(dish1.getPrice()).thenReturn(newPrice);
		verify(database,times(1)).getMenuOf(resProfile.getRestaurant());
		assertEquals(7.5,dish1.getPrice(),0);
	}
	
	@Test
	public void changePriceToFoodIsNotInMenuTestCase(){
		double newPrice = resController.changePriceToFood(dish2,7.5);
		when(dish2.getPrice()).thenReturn(newPrice);
		verify(database,times(1)).getMenuOf(resProfile.getRestaurant());
		assertEquals(0,dish2.getPrice(),0);
	}
	
	@Test
	public void changeCategoryToFoodIsInMenuTestCase(){
		String newCategory = resController.changeCategoryToFood(dish1,"Appetizer");
		when(dish1.getCategory()).thenReturn(newCategory);
		verify(database,times(1)).getMenuOf(resProfile.getRestaurant());
		assertEquals("Appetizer",dish1.getCategory());
	}
	
	@Test
	public void changeCategoryToFoodIsNotInMenuTestCase(){
		String newCategory = resController.changeCategoryToFood(dish2,"Appetizer");
		when(dish2.getCategory()).thenReturn(newCategory);
		verify(database,times(1)).getMenuOf(resProfile.getRestaurant());
		assertEquals(null,dish2.getCategory());
	}


}
