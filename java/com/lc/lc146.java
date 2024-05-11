package lc;

import java.util.*;
import java.util.LinkedList;

public class lc146 {
    // todo 不熟
    class Node {
        int key, val;
        Node pre, next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    class LRUCache {
        int capacity;
        Node dummy = new Node(-1, -1);
        Map<Integer, Node> map = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            dummy.pre = dummy;
            dummy.next = dummy;
        }

        public int get(int key) {
            Node n = getNode(key);
            return n == null ? -1 : n.val;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.val = value;
                return;
            }

            node = new Node(key, value);
            map.put(key, node);
            putFront(node);
            if (map.size() > capacity) {
                Node n = dummy.pre;
                map.remove(n.key);
                remove(n);
            }
        }

        public Node getNode(int key) {
            if (!map.containsKey(key)) {
                return null;
            }

            Node node = map.get(key);
            remove(node);
            putFront(node);
            return node;
        }

        public void putFront(Node node) {
            node.next = dummy.next;
            node.pre = dummy;
            node.pre.next = node;
            node.next.pre = node;
        }

        public void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
}
