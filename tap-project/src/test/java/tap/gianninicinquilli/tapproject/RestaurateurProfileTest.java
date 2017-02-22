package tap.gianninicinquilli.tapproject;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class RestaurateurProfileTest {
	private RestaurateurProfile resProfile;
	private Restaurant rest;

	@Before
	public void setup() {
		rest = mock(Restaurant.class);
		resProfile = new RestaurateurProfile("IDG", "Pass", "0556509341", "gabrielegiannini2@gmail.com", rest);
	}

	@Test
	public void getIDTest() {
		assertEquals("IDG", resProfile.getId());
	}

	@Test
	public void getPassTest() {
		assertEquals("Pass", resProfile.getPass());
	}

	@Test
	public void getTelNumbTest() {
		assertEquals("0556509341", resProfile.getTelNumb());
	}

	@Test
	public void getRestaurantTest() {
		assertEquals(rest, resProfile.getRestaurant());
	}
	
	@Test
	public void getEmailTest(){
		assertEquals("gabrielegiannini2@gmail.com", resProfile.getEmail());
	}

}
