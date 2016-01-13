/**
 * Author : Yufei,T
 * Time : 3:09:34 PM
 * Description :
 */
package local.rudolf.sdk.fileio.xml;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
	private Document Doc = null;
	
	public Document loadDocument(String filePath) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory DomFactory = DocumentBuilderFactory.newInstance();
		DomFactory.setNamespaceAware(true);
		
		DocumentBuilder Builder = DomFactory.newDocumentBuilder();
		Doc = Builder.parse(filePath);
		return Doc;
	}
	
	public NodeList getNodeListFromDoc(Document Doc,String nodePath) throws XPathExpressionException {
		XPathFactory Factory = XPathFactory.newInstance();
		XPath XPath = Factory.newXPath();
		NodeList Nodes = null;
		Nodes = (NodeList) XPath.evaluate(nodePath, Doc, XPathConstants.NODESET);
		return Nodes;
	}
	
}

