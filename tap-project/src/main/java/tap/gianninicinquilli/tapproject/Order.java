package tap.gianninicinquilli.tapproject;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Dish> dishes;
	private double totalPrice;

	public Order() {
		dishes = new ArrayList<>();
	}

	public void add(Dish dish) {
		dishes.add(dish);
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

}
