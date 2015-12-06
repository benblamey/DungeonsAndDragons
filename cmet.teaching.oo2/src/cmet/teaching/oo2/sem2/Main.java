package cmet.teaching.oo2.sem2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.Synset;
import net.sf.extjwnl.dictionary.Dictionary;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

public class Main {


	public static void main(String[] args) throws IOException, JWNLException {
		
		
		
		
		Scanner scr = new Scanner(new File("C:/foo.txt"));
		
		
		String input = scr.next();
		
		scr.close();
		
		
		
		
		String s = new String();
		s.getClass().getName();
		
		if (s instanceof String) {
			System.out.println("s is a String");
		}
		
		List<String> affect_lines = SecretCode.slurpAffect();
		
		
InputStream is = new FileInputStream("C:/work/code/Teaching/OO2/cmet.teaching.oo2/res/en-token.bin");
TokenizerModel model = new TokenizerModel(is);
Tokenizer tokenizer = new TokenizerME(model);

// Initialize the WordNet Dictionary.
String propsFile = "C:\\work\\code\\Teaching\\OO2\\cmet.teaching.oo2\\res\\file_properties.xml";
    Dictionary dictionary = Dictionary.getInstance(new FileInputStream(propsFile));
    
Lookup lookup = new Lookup();  
	
	   BufferedReader br = new BufferedReader(new FileReader(
			   "C:/work/code/Teaching/OO2/cmet.teaching.oo2/res/review1.txt"));

    StringBuilder sb = new StringBuilder();
    String line = br.readLine();

    while (line != null) {
		String tokens[] = tokenizer.tokenize(line);
		for (String token : tokens) {
	       for (POS pos : POS.getAllPOS()) {

	            IndexWord word = dictionary.getIndexWord(pos, token);
	            if (word != null) {
	            	
	            	List<Synset> senses = word.getSenses();
	            	
	                for (Synset synset : senses) {

	                		long offset = synset.getOffset();
	                        
lookup.lookupByOffset(offset, pos);
	                }
	            }
	       }

		}
			
		
        sb.append(line);
        sb.append('\n');
        line = br.readLine();
    }
    String everything = sb.toString();


is.close();
	}



}
