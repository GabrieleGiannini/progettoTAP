package tap.gianninicinquilli.tap_project;

public class restaurateurProfile {

	private String ID;
	private String pass;
	private String nomeRes;
	private String address;
	private String city;
	private String telNumber;
	private String email;

	public restaurateurProfile(String ID, String pass, String nomeRes, String address, String city,
			String telNumber, String email) {
				this.ID = ID;
				this.pass = pass;
				this.nomeRes = nomeRes;
				this.address = address;
				this.city = city;
				this.telNumber = telNumber;
				this.email = email;
	}

	public String getID() {
		return ID;
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
	
	
}
