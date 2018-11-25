package springhelper.objectcenter.objecthelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import springhelper.objectcenter.exception.FieldNotFoundException;
import springhelper.objectcenter.exception.MethodNotFoundException;

/**
 * 现在这个类大有问题</br>
 * 反射全部改为添加缓存的实现</br>
 * 
 * @date 2018年11月26日
 * @author Thornhill
 *
 * @param <T>
 */
public class CloudObjectImpl<T> implements CloudObject<T> {

	private T t;
	private Class<T> clazz;

	/**
	 * 暂时将这两个域写成这样，后续可能用map或者其他实现，重点是添加缓存
	 */
	private Field[] fields;
	private Method[] methods;

	/**
	 * 重点在这个方法，好好想想怎么实现
	 * 
	 */
	@Override
	public Object invoke(String method) {
		return null;
	}

	@Override
	public Method[] getDeclaredMethods() {
		Method[] declaredMethods = clazz.getDeclaredMethods();
		return declaredMethods;
	}

	@Override
	public Method getDeclaredMethod(String methodName, Class<?>... parameterTypes) {
		Method declaredMethod = null;
		try {
			declaredMethod = clazz.getDeclaredMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new MethodNotFoundException("获取Method错误:", e);
		}
		return declaredMethod;
	}

	@Override
	public Field[] getDeclaredFields() {
		Field[] declaredFields = clazz.getDeclaredFields();
		return declaredFields;
	}

	@Override
	public Field getDeclaredField(String fieldName) {
		Field declaredField = null;
		try {
			declaredField = clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
			throw new FieldNotFoundException("获取Field错误:", e);
		}

		return declaredField;
	}

}
