package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserFrameTest {
	FrameFixture frameFixture;
	private Database database;
	List<Order> orderHistory = new ArrayList<Order>();
	private UserProfile user = new UserProfile("user", "pass", orderHistory);
	private UserController userC;
	private List<Restaurant> restList;
	private List<Dish> menu;
	private Restaurant rest;
	private Restaurant rest1;
	private Restaurant rest2;
	private Restaurant rest3;
	private List<String> revList;
	private Cart cart;

	@BeforeClass
	public static void onceSetUp(){
		FailOnThreadViolationRepaintManager.install();
	}
	
	@Before
	public void setup(){
		menu = new ArrayList<Dish>();
		menu.add(new Dish("Dish1"));
		
		revList = new ArrayList<String>();
		revList.add("Reviews1");
		
		cart = new Cart(null, null);
		cart.add(new Dish("Dish2"));
		
		rest = new Restaurant("rest");
		rest1 = new Restaurant("rest1",menu);
		rest2 = new Restaurant("rest2");
		rest3 = new Restaurant("rest3");
		
		restList = new ArrayList<Restaurant>();
		restList.add(rest);
		restList.add(rest1);
		restList.add(rest2);
		restList.add(rest3);
		database = mock(Database.class);
		when(database.getRestaurantsList()).thenReturn(restList);
		when(database.getMenuOf(rest)).thenReturn(menu);
		when(database.getReviews(user)).thenReturn(revList);
		userC=new UserController(database, user);
		userC.setCart(cart);
		
		Robot robot = BasicRobot.robotWithNewAwtHierarchy();
		UserFrame frame = GuiActionRunner.execute(() -> new UserFrame(userC));
		frameFixture = new FrameFixture(robot,frame);
		frameFixture.show();
		robot.settings().delayBetweenEvents(100);
	}
	
	@Test
	public void shouldReturnInJlistTheRestaurantList() {
		frameFixture.button("restButton").click();
		for(int i=0;i<restList.size();i++){
			frameFixture.list("resultList").selectItem(i).requireSelection(restList.get(i).getName());
		}
	}
	
	@Test
	public void shouldReturnInJlistTheMenuOfARestaurant() {
		frameFixture.textBox("nameRes").enterText("rest1");
		frameFixture.button("getMenu").click();
		for(int i=0;i<menu.size();i++){
			frameFixture.list("resultList").selectItem(i).requireSelection(menu.get(i).getID());
		}	
	}
	
	@Test
	public void shouldReturnInJlistTheInformationsOfUser() {
		frameFixture.button("getInfo").click();
		for(int i=0;i<userC.getInformations().size();i++){
			frameFixture.list("resultList").selectItem(i).requireSelection(userC.getInformations().get(i));
		}
	}
	
	@Test
	public void shouldReturnInJlistTheReviews() {
		frameFixture.button("getRev").click();
		for(int i=0;i<userC.getReviews().size();i++){
			frameFixture.list("resultList").selectItem(i).requireSelection(userC.getReviews().get(i));
		}
	}
	
	@Test
	public void shouldReturnInJlistTheCart() {
		frameFixture.button("getCart").click();
		for(int i=0;i<userC.getCart().size();i++){
			frameFixture.list("resultList").selectItem(i).requireSelection(userC.getCart().get(i).getID());
		}
	}
	
	@Test
	public void dragNdrop() {
		frameFixture.button("getRev").click();
		frameFixture.list("resultList").drag(0);
		frameFixture.list("dragDrop").drop(0);
	}
	
	
	@After
	public void signalSemaphoreResources(){
		frameFixture.cleanUp();
	}

}
