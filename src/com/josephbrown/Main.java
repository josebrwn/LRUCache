package com.josephbrown;
public class Main {
    public static void main(String[] args) {
	/*
    an LRU Cache takes a specific maxSize param, e.g. 50K addresses
    if a key is not found the user performs a  "slow lookup" (sales_tax_lookup)
    and inserts the new key-value
     */

	LRUCache fast_rate_lookup = new LRUCache(5);
	String lookupResult = "";

    // user performs "slow lookup" and creates a new key value pair
    fast_rate_lookup.createNode("1", "1 value");
    fast_rate_lookup.createNode("2", "2 value");
    fast_rate_lookup.createNode("3", "3 value");

    lookupResult = fast_rate_lookup.getNode("3");
    System.out.println("lookupResult is: " + lookupResult);

    fast_rate_lookup.createNode("1", "1 value"); // test re-insertion

    lookupResult = fast_rate_lookup.getNode("1");
    System.out.println("lookupResult is: " + lookupResult);

    fast_rate_lookup.createNode("4", "4 value");
    fast_rate_lookup.createNode("5", "5 value"); // size = 5, LRU = 2

    lookupResult = fast_rate_lookup.getNode("2");
    System.out.println("lookupResult is: " + lookupResult);

    fast_rate_lookup.createNode("6", "6 value");
    fast_rate_lookup.createNode("7", "7 value");
    fast_rate_lookup.createNode("8", "8 value");
    fast_rate_lookup.createNode("9", "9 value");

    lookupResult = fast_rate_lookup.getNode("asdfasdfasdf");
    System.out.println("lookupResult is: " + lookupResult);

    }
}
