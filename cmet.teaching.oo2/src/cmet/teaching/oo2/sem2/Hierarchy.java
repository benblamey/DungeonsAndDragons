package cmet.teaching.oo2.sem2;

public class Hierarchy {

	public EmotionLevel lookupInHierarchy(String categ) {
		
		while (true)  {
			
			if (categ== null) {
				throw new RuntimeException("off the top!!!");
			} else if (categ.equals("root")) {
				return EmotionLevel.Neutral;
			}  else if (categ.equals("postive-emotion")) {
				return EmotionLevel.Pos;
			} // same again for negative
			
			// got to here, means that we need to keep going up!
			
			categ = getParentCateg(categ);
		}
	}

	private String getParentCateg(String categ) {
		String categ;
		
		
		
		return categ;
		// Do XPath nonsense.
		// Return null if not found.
	}
}
