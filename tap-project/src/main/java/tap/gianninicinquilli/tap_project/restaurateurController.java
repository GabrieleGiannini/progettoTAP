package tap.gianninicinquilli.tap_project;

import java.util.List;

public class restaurateurController {

	private restaurateurProfile resProfile;
	private List<Dish> menu;
	private Database database;

	public restaurateurController(restaurateurProfile resProfile, Database database) {
		this.resProfile = resProfile;
		this.database = database;
	}

	public void addFoodToMenu(Dish dish) {
		setMenu();
		if(menu.contains(dish)){
			this.menu = menu;
		}else{
			menu.add(dish);
		}
	}


	public double changePriceToFood(Dish dish, double price) {
		setMenu();
		if(menu.contains(dish)){
			dish.setPrice(price);
			return price;
		}else{
			return 0;
		}
	}

	public String changeCategoryToFood(Dish dish, String category) {
		setMenu();
		if(menu.contains(dish)){
			dish.setCategory(category);
			return category;
		}else{
			return null;
		}
	}

	public List<Dish> getMenu() {
		return menu;
	}
	
	public void setMenu() {
		this.menu = database.getMenu();
	}
	
}
