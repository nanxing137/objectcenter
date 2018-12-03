package springhelper.objectcenter;

import java.lang.reflect.Method;

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
