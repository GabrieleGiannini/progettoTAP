package tap.gianninicinquilli.tap_project;

public class Dish {

	private String category;
	private double price;

	public Dish(String category) {
		this.category = category;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
