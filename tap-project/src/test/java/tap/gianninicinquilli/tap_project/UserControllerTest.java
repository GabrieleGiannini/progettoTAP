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
	private UserProfile userProfile;

	@Before
	public void setUp() throws Exception {
		db = mock(Database.class);
		rest = mock(Restaurant.class);
		menu = new ArrayList<>();
		userProfile = mock(UserProfile.class);
		user = new UserController(db,userProfile);
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
	public void testGetCart(){
		Cart cart = mock(Cart.class);
		user.setCart(cart);
		assertEquals(cart,user.getCart());
	}
	
	@Test
	public void testSendDishToCart(){
		Cart cart = mock(Cart.class);
		Dish dish1 = mock(Dish.class);
		user.setCart(cart);
		user.sendDishToChart(dish1);
		verify(cart, times(1)).add(dish1);
	}
	
	@Test
	public void testGetUserInformations(){
		List<String> informations = new ArrayList<String>();
		informations.add("Gabriele");
		informations.add(new ArrayList<>().toString());
		when(userProfile.getUser()).thenReturn("Gabriele");
		when(userProfile.getOrderHistory()).thenReturn(new ArrayList<>());
		assertEquals(informations, user.getInformations());
	}
	
	@Test
	public void testNewReview(){
		when(db.addReview(userProfile, rest, "Good!")).thenReturn(1);
		int revId = user.newReview(rest, "Good!");
		verify(db, times(1)).addReview(userProfile, rest, "Good!");
		assertEquals(1, revId);
	}
	
	@Test
	public void testUpdateReview(){
		user.updateReview(1, "Really good!");
		verify(db, times(1)).updateReview(1, "Really good!");
	}
	
	@Test
	public void testEmptyGetReviews(){
		when(db.getReviews(userProfile)).thenReturn(new ArrayList<>());
		List<String> result = user.getReviews();
		verify(db, times(1)).getReviews(userProfile);
		assertEquals(new ArrayList<>(), result);
	}
	
	@Test 
	public void testNotEmptyGetReviews(){
		List<String> reviews = new ArrayList<>();
		reviews.add("Good");
		reviews.add("Not bad");
		when(db.getReviews(userProfile)).thenReturn(reviews);
		List<String> result = user.getReviews();
		verify(db, times(1)).getReviews(userProfile);
		assertEquals(reviews, result);
	}
	
	@Test
	public void testPay(){
		Cart cart = mock(Cart.class);
		user.setCart(cart);
		when(cart.pay()).thenReturn(true);
		assertTrue(user.pay());
	}

}