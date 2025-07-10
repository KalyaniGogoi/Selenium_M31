package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {
	
	/**
	 * This method is used to read data from properties file(external resource)
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getKeyAndValue(String key) throws Throwable 
	{
		// Step1:- connnect the physical file path
		FileInputStream fis= new FileInputStream("./src/test/resources/commondata.properties.txt");

		// step2:- Create the object of Properties class and load all the Keys
		Properties pro = new Properties();
		pro.load(fis);

		// step3:-read the value using getProperty()
		String value = pro.getProperty(key);
		return value;
		
	}

}
