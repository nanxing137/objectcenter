package springhelper.objectcenter;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
<<<<<<< HEAD
=======
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;


import springhelper.objectcenter.classHelper.URIClassHeperImpl;
import springhelper.objectcenter.classloader.URIClassLoader;
>>>>>>> c2628cf1f30b66ba7527d4a44c830f7bbea2e664

/**
 * Hello world!
 *
 */
public class App {
	
	public String name() {
		return "s";
	}

	
	@SuppressWarnings({ "unused", "rawtypes", "unchecked", "resource" })
	public static void main(String[] args)
			throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
//		System.out.println("Hello World!");
//		Method method;
//		URIClassLoader classLoader = new URIClassLoader(null);
//		URIClassHeperImpl uriClassHeperImpl = new URIClassHeperImpl(null);

//		Method declaredMethod = App.class.getDeclaredMethod("name");
//		System.out.println(declaredMethod.getDefaultValue());
//		Lookup lookup = MethodHandles.lookup();
//		MethodHandle findGetter = lookup.findGetter(null, null, null);
//
		var s = "s";
		var temp = new App();
		
		var urlClassLoader = new URLClassLoader(null);
		Class<?> loadClass = urlClassLoader.loadClass(null);
		ExecutorService executorService = null;
		executorService.execute(null);
		executorService.submit(null,null);
		
		
		var s1 = new String("hh");
		var s2 = new String("hh");
		System.out.println(s1==s2);
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		
	}
}
