package tutorial07;

public class LimitException extends Exception {
	public LimitException() {
		super();
	}

	public LimitException(String message) {
		super(message);
	}

	public LimitException(Throwable cause) {
		super(cause);
	}

	public LimitException(String message, Throwable cause) {
		super(message, cause);
	}
}
