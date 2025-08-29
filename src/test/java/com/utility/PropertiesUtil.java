package com.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Environment;

public class PropertiesUtil {
	//read properties file
	public static String readProperty(Environment env,String propertyName)
	{
		File propFile=new File(System.getProperty("user.dir")+"\\config\\QA.properties");
		FileReader fileReader = null;
		try {
		fileReader=new FileReader(propFile);}
		catch(Exception e) {
			e.printStackTrace();
			}
		Properties properties=new Properties();
		try {
			properties.load(fileReader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String value=properties.getProperty(propertyName);
		return value;

	}

}
