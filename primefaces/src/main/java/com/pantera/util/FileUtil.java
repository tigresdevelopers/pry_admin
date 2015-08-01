package com.pantera.util;

import java.util.ResourceBundle;

public class FileUtil {
	
	public static String loadBundle(String path,String key) throws Exception{
		return 	ResourceBundle.getBundle(path).getString(key);
	}
	
	public static String loadBundleLink(String key) throws Exception{
		return 	ResourceBundle.getBundle("properties/links/navigationLinks").getString(key);
	}

}
