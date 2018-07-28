# LRUCache

A simple LRU cache in Java. Problem 16.25 in "Cracking the Coding Interview".

### Problem
Design a caching mechanism for web lookups that will map two values, e.g. a street address and a sales tax rate. Assume the two values are strings, and the cache has a maximum size and starts empty. When the maximum size is reached, the cache should begin deleting the least recently used entries in the cache.

### Solution
This problem is solveable in O(1) time complexity and O(n) space complexity. The trick is two use two data structures, a doubly linked list and a hashmap. When a user performs a lookup, the key they enter is searched on in the hashmap to find a node in the linked list, which contans the key-value pair. The linked list also keeps the nodes in order, so that the most recently used is at the head of the list and the least recently used at the tail.
