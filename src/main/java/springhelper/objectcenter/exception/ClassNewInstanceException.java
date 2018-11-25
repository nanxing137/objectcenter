package springhelper.objectcenter.exception;

/**
 * 获取对象失败
 * @date 2018年11月25日
 * @author Thornhill
 *
 */
public class ClassNewInstanceException extends RuntimeException {

	public ClassNewInstanceException(String message) {
		super(message);
	}

	public ClassNewInstanceException() {
		super();
	}

	public ClassNewInstanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClassNewInstanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClassNewInstanceException(Throwable cause) {
		super(cause);
	}
	
}
