package tap.gianninicinquilli.tapproject;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	private Bank bank;
	private CreditCard creditCard;
	private List<Dish> dishesList;

	public Cart(Bank bank, CreditCard creditCard) {
		this.bank = bank;
		this.creditCard = creditCard;
		dishesList = new ArrayList<>();
	}

	public double calculateTotal() {
		double total = 0;
		for (int i = 0; i < dishesList.size(); i++) {
			total = total + dishesList.get(i).getPrice();
		}
		return total;
	}

	public boolean pay() {
		boolean paymentAcceppted;
		boolean paymentReceived = false;
		paymentAcceppted = bank.acceptPayment(creditCard.getCardNumber());
		if (paymentAcceppted)
			paymentReceived = bank.receivedPayment(calculateTotal());
		return paymentReceived;
	}

	public void add(Dish dish) {
		dishesList.add(dish);
	}

	public Dish getDish(int index) {
		return dishesList.get(index);
	}

	public int size() {
		return dishesList.size();
	}

}
