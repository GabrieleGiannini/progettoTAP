package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserControllerTest {

	private Database db;
	private UserController user;
	private List<Restaurant> restList;
	private Restaurant rest;
	private List<Dish> menu;

	@Before
	public void setUp() throws Exception {
		db = mock(Database.class);
		rest = mock(Restaurant.class);
		menu = new ArrayList<>();
		user = new UserController(db,new UserProfile("Gabriele", "Pass", null));
		restList = new ArrayList<>();
		when(db.getRestaurantsList()).thenReturn(restList);
		when(db.getMenuOf(rest)).thenReturn(menu);
	}

	@Test
	public void testGetRestaurantsList() {
		List<Restaurant> result =  user.getRestaurantsList();
		verify(db, times(1)).getRestaurantsList();
		assertEquals(restList, result);
	}
	
	@Test
	public void GetMenuOf(){
		restList.add(rest);
		List<Dish> result = user.getMenuOf(rest);
		verify(db, times(1)).getMenuOf(rest);
		assertEquals(menu, result);
	}

	
	@Test
	public void testGetChart(){
		Cart chart = new Cart();
		user.setChart(chart);
		assertEquals(chart,user.getChart());
	}
	
	@Test
	public void testSendDishToChart(){
		Cart chart = new Cart();
		Dish dish1 = new Dish("Food1");
		user.setChart(chart);
		user.sendDishToChart(dish1);
		assertTrue(user.getChart().contains(dish1));
	}
	
	
	@Test
	public void testGetUserInformations(){
		UserController user2 = new UserController(db,new UserProfile("Gabriele", "Pass", new ArrayList<Order>()));
		List<String> informations = new ArrayList<String>();
		informations.add("Gabriele");
		informations.add(new ArrayList<Order>().toString());
		assertEquals(informations, user2.getInformations());
	}
	

}