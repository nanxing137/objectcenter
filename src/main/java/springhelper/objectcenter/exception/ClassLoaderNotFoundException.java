package springhelper.objectcenter.exception;

/**
 * 自定义类加载器Helper类构件自定义类加载器失败时
 * 
 * @date 2018年11月25日
 * @author Thornhill
 *
 */
public class ClassLoaderNotFoundException extends RuntimeException {

	public ClassLoaderNotFoundException() {
		super();
	}

	public ClassLoaderNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClassLoaderNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClassLoaderNotFoundException(String message) {
		super(message);
	}

	public ClassLoaderNotFoundException(Throwable cause) {
		super(cause);
	}

}
