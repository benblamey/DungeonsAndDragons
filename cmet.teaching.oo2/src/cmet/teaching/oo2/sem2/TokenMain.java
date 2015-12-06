package cmet.teaching.oo2.sem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TokenMain {
	
	public static void main (String args[]) throws IOException {
		
		// http://stackoverflow.com/questions/4716503/best-way-to-read-a-text-file
	    BufferedReader br = new BufferedReader(new FileReader("file.txt"));
	    try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append('\n');
	            line = br.readLine();
	        }
	        String ever0ything = sb.toString();
	    } finally {
	        br.close();
	    }
		
	    
	    
//		// Initialize the WordNet Dictionary.
//        String propsFile = "C:\\work\\code\\Teaching\\OO2\\cmet.teaching.oo2\\res\\file_properties.xml";
//        Dictionary dictionary = Dictionary.getInstance(new FileInputStream(propsFile));
//        
//        // Look up the synset for a word.
//		String token = "table";
//        IndexWord word = dictionary.getIndexWord(POS.NOUN, token);
//        for (Synset synset : word.getSenses()) {
//        	System.out.println(token + " = " + synset.getGloss());
//        }
        
        
	}

}
