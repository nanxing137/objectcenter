package springhelper.objectcenter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import springhelper.objectcenter.exception.FieldNotFoundException;
import springhelper.objectcenter.exception.MethodNotFoundException;
import springhelper.objectcenter.objecthelper.CloudObject;

public interface ITest<T> extends CloudObject<T> {

	// TODO 增加缓存
	// 其实不需要他，如果使用继承，实现接口的形式，直接传递this即可
	// final T t;

	Class<?> clazz;

	/**
	 * 暂时将这两个域写成这样，后续可能用map或者其他实现，重点是添加缓存
	 */
	Map<String, Field> fieldMap;
	Map<String, Map<Class<?>[], Method>> methodMap;

	default void Init() {

		this.clazz = this.getClass();
		t = null;
		// 先行获取Field，放入缓存，因为Field只读不写 ，所以不考虑同步问题
		Field[] declaredFields = this.clazz.getDeclaredFields();
		fieldMap = new HashMap<>(declaredFields.length);
		for (Field field : declaredFields) {
			fieldMap.put(field.getName(), field);
		}
		// 天秀的一个MethodMap,不会涉及同步写，所以不考虑同步问题
		methodMap = new HashMap<String, Map<Class<?>[], Method>>();
		Method[] declaredMethods = this.clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			Class<?>[] parameterTypes = method.getParameterTypes();

			methodMap.putIfAbsent(method.getName(), new HashMap<Class<?>[], Method>());
			Map<Class<?>[], Method> putIfAbsent = methodMap.get(method.getName());
			putIfAbsent.put(parameterTypes, method);

			// HashMap<Class<?>[], Method> hashMap = new HashMap<Class<?>[], Method>();
			// hashMap.put(parameterTypes, method);
			// methodMap.merge(method.getName(),hashMap , (t1,t2)->{ t1.putAll(t2);return
			// t1;});

			// HashMap<Class<?>[], Method> hashMap = new HashMap<Class<?>[], Method>();
			// hashMap.put(parameterTypes, method);
			// methodMap.merge(method.getName(), hashMap, (t1, t2) -> {
			// t1.putAll(t2);
			// return t1;
			// });

		}
	}

	/**
	 * 重点在这个方法，好好想想怎么实现
	 * 
	 */
	@Override
	default Object invoke(String method) {
		return null;
	}

	/**
	 * 下面的一系列方法也需要修改，修改为增加缓存版本
	 */
	@Override
	default Method[] getDeclaredMethods() {
		Method[] declaredMethods = clazz.getDeclaredMethods();
		return declaredMethods;
	}

	@Override
	default Method getDeclaredMethod(String methodName, Class<?>... parameterTypes) {
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
	default Field[] getDeclaredFields() {
		Field[] declaredFields = clazz.getDeclaredFields();
		return declaredFields;
	}

	@Override
	default Field getDeclaredField(String fieldName) {
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
