package com.josephbrown;
public class Main {
    public static void main(String[] args) {
	/*
    an LRU Cache takes a specific maxSize param, e.g. 50K addresses
    if a key is not found the user performs a  "slow lookup"
    and inserts the new key-value
     */

	LRUCache c = new LRUCache(5);
	String result = "";

    // user performs "slow lookup" and creates a new key value pair
    c.createNode("1", "1 value");
    c.createNode("2", "2 value");
    c.createNode("3", "3 value");

    result = c.getNode("3");
    System.out.println("result is: " + result);

    c.createNode("1", "1 value"); // test re-insertion

    result = c.getNode("1");
    System.out.println("result is: " + result);

    c.createNode("4", "4 value");
    c.createNode("5", "5 value"); // size = 5, LRU = 2

    result = c.getNode("2");
    System.out.println("result is: " + result);

    c.createNode("6", "6 value");
    c.createNode("7", "7 value");
    c.createNode("8", "8 value");
    c.createNode("9", "9 value");

    result = c.getNode("asdfasdfasdf");
    System.out.println("result is: " + result);

    }
}
