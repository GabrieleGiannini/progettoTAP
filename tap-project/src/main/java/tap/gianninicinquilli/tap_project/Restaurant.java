package tap.gianninicinquilli.tap_project;

public class Restaurant {

	private String id;
	private String name;
	private String address;
	private String city;

	public Restaurant(String resId, String name, String address, String city) {
		this.id = resId;
		this.name = name;
		this.address = address;
		this.city = city;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}
}
