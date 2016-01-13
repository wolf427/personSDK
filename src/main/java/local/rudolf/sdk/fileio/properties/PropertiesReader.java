/**
 * Author : Yufei,T
 * Time : 10:25:34 AM
 * Description : This class is used to read properties from preperties file, like xxx.properties.
 */
package local.rudolf.sdk.fileio.properties;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PropertiesReader {
	
	/**
	 * @author : Yufei,T
	 * @Input : file path
	 * @Output : A map which stores values from the target file.
	 */
	public Map<String, String> getPropertiesMap(String filePath){
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			return (Map)props;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(in);
		}
		return null;
	}
	
	/**
	 * @author : Yufei,T
	 * @Description : This method is used to get one certain value from target file.
	 */
	public String readProperties(String filePath, String inputKey) {
		Properties props = new Properties();
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream(filePath));
			props.load(in);
			return props.getProperty(inputKey);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			IOUtils.closeQuietly(in);
		}
		return null;
	}

}

