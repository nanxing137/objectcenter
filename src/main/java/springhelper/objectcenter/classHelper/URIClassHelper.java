package springhelper.objectcenter.classHelper;

import java.lang.reflect.Constructor;

import springhelper.objectcenter.objecthelper.CloudObject;

/**
 * 类加载器加载出来的自定义Class封装
 * 
 * @date 2018年11月25日
 * @author Thornhill
 * 
 */
public interface URIClassHelper<T> {
	/**
	 * 用此方法获取一个对象实例
	 * 
	 * @return
	 */
	CloudObject<T> get();

	
	
	/**
	 * 获取Class对象
	 * 
	 * @return
	 */
	Class<T> getURIClass();

	/**
	 * 获取Constructor对象
	 * 
	 * @return
	 */
	Constructor<T> getURIConstructor();
}
