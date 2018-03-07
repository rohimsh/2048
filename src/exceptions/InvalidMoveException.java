package exceptions;

public class InvalidMoveException extends Exception {

	public InvalidMoveException() {
		System.err.println("Invalid Move!");
	}

	public InvalidMoveException(String message) {
		super(message);
	}

	public InvalidMoveException(Throwable cause) {
		super(cause);
	}

	public InvalidMoveException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMoveException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
