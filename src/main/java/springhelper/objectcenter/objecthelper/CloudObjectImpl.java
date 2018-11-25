package springhelper.objectcenter.objecthelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import springhelper.objectcenter.exception.FieldNotFoundException;

public class CloudObjectImpl<T> implements CloudObject<T> {

	private T t;
	private Class<T> clazz;

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
		try {
			clazz.getDeclaredMethod(methodName, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
