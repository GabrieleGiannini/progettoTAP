package tap.gianninicinquilli.tap_project;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class StatisticsEvaluationsTest {
	
	private StisticsEvaluations statEval;
	private Database database;
	private RestaurateurController resControl;
	
	@Before
	public void setup(){
		resControl = mock(RestaurateurController.class);
		database = mock(Database.class);
		statEval = new StisticsEvaluations(resControl,database);
	}
	
	@Test
	public void evalAvarageAgeMonthTest(){
		List<Integer> Ages = new ArrayList<Integer>();
		Ages.add(24);
		Ages.add(32);
		when(database.getAgeBuyersMonth(resControl)).thenReturn(Ages);
		double avarageAge = statEval.evalAvarageAgeMonth();
		assertEquals(((24+32)/(2)),avarageAge,0);
	}
	
	@Test
	public void evalAvarageSpentMonthTest(){
		List<Double> pricesOfOrders = new ArrayList<Double>();
		pricesOfOrders.add(18.5);
		pricesOfOrders.add(21.4);
		when(database.getPricesOfOrdersMonth(resControl)).thenReturn(pricesOfOrders);
		double avarageExpence = statEval.evalAvarageExpenceMonth();
		assertEquals(((18.5+21.4)/(2)),avarageExpence,0);
	}
	
	@Test
	public void findMaxTest(){
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(10);
		assertEquals(10,statEval.findMax(list));
	}
	
	@Test
	public void getBestSellerMonthTest(){
		List<Dish> foodSold = new ArrayList<Dish>();
		Dish dish1 = spy(new Dish("Food1"));
		Dish dish2 = spy(new Dish("Food2"));
		foodSold.add(dish1);
		foodSold.add(dish1);
		foodSold.add(dish2);
		when(database.getFoodSoldMonth(resControl)).thenReturn(foodSold);
		Dish bestSell = statEval.getBestSellerMonth();
		assertEquals(dish1,bestSell);
	}
	
	
	

	

}
