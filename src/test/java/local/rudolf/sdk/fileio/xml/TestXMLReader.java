/**
 * Author : Yufei,T
 * Time : 11:22:55 AM
 * Description :
 */
package local.rudolf.sdk.fileio.xml;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestXMLReader {
	XMLReader xmlReader = null;
	@Before
	public void setUp(){
		xmlReader = new StudentsXmlConvert();
	}
	
	@Test
	public void testXmlReader(){
		List<Student> students = ((StudentsXmlConvert)xmlReader).convertXmlToList();
		Assert.assertEquals("student1 name","rudolf", students.get(0).getName());
		Assert.assertEquals("student1 age",new Integer(22), students.get(0).getAge());
		Assert.assertEquals("student2 name","wolf", students.get(1).getName());
		Assert.assertEquals("student2 age",new Integer(18), students.get(1).getAge());
	}

}

