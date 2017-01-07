package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class restaurateurControllerTest {
	
	private restaurateurController resController;
	private restaurateurProfile resProfile;
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
		when(database.getMenu()).thenReturn(menu);
		resProfile = new restaurateurProfile("IDG","Pass","GabrieleGianniniRes","Via Roma, 1","Firenze","0556509341","gabrielegiannini2@gmail.com");
		resController = new restaurateurController(resProfile);
	}
	
	@Test
	public void getMenuTest(){
		resController.setMenu(database.getMenu());
		assertEquals(menu,resController.getMenu());
	}

	@Test
	public void AddFoodToMenuNotAlreadyExistsTestCase() {
		List<Dish> menu = new ArrayList<Dish>(this.menu);
		resController.addFoodToMenu(database.getMenu(),dish2);
		menu.add(dish2);
		assertEquals(menu, resController.getMenu());
	}
	
	@Test
	public void AddFoodToMenuAlreadyExistsTestCase() {
		List<Dish> menu = new ArrayList<Dish>(this.menu);
		resController.addFoodToMenu(database.getMenu(),dish1);
		assertEquals(menu, resController.getMenu());
	}
	
	@Test
	public void changePriceToFoodIsInMenuTestCase(){
		double newPrice = resController.changePriceToFood(database.getMenu(),dish1,7.5);
		when(dish1.getPrice()).thenReturn(newPrice);
		assertEquals(7.5,dish1.getPrice(),0);
	}
	
	@Test
	public void changePriceToFoodIsNotInMenuTestCase(){
		double newPrice = resController.changePriceToFood(database.getMenu(),dish2,7.5);
		when(dish2.getPrice()).thenReturn(newPrice);
		assertEquals(0,dish2.getPrice(),0);
	}
	
	@Test
	public void changeCategoryToFoodIsInMenuTestCase(){
		String newCategory = resController.changeCategoryToFood(database.getMenu(),dish1,"Appetizer");
		when(dish1.getCategory()).thenReturn(newCategory);
		assertEquals("Appetizer",dish1.getCategory());
	}
	
	@Test
	public void changeCategoryToFoodIsNotInMenuTestCase(){
		String newCategory = resController.changeCategoryToFood(database.getMenu(),dish2,"Appetizer");
		when(dish2.getCategory()).thenReturn(newCategory);
		assertEquals(null,dish2.getCategory());
	}


}
