package springhelper.objectcenter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import springhelper.objectcenter.classHelper.URIClassHelper;
import springhelper.objectcenter.classHelper.URIClassHeperImpl;
import springhelper.objectcenter.classgenter.ClassLoaderHelper;
import springhelper.objectcenter.classloader.URIClassLoader;
import springhelper.objectcenter.objecthelper.CloudObject;

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
			throws NoSuchMethodException, SecurityException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, IOException, IllegalArgumentException, InvocationTargetException {
//		System.out.println("Hello World!");
//		Method method;
//		URIClassLoader classLoader = new URIClassLoader(null);
//		URIClassHeperImpl uriClassHeperImpl = new URIClassHeperImpl(null);

//		Method declaredMethod = App.class.getDeclaredMethod("name");
//		System.out.println(declaredMethod.getDefaultValue());
//		Lookup lookup = MethodHandles.lookup();
//		MethodHandle findGetter = lookup.findGetter(null, null, null);
//
		String string = "C:\\Users\\Thornhill\\Desktop\\temp\\C1.class";
		Path path = Paths.get(string);
		BufferedReader newBufferedReader = Files.newBufferedReader(path);
		InputStream newInputStream = Files.newInputStream(path);
		byte[] readAllBytes = newInputStream.readAllBytes();
		
		URIClassHelper<Object> uriClassHelper = ClassLoaderHelper.get("C1", readAllBytes);
		CloudObject<Object> cloudObject = uriClassHelper.get();
		
		
	}
}
