/**
 * Author : Yufei,T
 * Time : 10:47:28 AM
 * Description :
 */
package local.rudolf.sdk.fileio.properties;

import java.util.Map;

import local.rudolf.sdk.fileio.properties.PropertiesReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPropertiesReader {

	private PropertiesReader propertiesReader;

	@Before
	public void setUp() {
		propertiesReader = new PropertiesReader();
	}

	@Test
	public void testPropertiesMap() {
		Map<String, String> propertiesMap = propertiesReader
				.getPropertiesMap(System.getProperty("user.dir")
						+ "/src/test/resources/local/rudolf/sdk/fileio/someproperties.properties");
		Assert.assertEquals("JAVA_HOME get wrong answer",
				"C:\\Program Files (x86)\\Java\\jdk1.8.0_31",
				propertiesMap.get("JAVA_HOME"));
		Assert.assertEquals("engine get wrong answer", "abbyy",
				propertiesMap.get("engine"));
		Assert.assertEquals("phone get wrong answer", "mi4",
				propertiesMap.get("phone"));
		Assert.assertEquals("tel get wrong answer", "15200008516",
				propertiesMap.get("tel"));
		Assert.assertEquals("isNull get wrong answer", "null",
				propertiesMap.get("isNull"));
		Assert.assertTrue("truePro get wrong answer",
				Boolean.parseBoolean(propertiesMap.get("truePro")));
		Assert.assertFalse("falsePro get wrong answer",
				Boolean.parseBoolean(propertiesMap.get("falsePro")));
	}

	/**
	 * @author : Yufei,T
	 * @Description : Even though we open file every times , 10000 times read only cost 1.565s. So it's efficient.
	 */
	@Test
	public void testCertainProperties() {
		for (int i = 0; i < 10000; i++)
			Assert.assertEquals("phone get wrong answer","mi4",
					propertiesReader.readProperties(
							System.getProperty("user.dir")
									+ "/src/test/resources/local/rudolf/sdk/fileio/someproperties.properties",
							"phone"));
	}
}
