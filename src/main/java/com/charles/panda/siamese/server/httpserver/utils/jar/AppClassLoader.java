package com.charles.panda.siamese.server.httpserver.utils.jar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class AppClassLoader extends ClassLoader {
	private static Map<String, Class> classes = new HashMap<String, Class>();

	private static AppClassLoader loader;
	
	private String jarName;

	/**
	 * 构造函数
	 * 
	 * @param jarName
	 * @throws Exception
	 */
	private AppClassLoader(String jarName) throws Exception {
		this.jarName = jarName;
		init();
	}

	/**
	 * 生成或取得CustomClassLoader实例
	 * 
	 * @return
	 */
	public static synchronized AppClassLoader getInstance(String jarName) {
		if (loader == null)
			try {
				loader = new AppClassLoader(jarName);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				return null;
			}
		return loader;
	}

	private void init() throws Exception {
		JarInputStream jar = new JarInputStream(new FileInputStream(new File(jarName)));
		JarEntry entry;
		while ((entry = jar.getNextJarEntry()) != null) {
			if (entry.getName().toLowerCase().endsWith(".class")) {
				String classname = entry.getName().substring(0, entry.getName().length() - ".class".length())
						.replace('/', '.');
				byte[] data = getResourceData(jar);

				Class clazz = defineClass(classname, data, 0, data.length);
				classes.put(classname, clazz);
			}
		}
	}

	@Override
	public Class findClass(String name) {
		if (classes.get(name) != null) {
			return classes.get(name);
		}
		return null;
	}

	final static private byte[] getResourceData(JarInputStream jar) throws IOException {
		ByteArrayOutputStream data = new ByteArrayOutputStream();
		byte[] buffer = new byte[8192];
		int size;
		while (jar.available() > 0) {
			size = jar.read(buffer);
			if (size > 0) {
				data.write(buffer, 0, size);
			}
		}
		byte[] val = data.toByteArray();
		data.close();
		return val;
	}
}