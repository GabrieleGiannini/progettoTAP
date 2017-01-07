package tap.gianninicinquilli.tap_project;

import java.util.List;

public interface Database {

	List<Dish> getMenu();

	List<Dish> getMenuOf(Restaurant restaurant);

	List<Restaurant> getRestaurantsList();

}
