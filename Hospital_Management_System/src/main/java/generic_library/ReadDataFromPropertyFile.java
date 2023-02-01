package generic_library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static String fromPropertyFile(String key){
		Properties pr = null;
		FileInputStream fis;
		try {
			fis=new FileInputStream(new File("./src/test/resources/testData/testcase.properties"));
			pr=new Properties();
			pr.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pr.getProperty(key).toString();
	}

}
