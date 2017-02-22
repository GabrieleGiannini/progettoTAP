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
	private UserProfile user = new UserProfile("user", "pass", null);
	private UserController userC;
	private List<Restaurant> restList;
	private List<Dish> menu;
	private Restaurant rest;
	private Restaurant rest1;
	private Restaurant rest2;
	private Restaurant rest3;

	@BeforeClass
	public static void onceSetUp(){
		FailOnThreadViolationRepaintManager.install();
	}
	
	@Before
	public void setup(){
		rest = new Restaurant();
		rest1 = new Restaurant();
		rest2 = new Restaurant();
		rest3 = new Restaurant();
		
		menu = new ArrayList<Dish>();
		menu.add(new Dish("PROVA1"));
		
		restList = new ArrayList<Restaurant>();
		restList.add(rest);
		restList.add(rest1);
		restList.add(rest2);
		restList.add(rest3);
		database = mock(Database.class);
		when(database.getRestaurantsList()).thenReturn(restList);
		when(database.getMenuOf(rest)).thenReturn(menu);
		userC=new UserController(database, user);
		
		Robot robot = BasicRobot.robotWithNewAwtHierarchy();
		UserFrame frame = GuiActionRunner.execute(() -> new UserFrame(userC));
		frameFixture = new FrameFixture(robot,frame);
		frameFixture.show();
		robot.settings().delayBetweenEvents(300);
		
	}
	
	@Test
	public void shouldCopyTextInLabelWhenClickingButton() {
		frameFixture.button("restButton").click();
		for(int i=0;i<restList.size();i++){
			frameFixture.list("resultList").selectItem(i).requireSelection(restList.get(i).toString());
		}
	}
	
	
	@After
	public void signalSemaphoreResources(){
		frameFixture.cleanUp();
	}

}
