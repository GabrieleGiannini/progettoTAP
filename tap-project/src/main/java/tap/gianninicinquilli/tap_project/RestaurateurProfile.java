package tap.gianninicinquilli.tap_project;

public class RestaurateurProfile {

	private String iD;
	private String pass;
	private String nomeRes;
	private String address;
	private String city;
	private String telNumber;
	private String email;
	private Restaurant restaurant;

	public RestaurateurProfile(String iD, String pass, String nomeRes, String address, String city,
			String telNumber, String email,Restaurant restaurant) {
				this.iD = iD;
				this.pass = pass;
				this.nomeRes = nomeRes;
				this.address = address;
				this.city = city;
				this.telNumber = telNumber;
				this.email = email;
				this.restaurant = restaurant;
	}

	public String getID() {
		return iD;
	}

	public String getPass() {
		return pass;
	}

	public String getResName() {
		return nomeRes;
	}

	public String getAddres() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getTelNumb() {
		return telNumber;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

}
