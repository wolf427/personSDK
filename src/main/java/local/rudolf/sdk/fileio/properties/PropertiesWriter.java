/**
 * Author : Yufei,T
 * Time : 11:09:39 AM
 * Description :
 */
package local.rudolf.sdk.fileio.properties;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Map.Entry;


public class PropertiesWriter {
	
	public static void writeProperties(String path,Map<String,String> properties){
		try {
			PrintStream Stream = new PrintStream(new FileOutputStream(path, false));
			
			for(Entry entry:properties.entrySet()){
				Stream.println(entry.getKey()+"="+entry.getValue());
			}
			Stream.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}

