package springhelper.objectcenter.objecthelper;

/**
 * 所有从URIClassLoader获取的对象都有的包装类</br>
 * 这个类持有加载到的Class对象</br>
 * 用户的终点，所有的方法，所有的属性，都从这个代理对象中获得</br>
 * 这个类时重点，涉及大量反射，所以可以加缓存，甚至实现一些线程安全问题</br>
 * 
 * @date 2018年11月26日
 * @author Thornhill
 *
 * @param <T>
 */
public interface CloudObject<T> {
	Object invoke(String method);
}
