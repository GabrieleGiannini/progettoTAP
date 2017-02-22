package tap.gianninicinquilli.tapproject;

import java.util.List;

public class UserProfile {

	private String user;
	private String password;
	private List<Order> orderHistory;

	public UserProfile(String user, String password, List<Order> orderHistory) {
		this.user = user;
		this.password = password;
		this.orderHistory = orderHistory;
	}

	public String getUser() {
		return user;
	}

	public boolean isPassword(String password) {
		return this.password.equals(password);
	}

	public List<Order> getOrderHistory() {
		return orderHistory;
	}

}