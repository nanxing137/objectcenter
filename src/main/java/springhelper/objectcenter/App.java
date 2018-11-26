package springhelper.objectcenter;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import springhelper.objectcenter.classHelper.URIClassHeperImpl;
import springhelper.objectcenter.classloader.URIClassLoader;

/**
 * Hello world!
 *
 */
public class App {
	
	public String name() {
		return "s";
	}
	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
//		System.out.println("Hello World!");
//		Method method;
//		URIClassLoader classLoader = new URIClassLoader(null);
//		URIClassHeperImpl uriClassHeperImpl = new URIClassHeperImpl(null);
		
		Method declaredMethod = App.class.getDeclaredMethod("name");
		System.out.println(declaredMethod.getDefaultValue());
	}
}
