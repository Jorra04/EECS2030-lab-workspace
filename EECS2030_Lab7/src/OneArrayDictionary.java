/*
 * You are required to use the given `dict` array to implement the methods.
 * See test_one_array_implementation_insert and test_one_array_implementation_remove 
 * in class TestArrayImplementations.
 *
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that `dict` is initialized as an array of size `MAX_CAPACITY` with each slot storing null.
 * Entries are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * {(w1, d1), (w2, d2), (w3, d3), (w4, d4), null, null, ...} 
 * Removing the entry for word `w2` has the resulting dictionary:
 * {(w1, d1), (w3, d3), (w4, d4), null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class OneArrayDictionary implements Dictionary {

	int MAX_CAPACITY = 100;
	int count = 0;
	WordDefinitionPair[] dict;

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */

	OneArrayDictionary() {
		this.dict = new WordDefinitionPair[MAX_CAPACITY];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		return this.count == 0;
	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub

		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) {
				return this.dict[i].getDefinition();
			}
		}
//		for(WordDefinitionPair w : this.dict) { cant get advanced for loop to work..
//			if(w.getWord() == word) {
//				return w.getDefinition();
//			}
//		}

		throw new WordNotInDictionaryException();

	}

	@Override
	public void insertEntry(String word, String definition) throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		// TODO Auto-generated method stub
		
		if (this.count == MAX_CAPACITY - 1) {
			throw new DictionaryFullException();
		}

		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) {
				throw new WordAlreadyExistsInDictionaryException();
			}
		}

		this.dict[count] = new WordDefinitionPair(word, definition);
		count++;

	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		// TODO Auto-generated method stub
		boolean wordFound = false;
		int iOfDef = 0;
		String tempStore;

		if (count == 0) {
			throw new WordNotInDictionaryException();
		}

		for (int i = 0; i < this.count; i++) {
			if (this.dict[i].getWord().equals(word)) { // should always use .equals to compare strings
				wordFound = true;
				iOfDef = i;
			}
		}

		if (wordFound) {
			tempStore = this.dict[iOfDef].getDefinition();

			// this should move everything starting at index iOfDef
			// to the length of this.words.length
			for (int i = iOfDef; i < this.dict.length - 1; i++) {
				this.dict[i] = this.dict[i + 1];
			}

			this.count--; // since word removed change size
			return tempStore;

		} else {
			throw new WordNotInDictionaryException();
		}

	}

	@Override
	public String[] getWords() {
		// TODO Auto-generated method stub
//		int index = 0;
		String[] result = new String[this.count];

		for (int i = 0; i < this.count; i++) {
			result[i] = this.dict[i].getWord();
		}
		
//		for(WordDefinitionPair w : this.dict) {	again, advanced for loop wont work..
//			returnMe[index] = w.getWord();
//			index++;
//		}

		return result;
	}

	@Override
	public String[] getDefinitions() {

		String[] result = new String[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = this.dict[i].getDefinition();
		}

		
		
		
		return result;
	}

	@Override
	public WordDefinitionPair[] getEntries() {

		WordDefinitionPair[] result = new WordDefinitionPair[this.count];
		for (int i = 0; i < this.count; i++) {
			result[i] = this.dict[i];
		}
		return result;
	}

}