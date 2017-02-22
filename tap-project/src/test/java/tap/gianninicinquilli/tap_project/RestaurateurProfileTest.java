package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RestaurateurProfileTest {
	private RestaurateurProfile resProfile;
	private Restaurant rest;
	
	@Before
	public void setup(){
		rest = new Restaurant("rest1");
		resProfile = new RestaurateurProfile("IDG","Pass","GabrieleGianniniRes","Via Roma, 1","Firenze","0556509341","gabrielegiannini2@gmail.com",rest);
	}

	@Test
	public void getIDTest() {
		assertEquals("IDG",resProfile.getID());
	}
	
	@Test
	public void getPassTest(){
		assertEquals("Pass",resProfile.getPass());
	}
	
	@Test
	public void getNameRestaurantTest(){
		assertEquals("GabrieleGianniniRes",resProfile.getResName());
	}
	
	@Test
	public void getAddressTest(){
		assertEquals("Via Roma, 1",resProfile.getAddres());
	}
	
	@Test
	public void getCityTest(){
		assertEquals("Firenze",resProfile.getCity());
	}
	
	@Test
	public void getTelNumbTest(){
		assertEquals("0556509341",resProfile.getTelNumb());
	}
	
	@Test
	public void getRestaurantTest(){
		assertEquals(rest,resProfile.getRestaurant());
	}

}
