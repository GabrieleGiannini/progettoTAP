package tap.gianninicinquilli.tap_project;

import java.util.List;

public class Restaurant {
	private String name;
	private List<Dish> menu;

	public Restaurant(String name) {
		this.name = name;
	}

	public Restaurant(String name, List<Dish> menu) {
		this.name = name;
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public List<Dish> getMenu() {
		return menu;
	}
	
}
