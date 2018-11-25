package springhelper.objectcenter.classloader;

public class URIClassLoader extends ClassLoader {
	private byte[] classData;// class文件的URL

	public URIClassLoader(byte[] data) {
		super();
		this.classData = data;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// byte[] classData = getClassDataFromNet(name);
		if (classData == null) {
			throw new ClassNotFoundException();
		} else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	/**
	 * 从各种地方获取class文件</br>
	 * 目前先留着</br>
	 * 后期可能与URIHelper整合使用</br>
	 * 
	 * @param className
	 * @return
	 */
	private byte[] getClassDataFromNet(String className) {
		return null;
	}

}
