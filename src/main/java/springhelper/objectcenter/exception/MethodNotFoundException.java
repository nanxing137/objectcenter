package springhelper.objectcenter.exception;

/**
 * 通过反射获取Method失败
 * 
 * @date 2018年11月26日
 * @author Thornhill
 *
 */
public class MethodNotFoundException extends RuntimeException {

	public MethodNotFoundException() {
		super();
	}

	public MethodNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MethodNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MethodNotFoundException(String message) {
		super(message);
	}

	public MethodNotFoundException(Throwable cause) {
		super(cause);
	}

}
