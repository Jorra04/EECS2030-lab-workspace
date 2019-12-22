package test2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * A class representing a piggy bank that has an owner. 
 * A piggy bank owns a collection (or possibly collections) of coins,
 * but does not own the coins themselves.
 * 
 * <p>
 * Only the owner of the piggy bank is able to remove coins
 * from the piggy bank.
 */
public class OwnedPiggyBank {
	// YOU NEED TO ADD A FIELD OR FIELDS TO STORE THE COINS
	private Owner owner;
	private List<Coin> coins;
	

	/**
	 * Initializes this piggy bank so that it has the specified owner
	 * and no coins.
	 * 
	 * @param owner
	 *            the owner of this piggy bank
	 */
	public OwnedPiggyBank(Owner owner) {
		this.owner = owner;
		this.coins = new ArrayList<>();
		
	}

	/**
	 * Initializes this piggy bank by copying another piggy bank. This piggy
	 * bank will have the same owner and the same number and type of coins as
	 * the other piggy bank.
	 * 
	 * @param other
	 *            the piggy bank to copy
	 */
	public OwnedPiggyBank(OwnedPiggyBank other) {
//		this.owner = other.owner;
//		this.coins = new ArrayList<>(other.coins);
		/*
		 * another method of completion, using constructor chaining.
		 */
		this(other.owner);
		this.coins = new ArrayList<>(other.coins);
	}

	/**
	 * Returns the owner of this piggy bank.
	 * 
	 * @return the owner of this piggy bank
	 */
	public Owner getOwner() {
		return this.owner;
	
	}

	/**
	 * Adds the specified coins to this piggy bank.
	 * 
	 * @param coins
	 *            a list of coins to add to this piggy bank
	 */
	public void add(List<Coin> coins) {
		this.coins.addAll(coins);
		
		/*
		 * another way to do this is to loop over every Coin in coins
		 */
		
//		for(Coin coin : coins) {
//			this.coins.add(coin);
//		}
	}

	/**
	 * Returns true if this piggy bank contains the specified coin, and false
	 * otherwise.
	 * 
	 * @param coin
	 *            a coin
	 * @return true if this piggy bank contains the specified coin, and false
	 *         otherwise
	 */
	public boolean contains(Coin coin) {
		return this.coins.contains(coin);
	}
		
	

	/**
	 * Allows the owner of this piggy bank to remove a coin equal to the value
	 * of the specified coin from this piggy bank.
	 * 
	 * <p>
	 * If the specified user is not equal to the owner of this piggy bank,
	 * then the coin is not removed from this piggy bank, and null is returned.
	 * 
	 * @param user
	 *            the person trying to remove the coin
	 * @param coin
	 *            a coin
	 * @return a coin equal to the value of the specified coin from this piggy
	 *         bank, or null if user is not the owner of this piggy bank
	 * @pre. the piggy bank contains a coin equal to the specified coin
	 */
	public Coin remove(Owner user, Coin coin) {
		if(!this.owner.equals(user)) {
			return null;
		}
		int finder = this.coins.indexOf(coin);
		Coin returner = this.coins.get(finder);
		this.coins.remove(finder);
		return returner;
		
	}

	/**
	 * Allows the owner of this piggy bank to remove
	 * the smallest number of coins whose total value in cents is equal
	 * to the specified value in cents from this piggy bank.
	 * 
	 * <p>
	 * Returns the empty list if the specified user is not equal to
	 * the owner of this piggy bank.
	 * 
	 * @param user
	 *            the person trying to remove coins from this piggy bank
	 * @param value
	 *            a value in cents
	 * @return the smallest number of coins whose total value in cents is equal
	 *         to the specified value in cents from this piggy bank 
	 * @pre. the piggy bank contains a group of coins whose total value is equal
	 *         to specified value
	 */
	public List<Coin> removeCoins(Owner user, int value) {
		List<Coin> finalList = new ArrayList<>();
		if(!this.owner.equals(user)) {
			return finalList;
		}
		int value2 = value;
		Collections.sort(this.coins);
		Collections.reverse(this.coins);
		for(Coin coin: this.coins) {
			if(value2 >= coin.getValue()) {
				value2-= coin.getValue();
				finalList.add((coin));
			}
		}
		return finalList;
		
	}
	
	

	
	/**
	 * Returns a deep copy of the coins in this piggy bank. The returned list
	 * has its coins in sorted order (from smallest value to largest value;
	 * i.e., pennies first, followed by nickels, dimes, quarters, loonies, and
	 * toonies).
	 * 
	 * @return a deep copy of the coins in this piggy bank
	 */
	public List<Coin> deepCopy() {
		List<Coin> deepCopy = new ArrayList<>();
		for(Coin coin: this.coins) {
			deepCopy.add(new Coin(coin));
		}
		Collections.sort(deepCopy);
		return deepCopy;
	}
		
		
//		List<Coin> coinCopy = new ArrayList<>();
//		for(int  i =0; i < this.coins.size();i++) {
//			coinCopy.add(new Coin(this.coins.get(i)));
//			
//		}
//		Collections.sort(coinCopy);
//		return coinCopy;
		// different way of doing it.
	

	
	/**
	 * Counts the number of coins equal to the specified coin
	 * in this piggy bank.
	 * 
	 * <p>
	 * NOTE TO STUDENTS: You should create a private static 
	 * helper method that recursively counts the number of 
	 * coins in a specified list, array, or map depending on
	 * how you chose to implement the piggy bank. This method
	 * should then call the recursive method to get the required
	 * count.
	 * 
	 * @param coin a coin
	 * @return the number of coins equal to the specified coin
	 * in this piggy bank
	 */
	public int numberOf(Coin coin) {
//		int index = 0;
//		int count = 0;
//		if(this.coins.size() == 0) {
//			return 0;
//		}
//		return rec(index, count, coin, this.coins);
//		int count = 0;
		return rec(coin,this.coins);
	}
	private static int rec(Coin coin,List<Coin> t) {
		if(t.size() == 0) {
			return 0;
		}
		if(t.get(0).equals(coin)) {
			return 1 + rec(coin,t.subList(1, t.size()));
		}
		return rec(coin,t.subList(1, t.size()));
	}
//	private static int rec(int index, int count, Coin coin, List<Coin> t) {
//		if(t.size() == index) {
//			return count;
//		}
//		if(t.get(index).equals(coin)) {
//			count++;
//		}
//		index++;
//		return rec(index, count, coin, t);
//	}
	
	
	
	
	// ADD A PRIVATE STATIC HELPER METHOD HERE

}
