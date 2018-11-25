package springhelper.objectcenter.objectergenter;

import springhelper.objectcenter.classloader.URIClassLoader;
import springhelper.objectcenter.objecthelper.CloudObject;

public interface ClassLoaderHelper {
	
	static CloudObject get(String name,byte[] bytes) {
		ClassLoader classLoader = new URIClassLoader(bytes);
		Class<?> loadClass = null;
		try {
			loadClass = classLoader.loadClass(name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	};
}
