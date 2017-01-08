package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class UserProfileTest {

	private static final String PASSWORD = "passw";
	private static final String USER = "user";
	private UserProfile userProfile;
	private List<Order> orderHistory;

	@Before
	public void setUp() {
		orderHistory = new ArrayList<>();
		userProfile = new UserProfile(USER, PASSWORD, orderHistory);
	}

	@Test
	public void testUserCreation() {
		assertEquals(USER, userProfile.getUser());
		assertTrue(userProfile.isPassword(PASSWORD));
		assertEquals(orderHistory, userProfile.getOrderHistory());
	}
	

}