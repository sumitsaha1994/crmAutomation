package com.freecrm.fameworkUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader extends Util{
	public static Properties prop;
	
	static {
		try {
			FileInputStream fis = new FileInputStream(Util.configLoaderFilePath);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
