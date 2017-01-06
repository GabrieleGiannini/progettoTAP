package tap.gianninicinquilli.tap_project;

import java.util.ArrayList;
import java.util.List;

public class RestauraterProfile {

	private List<Dish> menu = new ArrayList<Dish>();

	public List<Dish> getMenu() {
		return menu;
	}

	public void addFoodToMenu(List<Dish> menu, Dish dish) {
		if(!menu.contains(dish)){
			menu.add(dish);
			this.menu = menu;
		}else{
			System.err.print("this food already exists in Menu");
		}
	}

	public double changePriceToDish(List<Dish> menu2, String FOODID, double newPrice) {
		int i=0;
		while(!menu2.get(i).getIDFOOD().equals(FOODID)){
			i++;
		}
		menu2.get(i).setPrice(newPrice);
		return menu2.get(i).getPrice();
	}

}
