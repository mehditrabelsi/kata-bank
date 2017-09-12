package tn.wevioo.kata.bank.exception;

/**
 * 
 * @since 10 septembre 2017
 * @author Mehdi
 */
public class AmountMinMaxValueException extends Exception {
	public AmountMinMaxValueException() {
		super();
	}

	public AmountMinMaxValueException(String message) {
		super(message);
	}

	public AmountMinMaxValueException(String message, Throwable cause) {
		super(message, cause);
	}

	public AmountMinMaxValueException(Throwable cause) {
		super(cause);
	}

	protected AmountMinMaxValueException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
