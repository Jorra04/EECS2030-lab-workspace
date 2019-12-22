import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 * You receive a zero if there is any occurrence of a loop (e.g., for, while).  
 * See under doc/index.html for the API of methods.
 * This lab requires definitions of recursive helper methods.
 * You may review the recording of parts of Lecture 14 (October 28):
 * https://youtu.be/J2CB3QHinQU
 */
public class RecursiveMethods {
	/**
	 * Return an array storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticArray(2, 3, 5)
	 * returns an array {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return an array representing the first n numbers in the specified arithmetic
	 *         sequence
	 *
	 *         <b>You are forbidden to use the arithmeticList method below to solve
	 *         this problem.</b>
	 *
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] arithmeticArray(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticArrayHelper.
		 */
		int[] result = new int[n];
		if (n == 0) {
			return new int[0];
		}
		if (n == 1) {
			return new int[] { start };
		}
		result[0] = start;

		arithmeticArrayHelper(1, diff, result);
		return result;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticArray.
	 *
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticArrayHelper(int i, int diff, int[] seq) {
		/*
		 * Your Task
		 */
		if (i != seq.length) {
			seq[i] = seq[i - 1] + diff;
			arithmeticArrayHelper(i + 1, diff, seq);
		}
	}

	/**
	 * Return a list storing the first n numbers in an arithmetic sequence, with
	 * initial term 'start' and common difference 'diff'. You can assume that n is
	 * non-negative (larger than or equal to 0). e.g., arithmeticList(2, 3, 5)
	 * returns a list {2, 5, 8, 11, 14}.
	 * 
	 * @param start the first term in an arithmetic sequence
	 * @param diff  the common difference between terms in an arithmetic sequence
	 * @param n     the first n numbers in an arithmetic sequence
	 * @return a list representing the first n numbers in the specified arithmetic
	 *         sequence
	 *
	 *         <b>You are forbidden to use the arithmeticArray method above to solve
	 *         this problem.</b>
	 *
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> arithmeticList(int start, int diff, int n) {
		/*
		 * Your Task: Make use of the recursive method arithmeticListHelper.
		 */
		List<Integer> myList = new ArrayList<>();
		if (n == 0) {
			return myList;
		}
		if (n == 1) {

			myList.add(start);

			return myList;

		}
		myList.add(start);
		arithmeticListHelper(1, diff, myList, n);
		return myList;
	}

	/**
	 * This is a recursive helper method expected to be used by arithmeticList.
	 *
	 * @param i    position in `seq` to be assigned to
	 * @param diff common difference of the arithmetics sequence
	 * @param seq  a partially filled arithmetic sequence
	 * @param n    size of the arithmetic sequence to be built eventually
	 * 
	 *             Each recursive call to this helper method stores at index `i` of
	 *             the resulting arithmetic sequence `seq`, which is assumed to have
	 *             been partially filled at indices 0, 1, ..., i - 1.
	 */
	void arithmeticListHelper(int i, int diff, List<Integer> seq, int n) {
		/*
		 * Your Task
		 */
		if (i != n) {
			seq.add(seq.get(i - 1) + diff);
			arithmeticListHelper(i + 1, diff, seq, n);
		}
	}

	/**
	 * Return whether or not an array represents the first n numbers of an
	 * arithmetic sequence. An arithmetic sequence has a common difference between
	 * every two adjacent terms. The array may or may not be empty. e.g.,
	 * isArithmeticArray({1, 3, 5, 8, 10}) returns false and isArithmeticArray({1,
	 * 3, 5, 7, 9}) returns true (because the common difference is 2).
	 * 
	 * @param a an array
	 * @return true if input array a represents an arithmetic sequence; false
	 *         otherwise.
	 *
	 *         <b>You are forbidden to use the isArithmeticList method below to
	 *         solve this problem.</b>
	 *
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticArray(int[] a) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticArrayHelper.
		 */
		if (a.length <= 1) {
			return true;
		}
		int diff = a[1] - a[0];

		return isArithmeticArrayHelper(1, diff, a);
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticArray.
	 *
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param a    an array which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `a` with indices i - 1, i, i + 1,
	 *         ..., a.length - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `a` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., a.length - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticArrayHelper(int i, int diff, int[] a) {
		/*
		 * Your Task
		 */
		if (a.length <= 1) {
			return true;
		}
		if (i < a.length) {
			return (a[i] == a[i - 1] + diff) && (isArithmeticArrayHelper(i + 1, diff, a));
		}

		return true;
	}

	/**
	 * Return whether or not a list represents the first n numbers of an arithmetic
	 * sequence. An arithmetic sequence has a common difference between every two
	 * adjacent terms. The list may or may not be empty. e.g., isArithmeticList({1,
	 * 3, 5, 8, 10}) returns false and isArithmeticList({1, 3, 5, 7, 9}) returns
	 * true (because the common difference is 2).
	 * 
	 * @param l a list
	 * @return true if input list l represents an arithmetic sequence; false
	 *         otherwise.
	 *
	 *         <b>You are forbidden to use the isArithmeticArray method above to
	 *         solve this problem.</b>
	 *
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public boolean isArithmeticList(List<Integer> l) {
		/*
		 * Your Task: Make use of the recursive method isArithmeticListHelper.
		 */
		if (l.size() <= 1) {
			return true;
		}
		int diff = l.get(1) - l.get(0);

		return isArithmeticListHelper(1, diff, l);
	}

	/**
	 * This is a recursive helper method expected to be used by isArithmeticList.
	 *
	 * @param i    position in `seq`, starting from which the remaining sub-sequence
	 *             is an arithmetic sequence
	 * @param diff common difference of the arithmetics sequence
	 * @param l    a list which may or may not be an arithmetic sequence
	 * @return whether or not the sub-sequence of `l` with indices i - 1, i, i + 1,
	 *         ..., l.size() - 1 is an arithmetic sequence
	 * 
	 *         Each recursive call to this helper method considers if elements of
	 *         `l` at indices `i - 1` and `i` make two valid adjacent elements in
	 *         the arithmetic sequence, i.e., their difference is equal to the
	 *         common difference `diff`. Also, it considers if the remaining
	 *         sub-sequence (indices i + 1, i + 2, ..., l.size() - 1) is an
	 *         arithmetic sequence with common difference `diff`.
	 */
	boolean isArithmeticListHelper(int i, int diff, List<Integer> l) {
		/*
		 * Your Task
		 */
		if (l.size() <= 1) {
			return true;
		}
		if (i < l.size()) {
			return (l.get(i) == l.get(i - 1) + diff) && isArithmeticListHelper(i + 1, diff, l);
		} else {
			return true;
		}

	}

	/**
	 * Given a sorted input array a, return a sorted array of size a.length + 1,
	 * consisting of all elements of array a and integer i.
	 * 
	 * @param a an array that is sorted in a non-descending order
	 * @param i an integer
	 * @return a sorted array of size a.length + 1, consisting of all elements of
	 *         array a and integer i. e.g., insertIntoSortedArray({1, 2, 4, 5}, 3)
	 *         returns a sorted array {1, 2, 3, 4, 5}.
	 *
	 *         <b>You are forbidden to use the insertIntoSortedList method below to
	 *         solve this problem.</b>
	 *
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] insertIntoSortedArray(int[] a, int i) {

		int[] returner = new int[a.length + 1];

		returner[0] = i;

		return sortMe(a, returner, 0);
	}

	public int[] sortMe(int[] input, int[] output, int indexer) {

		if (output.length == 1) {
			return output;
		}

		if (output[indexer] > input[indexer]) {
			int temp = output[indexer];
			output[indexer] = input[indexer];
			output[indexer + 1] = temp;
		} else {
			output[indexer + 1] = input[indexer];
		}

		indexer++;

		if (indexer < output.length - 1) {
			return sortMe(input, output, indexer);
		} else {
			return output;
		}

	}

	/**
	 * Given a sorted input list, return a sorted list of size list.size() + 1,
	 * consisting of all elements of the input list and integer i.
	 * 
	 * @param myList a list that is sorted in a non-descending order
	 * @param i    an integer
	 * @return a sorted list of size list.size() + 1, consisting of all elements of
	 *         the input list and integer i. e.g., insertIntoSortedList({1, 2, 4,
	 *         5}, 3) returns a sorted list {1, 2, 3, 4, 5}.
	 *
	 *         <b>You are forbidden to use the insertIntoSortedArray method above to
	 *         solve this problem.</b>
	 *
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> insertIntoSortedList(List<Integer> myList, int i) {

		if (myList.size() == 0) {
			myList.add(i);
			return myList;
		}

		return sortMeList(myList, i, 0);

	}

	public List<Integer> sortMeList(List<Integer> myList, int i, int index) {

		if (index == myList.size()) {
			myList.add(i);
			return myList;
		} else if (i < myList.get(index)) {
			myList.add(index, i);
			return myList;
		} else {
			index++;
			return sortMeList(myList, i, index);
		}

	}

	/**
	 * Given two sorted arrays left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return an array (of size left.length + right.length) sorted in a
	 * non-descending order, consisting of all elements of arrays left and right.
	 * 
	 * @param left  an array sorted in a non-descending order
	 * @param right an array sorted in a non-ascending order
	 * @return a sorted array of size left.length + right.length, consisting of all
	 *         elements of arrays left and right. e.g., mergeSortedArraysV2({1, 3,
	 *         5, 7}, {8, 6, 4, 2}) returns a sorted array {1, 2, 3, 4, 5, 6, 7, 8}.
	 *
	 *         <b>You are forbidden to use the mergeSortedListsV2 method below to
	 *         solve this problem.</b>
	 *
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public int[] mergeSortedArrays(int[] left, int[] right) {
		int first = 0;

		int[] returnList = new int[left.length + right.length];

		returnList = arrayLink(returnList, left, right, first, first, first);

		return returnList;
	}

	public int[] arrayLink(int[] returnArr, int[] leftArr, int[] rightArr, int leftIndex, int rightIndex, int counter) {

		if (counter == returnArr.length) {
			return returnArr;
		}

		if (rightIndex == rightArr.length) {
			returnArr[counter] = leftArr[leftIndex];
			counter++;
			leftIndex++;
			return arrayLink(returnArr, leftArr, rightArr, leftIndex, rightIndex, counter);
		} else if (leftIndex == leftArr.length) {
			returnArr[counter] = rightArr[rightArr.length - 1 - rightIndex];
			counter++;
			rightIndex++;
			return arrayLink(returnArr, leftArr, rightArr, leftIndex, rightIndex, counter);
		}

		if (leftArr[leftIndex] > rightArr[rightArr.length - 1 - rightIndex]) {
			returnArr[counter] = rightArr[rightArr.length - 1 - rightIndex];
			rightIndex++;
			counter++;
		} else {
			returnArr[counter] = leftArr[leftIndex];
			leftIndex++;
			counter++;
		}

		if (counter < returnArr.length) {
			return arrayLink(returnArr, leftArr, rightArr, leftIndex, rightIndex, counter);
		} else {
			return returnArr;
		}

	}

	/**
	 * Given two sorted lists left and right, where left is sorted in a
	 * non-descending order and right is sorted in a ***non-ascending*** order,
	 * return a list (of size left.length + right.length) sorted in a non-descending
	 * order, consisting of all elements of lists left and right.
	 * 
	 * @param left  a list sorted in a non-descending order
	 * @param right a list sorted in a non-ascending order
	 * @return a sorted list of size left.size() + right.size(), consisting of all
	 *         elements of lists left and right. e.g., mergeSortedListsV2({1, 3, 5,
	 *         7}, {8, 6, 4, 2}) returns a sorted list {1, 2, 3, 4, 5, 6, 7, 8}.
	 * 
	 *         <b>You are forbidden to use the mergeSortedArraysV2 method above to
	 *         solve this problem.</b>
	 * 
	 *         Requirement: You are required to implement all methods recursively.
	 *         You receive a zero if there is any occurrence of a loop (e.g., for,
	 *         while).
	 */
	public List<Integer> mergeSortedLists(List<Integer> left, List<Integer> right) {
		List<Integer> rightReversed = new ArrayList<Integer>();
		int backCounter = right.size() - 1;
		rightReversed = reverseRightList(right, rightReversed, backCounter); 
		List<Integer> finalList = new ArrayList<Integer>(); // List to put all elements in
		int leftCounter = 0;
		int rightCounter = 0;

		return mergeSortedListsHelper(left, rightReversed, finalList, leftCounter, rightCounter);

	}

	public List<Integer> reverseRightList(List<Integer> listToReverse, List<Integer> newList, int backCounter) {
		if (listToReverse.size() == 0) {
			return listToReverse;
		}

		if (listToReverse.size() == 1) {
			return new ArrayList<>(listToReverse);
		}

		if (backCounter >= 0) {
			newList.add(listToReverse.get(backCounter));
			return reverseRightList(listToReverse, newList, backCounter - 1);
		}

		return newList;
	}

	/**
	 * A Helper Method to Merge two arrays sorted in **NON-ASCENDING ORDER**
	 * (smallest to largest). This helper method compares each of the first elements
	 * in the array, if they exist, and puts the smaller elements in the finalList
	 * and increments that SPECFICS Lists's counter by one.
	 * 
	 * e.g. say leftList = {-2, -1, 0, 1, 2, 3} rightList = {-1, 0, 1, 2, 3} we
	 * first compare elements of both at index 0, leftList at index 0 is smaller
	 * than rightList at index 0 therefore we put leftList(0) into the finalList
	 * then return this method with leftCounter = leftCounter + 1
	 * 
	 * we then compare leftList(1) to rightList(0) because they are equal I just
	 * choose to put leftList's element in and increment leftCounter by 1 and return
	 * mergeSortedListsHelper(leftList, rightList, finalList, leftCounter + 1,
	 * rightCounter)
	 * 
	 * 
	 * now we compare leftList(2) to rightList(0), rightList(0) < leftList(2) so we
	 * put rightList(0) into finalArray and return...
	 * mergeSortedListsHelper(leftList, rightList, finalList, leftCounter,
	 * rightCounter + 1)
	 * 
	 * and so on
	 * 
	 * @param leftList     LeftList sorted in non-ascending order
	 * @param rightList    RightList sorted in non-ascending order
	 * @param finalList    List to put both left and Right into
	 * @param leftCounter  counter to traverse the leftList's elements
	 * @param rightCounter counter to traverse the rightLists's elements
	 * @return a list of size == rightList.size() + leftList.size() with the correct
	 *         elements in the correct positions
	 */
	public List<Integer> mergeSortedListsHelper(List<Integer> leftList, List<Integer> rightList,
			List<Integer> finalList, int leftCounter, int rightCounter) {
		if (leftCounter < leftList.size() && rightCounter < rightList.size()) {
			if (leftList.get(leftCounter) <= rightList.get(rightCounter)) {
				finalList.add(leftList.get(leftCounter));
				return mergeSortedListsHelper(leftList, rightList, finalList, leftCounter + 1, rightCounter);
			} else { // leftList.get(leftCounter) > rightList.get(rightCounter)
				finalList.add(rightList.get(rightCounter));
				return mergeSortedListsHelper(leftList, rightList, finalList, leftCounter, rightCounter + 1);
			}
		}

		/*
		 * This condition is only true if the List were emptied at the same time,
		 * meaning they origninally had the same size() e.g if I tried to implement this
		 * method on the Lists {1,2,3} and {-1,-2,-3}
		 * 
		 * 
		 */
		if (rightCounter == rightList.size() && leftCounter == leftList.size()) {
			// We can just return final list, we are good
			return finalList;
		}

		if (rightCounter < rightList.size()) {
			finalList.add(rightList.get(rightCounter));
			return mergeSortedListsHelper(leftList, rightList, finalList, leftCounter, rightCounter + 1);
		}

		if (leftCounter < leftList.size()) {
			finalList.add(leftList.get(leftCounter));
			return mergeSortedListsHelper(leftList, rightList, finalList, leftCounter + 1, rightCounter);
		}

		return finalList;

	}

}