/* Make sure the instructions document is read carefully.
 * 
 * You are required to use the given `words` and `definitions` arrays to implement the methods.
 * See test_two_array_implementation_insert and test_two_array_implementation_remove 
 * in class TestArrayImplementations.
 * 
 * Requirements:
 * 		- You are not allowed to add new attributes to this class.
 * 		- You are not allowed to use any Java collection library (no import statements).
 * 
 * The idea is that both `words` and `definitions` are initialized as arrays of size `MAX_CAPACITY` with each slot storing null.
 * Entries (words and definitions) are added from left to right, whereas all free slots remain null.
 * When an entry is removed, all slots to its right are shifted to the left to close the gap.
 * 
 * For example, given a dictionary with four entries:
 * words:       {w1, w2, w3, w4, null, null, ...}
 * definitions: {d1, d2, d3, d4, null, null, ...}
 * Removing the entry for word `w2` has the resulting dictionary:
 * words:       {w1, w3, w4, null, null, null, ...}
 * definitions: {d1, d3, d4, null, null, null, ...}
 * 
 * You may consider studying this note on manipulating basic array:
 * https://www.eecs.yorku.ca/~jackie/teaching/lectures/2019/F/EECS2030/notes/EECS2030_F19_Notes_Tracing_PointCollectorTester.pdf
 */

public class TwoArrayDictionary implements Dictionary {

	/*
	 * Use these attributes only to implement the methods.
	 */
	int MAX_CAPACITY = 100;
	int count = 0; // number of entries in dictionary

	String[] words;
	String[] def;

	/*
	 * Your tasks: declare and implement methods from the Dictionary interface.
	 */

	TwoArrayDictionary() {
		this.words = new String[MAX_CAPACITY];
		this.def = new String[MAX_CAPACITY];
	}

	@Override
	public int size() {
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		return this.count == 0;

	}

	@Override
	public String getDefinition(String word) throws WordNotInDictionaryException {
		if (this.isEmpty()) {
			throw new WordNotInDictionaryException();
		}

		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				return this.def[i];
			}
		}
		throw new WordNotInDictionaryException();
	}

	@Override
	public void insertEntry(String word, String definition)
			throws WordAlreadyExistsInDictionaryException, DictionaryFullException {
		// TODO Auto-generated method stub

		if (this.count == MAX_CAPACITY) {
			throw new DictionaryFullException(); // gotta check this first, otherwise it may fail some cases.
		}

		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				throw new WordAlreadyExistsInDictionaryException();
			}
		}
		/*
		 * need to do these outside the loop and if statement, we want them to run for sure.
		 */

		this.words[count] = word;
		this.def[count] = definition;
		this.count++;

	}
	@Override
	public String[] getDefinitions() {

		String[] result = new String[this.count];

		for (int i = 0; i < this.count; i++) {
			result[i] = this.def[i];
		}

		return result;

	}

	@Override
	public String removeWord(String word) throws WordNotInDictionaryException {
		boolean found = false;
		int defIndex = 0;
		String tmp;

		if (count == 0) {
			throw new WordNotInDictionaryException();
		}

		for (int i = 0; i < this.count; i++) {
			if (this.words[i].equals(word)) {
				found = true;
				defIndex = i;
			}
		}

		if (found) {
			tmp = this.def[defIndex];
			for (int i = defIndex; i < this.words.length - 1; i++) {
				this.words[i] = this.words[i + 1];
				this.def[i] = this.def[i + 1];
			}

			this.count--; 
			return tmp;

		} else {
			throw new WordNotInDictionaryException();
		}

	}

	@Override
	public String[] getWords() {
		

		String[] result = new String[this.count];

		for (int i = 0; i < this.count; i++) {
			result[i] = this.words[i];
		}

		return result;

	}

	

	public WordDefinitionPair[] getEntries() {
		WordDefinitionPair[] result = new WordDefinitionPair[this.count];
		for (int i = 0; i < result.length; i++) {
			result[i] = new WordDefinitionPair(this.words[i], this.def[i]);

		}

		return result;
	}

}
