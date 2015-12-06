package cmet.teaching.oo2.sem2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.sf.extjwnl.data.Synset;

public class SecretCode {
	
	public static List<String> slurpAffect() throws IOException {
		
		ArrayList<String> lines = new ArrayList<>();
		
		//StringBuilder sb = new StringBuilder();
	    BufferedReader br = new BufferedReader(new FileReader(
	    		//"C:/work/code/Teaching/OO2/wn-domains-3.2/wn-affect-1.0/wn-affect-labels-1.0.txt"
	    		//"C:/work/code/Teaching/OO2/wn-domains-3.2/wn-affect-1.1/a-synsets.xml"
	    		//"C:\\work\\code\\Teaching\\OO2\\wn-domains-3.2\\wn-affect-1.0\\wn-affect-legenda-1.0.txt"
	    		"C:\\work\\code\\Teaching\\OO2\\wn-domains-3.2\\wn-affect-1.1\\a-synsets.xml"
	    		));
	    try {
	        
	        String line = br.readLine();

	        while (line != null) {
	            //sb.append(line);
	            //sb.append('\n');
	        	lines.add(line);
	            line = br.readLine();
	            
	        }
	        //String everything = sb.toString();
	    } finally {
	        br.close();
	    }
		return lines;
	    
	}
	
	
	public static void debug(List<String> affect_lines, String token,
			Synset synset) {
		Long offset = synset.getOffset();
		
		String toSearch = "#"+String.format("%08d", offset);
		
		for (String affect_line : affect_lines) {
			if (affect_line.contains(toSearch)) {

		    	
		    	System.out.println(token + " - ");
				
		        System.out.println(
		        		"    - " + synset.getType().toString()
		        		+ " - " + offset 
		        		+ " - "  + synset.getWords().get(0).getLemma()	
		        		 + " - " + affect_line);
		    }	
		}
	}

}
