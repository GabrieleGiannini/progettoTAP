package tap.gianninicinquilli.tapproject;

import java.util.Calendar;

public class ConcreteCreditCard implements CreditCard {

	private String cardNumber;
	private Calendar expirationDate;

	public ConcreteCreditCard(String cardNumber, Calendar expirationDate) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
	}

	@Override
	public String getCardNumber() {
		return cardNumber;
	}

	@Override
	public boolean isValid() {
		Calendar calendar = Calendar.getInstance();
		return calendar.before(expirationDate);
	}

}
