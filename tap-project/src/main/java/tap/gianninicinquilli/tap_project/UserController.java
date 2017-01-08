package tap.gianninicinquilli.tap_project;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Matchers;

public class UserController {

	private Database database;
	private Chart chart;
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
		chart.add(dish1);
	}

	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public List<String> getInformations() {
		List<String> informations = new ArrayList<String>();
		informations.add(user.getUser());
		if(user.getOrderHistory()!=null){
			informations.add(user.getOrderHistory().toString());
		}else{
			informations.add(null);
		}
		
		return informations;
	}
	
	

}