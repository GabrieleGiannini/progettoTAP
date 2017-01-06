package tap.gianninicinquilli.tap_project;

public class Dish{

	private String Name;
	private String IDFood;
	private double Price;

	public Dish(String string) {
	
	}

	public Dish(String name, String idfood,double price) {
		Name = name;
		IDFood = idfood;
		Price = price;
	}

	public String getIDFOOD() {
		return IDFood;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public double getPrice() {
		return Price;
	}

}
