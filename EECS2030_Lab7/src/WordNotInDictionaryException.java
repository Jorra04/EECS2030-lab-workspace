
public class WordNotInDictionaryException extends Exception {
	WordNotInDictionaryException(){
		super();
	}
	WordNotInDictionaryException(String string){
		super(string);
	}
}
