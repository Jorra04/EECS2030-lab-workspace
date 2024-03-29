package eecs2030.lab4;

import java.util.*;

/**
 * Dictionary for Lempel-Ziv-Welch algorithm. This is a basic implementation
 * that trades memory for simplicity: A map of dictionary entries (strings) to
 * dictionary indices is stored in parallel with a list of dictionary entries
 * (i.e., entries are stored in two separate data structures to simplify their
 * recall when encoding and decoding).
 * 
 * 
 * <p>
 * The dictionary is initialized by providing a string, from which a set of
 * unique characters will be extracted and used as initial dictionary entries.
 * </p>
 * 
 * <p>
 * For example, if the dictionary is initialized with the string
 * <code>"ababa!*bbac*&c"</code>, it will be initialized with single character
 * strings: <code>["a","b","!","*","c","&"]</code>, which each have
 * corresponding indices: <code>[0, 1, 2, 3, 4, 5]</code>. So for this example,
 * the dictionary would map <code>'a'</code> to index 0, <code>'b'</code> to
 * index 1, ..., <code>'*'</code> to index 3, and so on. The index associated
 * with each entry in the map relates directly to the position of that entry as
 * it is stored in the list.
 * </p>
 * 
 * <p>
 * The map provides a quick and easy way to check for the existence of entries
 * in the dictionary, while the list provides an easy way to retrieve an entry
 * via its index value
 * </p>
 * 
 * @author eecs2030
 *
 */

public class LZWDictionary {

	// FIELDS
	// map (for ease of checking existence of entries)
	// list (ease of recall of an entry)
	String input;
	List<String> list = new ArrayList<>();
	Map<String, Integer> map = new HashMap<>();

	/**
	 * Initializes the LZWDictionary to have an initial set of entries taken from
	 * the set of unique characters in a provided string
	 * 
	 * 
	 * <p>
	 * Unique characters are added to a map as they are encountered in the provided
	 * input string, with an increasing index value (beginning at index 0). At the
	 * same time, the characters are added to a list. The indices associated with
	 * each dictionary entry in the map thus relate to their index (position) in the
	 * list
	 * </p>
	 * 
	 * 
	 * 
	 * @param characters a string of initial characters that may include duplicates
	 * 
	 * @throws an IllegalArgumentException if the characters string is empty
	 * 
	 */
	public LZWDictionary(String characters) {

		// NOTE: Complete the accessors getMap() and getList() first before running
		// your tester on this ctor
		if (characters.isEmpty()) {
			throw new IllegalArgumentException();
		}

		this.input = characters;
		String tempStr;

		for (int i = 0; i < characters.length(); i++) {
			tempStr = "" + characters.charAt(i);
			if (list.isEmpty() || !list.contains(tempStr)) {
				list.add(tempStr);
				map.put(list.get(list.size() - 1), list.size() - 1);
			}
		}
	}

	/**
	 * Returns a reference to a map of entry-index pairs currently stored in the
	 * LZWDictionary
	 * 
	 * 
	 * @return a reference to a map of entry-index pairs in the dictionary
	 */
	public Map<String, Integer> getMap() {

		return map;

	}

	/**
	 * Returns a reference to a list of entries currently stored in the
	 * LZWDictionary
	 * 
	 * 
	 * @return a reference to a list of entries in the dictionary
	 */
	public List<String> getList() {

		return list;

	}

	/**
	 * Returns the index associated with an entry in the dictionary
	 * 
	 * 
	 * @param s a string representing an entry (character pattern) to find in the
	 *          dictionary
	 * 
	 * @return an integer representing the index of the entry if found in the
	 *         dictionary, or a value of -1 if the entry is not found
	 * 
	 */
	public int indexOf(String s) {

		return list.indexOf(s);

	}

	/**
	 * Resets the dictionary to its initial state
	 * 
	 *
	 * <p>
	 * The initial state of the dictionary is with only the original, single
	 * character entries that the dictionary was initialized with when created. This
	 * method should essentially remove all entries in the dictionary that have more
	 * than one character
	 * </p>
	 * 
	 * 
	 */
	public void reset() {

		String tempStr;
		this.list.clear();
		this.map.clear();

		for (int i = 0; i < this.input.length(); i++) {
			tempStr = "" + this.input.charAt(i);
			if (this.list.isEmpty() || !this.list.contains(tempStr)) {
				this.list.add(tempStr);
				this.map.put(this.list.get(this.list.size() - 1), this.list.size() - 1);
			}
		}

	}

	/**
	 * Returns the dictionary entry located at the specified index.
	 * 
	 * @param index the index of the entry
	 * @return the dictionary entry located at the specified index
	 * 
	 * @throws an IndexOutOfBoundsException if the provided index is not within the
	 *            valid range of entry indices currently stored in the dictionary
	 * 
	 */
	public String get(int index) {

		if (list.size() < index) {
			throw new IndexOutOfBoundsException();
		} else {
			return list.get(index);
		}

	}

	/**
	 * Returns true if the specified index is valid for this dictionary, false
	 * otherwise.
	 * 
	 * @param index an index
	 * @return true if the specified index is valid for this dictionary, false
	 *         otherwise
	 */
	public boolean hasIndex(int index) {

		if (list.size() <= index || index < 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Adds a new entry to this dictionary. The dictionary is not modified if the
	 * specified entry is already in this dictionary.
	 * 
	 * @param entry the new entry to add to this dictionary
	 * @return the index of the newly added entry, or the index of the entry if it
	 *         is already in this dictionary
	 */
	public int add(String entry) {

		if (!list.contains(entry)) {
			list.add(entry);
			map.put(list.get(list.size() - 1), list.size() - 1);
			return list.size() - 1;
		} else {
			return list.indexOf(entry);
		}
	}

	/**
	 * Returns {@code true} if the specified string is in this dictionary, and false
	 * otherwise.
	 * 
	 * @param s a string representing an entry to look for in the dictionary
	 * @return {@code true} if the specified string is in this dictionary, and false
	 *         otherwise
	 */
	public boolean contains(String s) {

		if (list.contains(s)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the current size of the dictionary
	 * 
	 * 
	 * <p>
	 * The size of the dictionary is the number of entries it is currently holding.
	 * </p>
	 * 
	 * @return an integer representing the number of entries currently in the
	 *         dictionary, or -1 if the dictionary has no entries
	 */
	public int size() {

		if (list.isEmpty()) {
			return -1;
		} else {
			return list.size();
		}

	}

	/**
	 * Returns a string representation of this dictionary. The string representation
	 * is identical to the string representation of an {@code AbstractMap} with the
	 * map entries maintained in insertion order.
	 * 
	 * @return a string representation of this dictionary
	 */
	@Override
	public String toString() {

		String returnStr = "{";

		for (int i = 0; i < list.size(); i++) {
			returnStr += list.get(i) + "=" + i;
			if (i < list.size() - 1) {
				returnStr += ", ";
			}
		}

		returnStr += "}";
		return returnStr;

	}

}
