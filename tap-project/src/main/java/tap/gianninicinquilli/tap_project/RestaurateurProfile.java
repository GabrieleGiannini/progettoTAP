package tap.gianninicinquilli.tap_project;

public class RestaurateurProfile {

	private String iD;
	private String pass;
	private String telNumber;
	private String email;
	private Restaurant restaurant;

	public RestaurateurProfile(String iD, String pass, String telNumber, String email, Restaurant restaurant) {
		this.iD = iD;
		this.pass = pass;
		this.telNumber = telNumber;
		this.email = email;
		this.restaurant = restaurant;
	}

	public String getId() {
		return iD;
	}

	public String getPass() {
		return pass;
	}

	public String getTelNumb() {
		return telNumber;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public String getEmail() {
		return email;
	}

}
