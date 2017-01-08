package tap.gianninicinquilli.tap_project;

import java.util.ArrayList;
import java.util.List;

public class UserController {

	private Database database;
	private Cart cart;
	private UserProfile user;

	public UserController(Database db,UserProfile user) {
		this.database = db;
		this.user = user;
	}

	public List<Restaurant> getRestaurantsList() {
		return database.getRestaurantsList();
	}

	public List<Dish> getMenuOf(Restaurant restaurant) {
			return database.getMenuOf(restaurant);
	}

	public void sendDishToChart(Dish dish1) {
		cart.add(dish1);
	}

	public Cart getChart() {
		return cart;
	}

	public void setChart(Cart chart) {
		this.cart = chart;
	}

	public List<String> getInformations() {
		List<String> informations = new ArrayList<>();
		informations.add(user.getUser());
		informations.add(user.getOrderHistory().toString());
		return informations;
	}
	
	
	

}