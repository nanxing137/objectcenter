package springhelper.objectcenter.classHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import springhelper.objectcenter.exception.ClassConstructorException;
import springhelper.objectcenter.exception.ClassNewInstanceException;

/**
 * 访问控制使用默认即可</br>
 * 用户面向接口
 * 
 * @author Thornhill
 *
 * @param <T>
 */
class URIClassHeperImpl<T> implements URIClassHelper<T> {
	private final Class<T> clazz;
	private final Constructor<T> constructor;

	public URIClassHeperImpl(Class<T> clazz) {
		super();
		this.clazz = clazz;
		try {
			this.constructor = clazz.getConstructor();
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new ClassConstructorException("获取Constructor失败:", e);
		}
	}

	@Override
	public T get() {
		T newInstance = null;
		try {
			newInstance = constructor.newInstance();
		} catch (SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
			throw new ClassNewInstanceException("构造类对象失败:", e);
		}
		return newInstance;
	}

	@Override
	public Class<T> getURIClass() {
		return clazz;
	}

	@Override
	public Constructor<T> getURIConstructor() {
		return constructor;
	}

}
