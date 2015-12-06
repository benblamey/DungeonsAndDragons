package cmet.teaching.oo2.sem2;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.StreamHandler;

import javax.xml.xpath.XPathConstants;

import net.sf.extjwnl.data.POS;

import org.w3c.dom.Node;

/*
 * fdgdf gdf gdf gdf gdf gf d
 */
public class Lookup {

	/*
	 * nbvnmbv fg ddf g dffg dfg
	 */
	private static Map<POS, String> map = new HashMap<POS, String>() {{
		put(POS.ADJECTIVE, "a");
	}};
	
	public static void main(String[] args) {
		Lookup lookup = new Lookup();
		// noun, expecting categ = jollity.
		lookup.lookupByOffset(5614225L, POS.ADVERB);
		
		map.get(POS.ADJECTIVE);
		
		
	}

	private static void foo(int i) {
		// TODO Auto-generated method stub
		
	}

	public void lookupByOffset(long l, POS pos) {
		boolean isNoun = (pos == POS.NOUN);
		Long nounOffset;
		if (isNoun ) {
			nounOffset = l;
		} else {
			// Lookup the noun offset.
			String prefix;
			switch (pos) {
			case ADJECTIVE: 
				prefix = "a";
				break;
			case ADVERB:
				prefix = "r";
				break;
				
			default: 
				throw new RuntimeException("unsupported enum value.");
			}
			// I can run a query to select a single node by doing this, for example: 
			// Look up the the sense of joy (noun) - offset 05596218.
			String synset_string = String.format("%08d", synset_offset);;
			Node theNode = (Node) xpath.evaluate(
					"//*[@id='"+prefix+"#"+synset_string+"']", 
					document, XPathConstants.NODE);
			String nodeValue = theNode.getAttributes().getNamedItem("noun-id").getNodeValue();
			
			
			
			System.out.println("Offset 05596218 has category " + categ);

			
		}
		
		
	}

}
