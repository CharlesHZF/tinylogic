package com.importsource.tinylogic.server.httpserver.utils.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.importsource.log.core.Logger;
import com.importsource.tinylogic.log.LogManager;
import com.importsource.tinylogic.server.httpserver.Context;
/**
 * 与文件操作相关的工具
 * @author Hezf
 *
 */
public class FileUtils {
	protected static Logger logger = LogManager.getLogger(FileUtils.class);
	/**
	 * 得到某个目录下的所有的文件名
	 * @param dir 指定目录
	 * @return 文件名集合
	 */
	public  static List<String> getFileName(String dir) {
		File f = new File(dir);
		List<String> lst = new ArrayList<String>();
		if (!f.exists()) {
			System.out.println(dir + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (!fs.isDirectory()) {
				lst.add(fs.getName());
			}

		}
		return lst;
	}
	
	/**
	 * 得到某个目录下的所有的jar的文件名
	 * @param dir 指定目录
	 * @return 文件名集合
	 */
	public  static List<String> getJarFileName(String dir) {
		File f = new File(dir);
		List<String> lst = new ArrayList<String>();
		if (!f.exists()) {
			logger.i(dir + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			logger.i("app lib "+(i+1)+":"+fs.getName());
			if (!fs.isDirectory() && fs.getName().endsWith(".jar")) {
				lst.add(fs.getName());
			}

		}
		return lst;
	}
	
	/**
	 * 得到某个目录下的指定扩展名的文件名
	 * @param dir 指定目录
	 * @param extension 扩展名
	 * @return 文件名集合
	 */
	public  static List<String> getJarFileName(String dir,String extension) {
		File f = new File(dir);
		List<String> lst = new ArrayList<String>();
		if (!f.exists()) {
			System.out.println(dir + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (!fs.isDirectory() && f.getName().endsWith("."+extension)) {
				lst.add(fs.getName());
			}

		}
		return lst;
	}
	
	/**
	 * 得到某个目录下的所有的文件路径
	 * @param dir 指定目录
	 * @return 文件名集合
	 */
	public  static List<String> getFilePaths(String dir) {
		File f = new File(dir);
		List<String> lst = new ArrayList<String>();
		if (!f.exists()) {
			System.out.println(dir + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (!fs.isDirectory()) {
				lst.add(fs.getAbsolutePath());
			}

		}
		return lst;
	}
	
	/**
	 * 得到某个目录下的所有的jar的文件路径集合
	 * @param dir 指定目录
	 * @return 文件名集合
	 */
	public  static List<String> getJarFilePaths(String dir) {
		File f = new File(dir);
		List<String> lst = new ArrayList<String>();
		if (!f.exists()) {
			logger.i(dir + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			logger.i("app lib "+(i+1)+":"+fs.getName());
			if (!fs.isDirectory() && fs.getName().endsWith(".jar")) {
				lst.add(fs.getAbsolutePath());
			}

		}
		return lst;
	}
	
	/**
	 * 得到某个目录下的指定扩展名的文件路径集合
	 * @param dir 指定目录
	 * @param extension 扩展名
	 * @return 文件名集合
	 */
	public  static List<String> getFilePaths(String dir,String extension) {
		File f = new File(dir);
		List<String> lst = new ArrayList<String>();
		if (!f.exists()) {
			System.out.println(dir + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (!fs.isDirectory() && f.getName().endsWith("."+extension)) {
				lst.add(fs.getAbsolutePath());
			}

		}
		return lst;
	}
}
