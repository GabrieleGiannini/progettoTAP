package tap.gianninicinquilli.tapproject;

public class Dish {

	private String category;
	private String id;
	private double price;
	private String description;

	public Dish(String id, double price, String category, String description) {
		this.id = id;
		this.price = price;
		this.category = category;
		this.description = description;
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

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

}
