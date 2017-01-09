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

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<String> getInformations() {
		List<String> informations = new ArrayList<>();
		informations.add(user.getUser());
		informations.add(user.getOrderHistory().toString());
		return informations;
	}

	public int newReview(Restaurant rest, String review) {
		return database.addReview(user, rest, review);
	}

	public void updateReview(int reviewId, String newReview) {
		database.updateReview(reviewId, newReview);
	}

	public List<String> getReviews() {
		return database.getReviews(user);
	}

}