package cmet.teaching.oo2.sem2;

public class LookupResult

/*
 * Compiler has written this for us as well!
 */
extends Object

{

	static() {
		
	}
	
	/*
	 * Compiler has made this for me!
	 */
	public LookupResult() throws SomeException {
		offset = SomeClass.someStaticMethod();
	}
	
	
//compiler has moved this code \/	
	Long offset // = SomeClass.someStaticMethod(); 
	POS pos;
}
