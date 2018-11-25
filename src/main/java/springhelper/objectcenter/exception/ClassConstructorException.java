package springhelper.objectcenter.exception;

/**
 * 获取Constructor失败
 * @date 2018年11月25日
 * @author Thornhill
 *
 */
public class ClassConstructorException extends RuntimeException {

	public ClassConstructorException() {
		super();
	}

	public ClassConstructorException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClassConstructorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClassConstructorException(String message) {
		super(message);
	}

	public ClassConstructorException(Throwable cause) {
		super(cause);
	}

}
