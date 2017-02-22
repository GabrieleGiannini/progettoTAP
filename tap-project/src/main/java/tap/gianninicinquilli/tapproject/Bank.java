package tap.gianninicinquilli.tapproject;

public interface Bank {

	boolean acceptPayment(CreditCard creditCard);

	boolean receivedPayment(double d);

}
