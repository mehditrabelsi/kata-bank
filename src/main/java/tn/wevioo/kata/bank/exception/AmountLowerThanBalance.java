package tn.wevioo.kata.bank.exception;

/**
 * Exception levé lorsque le montant est inférieure a la balance
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class AmountLowerThanBalance extends Exception {

	public AmountLowerThanBalance() {
		super();
	}

	public AmountLowerThanBalance(String message) {
		super(message);
	}

	public AmountLowerThanBalance(String message, Throwable cause) {
		super(message, cause);
	}

	public AmountLowerThanBalance(Throwable cause) {
		super(cause);
	}

	protected AmountLowerThanBalance(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
