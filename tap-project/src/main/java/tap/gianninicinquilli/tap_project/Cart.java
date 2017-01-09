package tap.gianninicinquilli.tap_project;

import java.util.ArrayList;
import java.util.List;

import org.mockito.Matchers;

public class Cart extends ArrayList<Dish>{

	private Bank bank;
	private CreditCard creditCard;

	public Cart(Bank bank, CreditCard creditCard) {
		this.bank = bank;
		this.creditCard = creditCard;
	}

	public double calculateTotal() {
		double total = 0;
		for(int i=0;i<size();i++){
			total = total + get(i).getPrice();
		}
		return total;
	}

	public boolean pay() {
		boolean paymentAcceppted;
		boolean paymentReceived = false;
		calculateTotal();
		paymentAcceppted = bank.acceptPayment(creditCard);
		if(paymentAcceppted)
			paymentReceived = bank.receivedPayment(calculateTotal());
		return paymentReceived;
	}


}
