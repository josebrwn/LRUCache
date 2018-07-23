package com.josephbrown;
import java.util.HashMap;
/*
    An LRU (least recently used) Cache is a hashmap of a doubly linked list.
    The hashmap lets us look up our linked list nodes by key,
    and the linked list (head, tail, and prev/next properties) keeps the nodes in order.

    A User may search for a node by key, or insert a new key value pair.

    When a key is not in the cache, the user should perform a slow lookup
    and insert the new pair.

    @param maxSize = when list reaches maxSize the LRU is deleted after every insert
 */
public class LRUCache {
    // props and constructor
    private int maxCacheSize;

    public LRUCache (int maxSize) {
        maxCacheSize = maxSize;
        System.out.println("LRUCache= " + maxCacheSize);
    }

    private HashMap<String, Node> mappedPairs = new HashMap<String, Node>();
    private Node Head = null; // most recently used
    private Node Tail = null; // least recently used = LRU

    private static class Node {
        private Node next;
        private Node prev;
        public String key;
        public String value;
        public Node (String k, String v) {
            key = k;
            value = v;
        }
    }
    // public methods

    // add the new key-value pair to the linked list and then the hashmap
    public void createNode (String key, String value) {
        Node n = new Node(key, value);

        deleteNode(key);
        addNodeToLinkedList(n);
        mappedPairs.put(key, n); // add to hashmap
        System.out.println("createNode " + key);
    }

    public String getNode(String key) {
        Node n = mappedPairs.get(key);

        if (n == null) {
            System.out.println("did not find key= " + key + ", cache size is " + mappedPairs.size());
            return null;
        }
        // remove and re-insert the node at the front of the list
        removeNodeFromLinkedList(n);
        addNodeToLinkedList(n);

        System.out.println("getNode " + n.key);
        System.out.println("LRU is now " + Tail.key);
        System.out.println("Head is now " + Head.key);
        System.out.println("size is now " + mappedPairs.size());

        return n.value;
    }

    public void deleteNode (String key) {
        Node n = mappedPairs.get(key);
        if (n != null) {
            System.out.println("deleteNode " + key);
            removeNodeFromLinkedList(n);
            mappedPairs.remove(key); // remove from hashmap
        }
    }

    // private methods

    private void removeNodeFromLinkedList (Node n) {
        // fix the prev-next and head-tail values in the linked list
        if (n == null) return;
        if (n.prev != null) n.prev.next = n.next;
        if (n.next != null) n.next.prev = n.prev;
        if (n == Tail) Tail = n.next;
        if (n == Head) Head = n.prev;
    }
    
    private void addNodeToLinkedList (Node n) {
        // replace the node at the Head of the linked list
        if (Head == null) {
            Tail = n;
            Head = n;
        }
        else {
            Head.next = n;
            n.prev = Head;
            Head = n;
        }
        if (mappedPairs.size() >= maxCacheSize && Tail != null) {
            System.out.println("size exceeded, deleting key " + Tail.key);
            deleteNode(Tail.key);
            System.out.println("new tail key = " + Tail.key);
        }
    }

}
