package springhelper.objectcenter.classgenter;

import springhelper.objectcenter.classHelper.URIClassHelper;
import springhelper.objectcenter.classHelper.URIClassHeperImpl;
import springhelper.objectcenter.classloader.URIClassLoader;
import springhelper.objectcenter.exception.ClassLoaderNotFoundException;
import springhelper.objectcenter.objecthelper.CloudObject;

/**
 * 一切故事的开始</br>
 * 对用户的唯一入口</br>
 * 后期可以从这里结合URI</br>
 * @author Thornhill
 *
 * @param <T>
 */
public interface ClassLoaderHelper<T> {

	static <T> URIClassHelper<T> get(String name, byte[] bytes) {
		ClassLoader classLoader = new URIClassLoader(bytes);
		Class<T> loadClass = null;

		try {
			loadClass = (Class<T>) classLoader.loadClass(name);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ClassLoaderNotFoundException("URI类加载器加载类失败", e);
		}
		URIClassHelper<T> uriClassHelper = new URIClassHeperImpl<T>(loadClass);
		return uriClassHelper;
	};
}
