package tap.gianninicinquilli.tap_project;

import java.util.List;

public class restaurateurController {

	private restaurateurProfile resProfile;
	private List<Dish> menu;

	public restaurateurController(restaurateurProfile resProfile) {
		this.resProfile = resProfile;
	}

	public void addFoodToMenu(List<Dish> menu, Dish dish) {
		if(menu.contains(dish)){
			this.menu = menu;
		}else{
			menu.add(dish);
			this.menu = menu;
		}
	}


	public double changePriceToFood(List<Dish> menu, Dish dish, double price) {
		if(menu.contains(dish)){
			dish.setPrice(price);
			return price;
		}else{
			return 0;
		}
	}

	public String changeCategoryToFood(List<Dish> menu2, Dish dish, String category) {
		if(menu2.contains(dish)){
			dish.setCategory(category);
			return category;
		}else{
			return null;
		}
	}

	public List<Dish> getMenu() {
		return menu;
	}
	
	public void setMenu(List<Dish> menu2) {
		this.menu = menu2;
	}
	
}
