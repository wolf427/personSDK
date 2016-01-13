/**
 * Author : Yufei,T
 * Time : 11:28:29 AM
 * Description :
 */
package local.rudolf.sdk.fileio.xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class StudentsXmlConvert extends XMLReader {
	public StudentsXmlConvert() {
		super();
	}

	public List<Student> convertXmlToList() {
		List<Student> students = new ArrayList<Student>();
		try {
			Document doc = loadDocument(System.getProperty("user.dir")
					+ "\\src\\test\\resources\\local\\rudolf\\sdk\\fileio\\students.xml");
			//The node path is the set we want to get.Like below.
			NodeList nodeList = getNodeListFromDoc(doc,
					"//department/class/students/student");
			for(int i=0;i<nodeList.getLength();i++){
				NodeList studentInfo = nodeList.item(i).getChildNodes();
				/*
				*If you want to get attributes value use this method
				*NamedNodeMap nameNodeMap = nodeList.item(i).getAttributes();
				*/
				Student student = new Student();
				
				for(int j = 0 ;j<studentInfo.getLength();j++){
					Node eachInfo = studentInfo.item(j);
					if("#text".equals(eachInfo.getNodeName()))
						continue;
					if("stuname".equals(eachInfo.getNodeName()))
						student.setName(eachInfo.getTextContent());//getTextContent() is right ,not getvalue()
					if("age".equals(eachInfo.getNodeName()))
						student.setAge(Integer.parseInt(eachInfo.getTextContent()));
				}
				students.add(student);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return students;
		
	}
	
	
}
