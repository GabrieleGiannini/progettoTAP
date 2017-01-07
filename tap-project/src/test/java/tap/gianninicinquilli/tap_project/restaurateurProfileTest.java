package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class restaurateurProfileTest {
	restaurateurProfile resProfile;
	
	@Before
	public void setup(){
		resProfile = new restaurateurProfile("IDG","Pass","GabrieleGianniniRes","Via Roma, 1","Firenze","0556509341","gabrielegiannini2@gmail.com");
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
	public void getAddress(){
		assertEquals("Via Roma, 1",resProfile.getAddres());
	}
	
	@Test
	public void getCity(){
		assertEquals("Firenze",resProfile.getCity());
	}
	
	@Test
	public void getTelNumb(){
		assertEquals("0556509341",resProfile.getTelNumb());
	}

}
