package tap.gianninicinquilli.tap_project;

import java.util.List;

public class RestaurateurController {

	private RestaurateurProfile resProfile;
	private Database database;

	public RestaurateurController(RestaurateurProfile resProfile, Database database) {
		this.resProfile = resProfile;
		this.database = database;
	}

	public void addFoodToMenu(Dish dish) {
		if(!getMenuFromDB().contains(dish))
			getMenuFromDB().add(dish);
	}


	public double changePriceToFood(Dish dish, double price) {
		if(getMenuFromDB().contains(dish)){
			dish.setPrice(price);
			return price;
		}else{
			return 0;
		}
	}

	public String changeCategoryToFood(Dish dish, String category) {
		if(getMenuFromDB().contains(dish)){
			dish.setCategory(category);
			return category;
		}else{
			return null;
		}
	}

	public List<Dish> getMenuFromDB() {
		return database.getMenuOf(resProfile.getRestaurant());
	}

	
}
