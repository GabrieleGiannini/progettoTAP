package tap.gianninicinquilli.tap_project;

public class Dish {

	private String foodID;
	private double price;

	public Dish(String foodID) {
		this.foodID = foodID;
	}

	public void setPrice(double price) {//empty because is stubbed
		
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return null;
	}

	public void setCategory(String category) {//empty because is stubbed
		
	}

	public String getID() {
		return foodID;
	}

}
