package tap.gianninicinquilli.tap_project;

public interface Bank {

	boolean acceptPayment(CreditCard creditCard);

	boolean receivedPayment(double d);

}
