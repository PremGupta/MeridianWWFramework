package com.resources.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	public static Properties prop;
	
	public static void getProp() {
		prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./data.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getValue(String pname ) {
		if (prop ==  null) 
			 Config.getProp();
		return prop.getProperty(pname);
	}
}
