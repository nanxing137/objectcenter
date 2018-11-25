package springhelper.objectcenter.exception;

/**
 * 通过反射获取Field失败
 * 
 * @date 2018年11月26日
 * @author Thornhill
 *
 */
public class FieldNotFoundException extends RuntimeException {

	public FieldNotFoundException() {
		super();
	}

	public FieldNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FieldNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldNotFoundException(String message) {
		super(message);
	}

	public FieldNotFoundException(Throwable cause) {
		super(cause);
	}

}
