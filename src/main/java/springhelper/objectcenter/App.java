package springhelper.objectcenter;

import java.lang.reflect.Method;

import springhelper.objectcenter.classHelper.URIClassHeperImpl;
import springhelper.objectcenter.classloader.URIClassLoader;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Method method;
		URIClassLoader classLoader = new URIClassLoader(null);
		URIClassHeperImpl uriClassHeperImpl = new URIClassHeperImpl(null);
	}
}
