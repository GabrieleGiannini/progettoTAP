package tap.gianninicinquilli.tapproject;

public interface Bank {

	boolean acceptPayment(String creditCardNumber);

	boolean receivedPayment(double d);

}
