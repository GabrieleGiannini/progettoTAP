package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class restauraterProfileTest {
	RestauraterProfile restauraterProfile;
	RestaurantDB restaurantDB;
	List <Dish> menu;
	List <Dish> menu2;
	Dish dish4;
	
	@Before
	public void setup(){
		restauraterProfile = new RestauraterProfile();
		restaurantDB = mock(RestaurantDB.class);
		dish4 = new Dish("Food4");
		when(restaurantDB.getMenu()).thenReturn(restauraterProfile.getMenu());
	}

	@Test
	public void addFoodToMenuNotAlreadyExistsCase() {
		List<Dish> menu = new ArrayList<Dish>(restaurantDB.getMenu());
		restauraterProfile.addFoodToMenu(restaurantDB.getMenu(),dish4);
		menu.add(dish4);
		assertEquals(restauraterProfile.getMenu(),menu);
	}
	
	@Test
	public void addFoodToMenuAlreadyExistsCase(){
		List<Dish> menu = new ArrayList<Dish>(restaurantDB.getMenu());
		restauraterProfile.addFoodToMenu(restaurantDB.getMenu(),dish4);
		restauraterProfile.addFoodToMenu(restaurantDB.getMenu(),dish4);
		menu.add(dish4);
		assertEquals(restauraterProfile.getMenu(),menu);
	}
	
	@Test
	public void changePriceToDishTest(){
		restauraterProfile.addFoodToMenu(restaurantDB.getMenu(),new Dish("food2","IDFOOD2",7.65));
		List<Dish> menu = new ArrayList<Dish>(restaurantDB.getMenu());
		int i=0;
		while((!menu.get(i).getIDFOOD().equals("IDFOOD2")) || i < menu.size()-1){
			i++;
		}
		menu.get(i).setPrice(6.5);
		assertEquals(menu.get(i).getPrice(),restauraterProfile.changePriceToDish(restaurantDB.getMenu(), "IDFOOD2", 6.5),0);
	}
	
	
	
	

}
