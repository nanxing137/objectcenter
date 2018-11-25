package springhelper.objectcenter.classHelper;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class URIClassHeperImpl implements URIClassHelper{
	private Class<?> clazz = null;
	private Constructor<?> constructor;
	@Override
	public Object get() {
		try {
			constructor = clazz.getConstructor();
			Object newInstance = constructor.newInstance();
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
