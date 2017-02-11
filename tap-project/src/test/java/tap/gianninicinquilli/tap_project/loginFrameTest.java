package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class loginFrameTest {
	private FrameFixture frameFixture;

	@BeforeClass
	public static void onceSetUp(){
		FailOnThreadViolationRepaintManager.install();
	}
	
	@Before
	public void setup(){
		Robot robot = BasicRobot.robotWithNewAwtHierarchy();
		loginFrame frame = GuiActionRunner.execute(() -> new loginFrame());
		frameFixture = new FrameFixture(robot,frame);
		frameFixture.show();
		
		robot.settings().delayBetweenEvents(100);
		
	}
	
	@Test
	public void shouldCopyTextInLabelWhenClickingButton() {
		frameFixture.textBox("ID").enterText("user");
		frameFixture.textBox("Pass:").enterText("user");
		frameFixture.button("OK button").click();
		frameFixture.textBox("ID").requireText("OK");
	}
	
	@After
	public void signalSemaphoreResources(){
		frameFixture.cleanUp();
	}

}
