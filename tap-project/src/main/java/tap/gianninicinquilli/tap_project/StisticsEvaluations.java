package tap.gianninicinquilli.tap_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StisticsEvaluations {

	private RestaurateurController restaurateurController;
	private Database database;

	public StisticsEvaluations(RestaurateurController restaurateurController, Database database) {
		this.restaurateurController = restaurateurController;
		this.database = database;
	}

	public double evalAvarageAgeMonth() {
		List<Integer> buyerMonth = database.getAgeBuyersMonth(restaurateurController);
		int sumVar = 0;
		for(int i=0;i<buyerMonth.size();i++){
			sumVar = sumVar + buyerMonth.get(i);
		}
		return (double)(sumVar/buyerMonth.size());
	}

	public double evalAvarageExpenceMonth() {
		List<Double> expenceOfMonth = database.getPricesOfOrdersMonth(restaurateurController);
		double sumVar = 0;
		for(int i=0;i<expenceOfMonth.size();i++){
			sumVar = sumVar + expenceOfMonth.get(i);
		}
		return sumVar/expenceOfMonth.size();
	}

	public Dish getBestSellerMonth() {
		List<Dish> foodSoldMonth = database.getFoodSoldMonth(restaurateurController);
		List<Integer> numberOfSell = new ArrayList<>(Collections.nCopies(foodSoldMonth.size(), 0));
		for(int i = 0;i<foodSoldMonth.size();i++){
			for(int j = i + 1;j<foodSoldMonth.size();j++){
				if(foodSoldMonth.get(i) == foodSoldMonth.get(j))
					numberOfSell.add(numberOfSell.get(i) + 1);						
			}	
		}
		return foodSoldMonth.get(findMax(numberOfSell));
	}

	public int findMax(List<Integer> list) {
		int max = 0;
		int maxIndex = 0;
		for(int i = 0;i<list.size();i++){
			if(max<list.get(i)){
				maxIndex = list.get(i);
			}
		}
		return maxIndex;
	}
	
	

}
