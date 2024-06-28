package lc;

import java.util.*;

public class lc208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.print(trie.search("apple")); // 返回 True
        trie.search("app"); // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app"); // 返回 True
    }
}

class Trie {

    class TrieNode {
        TrieNode[] next;
        boolean end;

        public TrieNode() {
            this.next = new TrieNode[26];
            this.end = false;
        }
    }

    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int dif = word.charAt(i) - 'a';
            if (cur.next[dif] == null) {
                cur.next[dif] = new TrieNode();
            }

            // TrieNode tmp = cur.next[dif];
            if (i == word.length() - 1) {
                cur.next[dif].end = true;
            }
            cur = cur.next[dif];
        }
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int dif = word.charAt(i) - 'a';
            if (cur.next[dif] == null) {
                return false;
            }

            cur = cur.next[dif];
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int dif = prefix.charAt(i) - 'a';
            if (cur.next[dif] == null) {
                return false;
            }
            cur = cur.next[dif];
        }
        return true;
    }
}