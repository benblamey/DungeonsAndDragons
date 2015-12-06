package cmet.teaching.oo2.sem2;

import java.io.FileInputStream;
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

public class ParseMain {

	public static void main(String[] args) throws XPathExpressionException,
			ParserConfigurationException, SAXException, IOException {

		// We use a factory for the factory!
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();

		Document document = builder.parse(new FileInputStream("C:/work/code/Teaching/OO2/wn-domains-3.2/wn-affect-1.1/a-synsets.xml"));

		// And again!
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();

		Long synset_offset = 5596218L; // (assuming this is noun POS)
		
		
		
		Lookup.lookupByOffset(synset_offset);
		// This will give us "05596218"
		
				
		// Next: Look up the category in the other XML file...
		
		// What about the case when the POS is not a noun?
		
		
		// Also, I can run a query that returns a set of nodes by doing something like this:
		NodeList adjectiveSynsets = (NodeList) 
				xpath.evaluate("/syn-list/adj-syn-list/adj-syn", document, XPathConstants.NODESET);
		System.out.println("Found " + adjectiveSynsets.getLength() + " elements.");

		for (int i = 0; i < adjectiveSynsets.getLength(); i++) {
			Node item = adjectiveSynsets.item(i);
			System.out.println("The corresponding noun-id is: " + item.getAttributes().getNamedItem("noun-id").getNodeValue());
		}

	}

}
