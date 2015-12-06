package cmet.teaching.oo2.sem2;



public class Pipeline {

	
	public static void main(String[] args)  {
		
		String fileName = "foo.txt"
		FileReader fr = new FileReader(fileName);
		List<String> lines = fr.readLines(); 
		
		Tokenizer tokenizer = new Tokenizer();
		List<String> tokens = tokenization.tokenize(lines);
		
		WordNetLookup wnl = new WordNetLookup();
		WordNetAffectLookup wnal = new WordNetAffectLookup();
		EmotionScore emotionScore = new EmotionScore();
		foreach (String token : tokens) {
		
			List<LookupResult> lookupResults = wnl.lookup(token);
			foreach (LookupResult lr : lookupResults) {
				EmotionLevel el = wnal.lookup(lr);
				emotionScore.addScore(el);
			}
		}
		
		emotionScore.printResults();
	}
}
