package springhelper.objectcenter.objecthelper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

import springhelper.objectcenter.exception.FieldNotFoundException;
import springhelper.objectcenter.exception.MethodNotFoundException;

/**
 * 现在这个类大有问题</br>
 * 反射全部改为添加缓存的实现</br>
 * 设计使用外观模式
 * @date 2018年11月26日
 * @author Thornhill
 *
 * @param <T>
 */
public class CloudObjectImpl<T> implements CloudObject<T> {

	// TODO 增加缓存
	private T t;
	private Class<T> clazz;
	/**
	 * 暂时将这两个域写成这样，后续可能用map或者其他实现，重点是添加缓存
	 */
	/**
	 * 后面可能增加Interface，annotation之类的get方法
	 */
	private Map<String, Field> fieldMap;
	private Map<String, Map<Class<?>[], Method>> methodMap;

	public CloudObjectImpl(T t, Class<T> clazz) {
		super();
		this.t = t;
		this.clazz = clazz;
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
		}
	}

	/**
	 *  重点在这个方法，好好想想怎么实现
	 *  
	 */
	@Override
	public Object invoke(String method) {
		return null;
	}

	/**
	 * 下面的一系列方法也需要修改，修改为增加缓存版本
	 */
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
