package com.company;

//所有的树状结构都一定可以类比二叉树来写，如果觉得没有思路写，就想想二叉树是怎么写的
class TrieNode {
    TrieNode[] Node;
    boolean isEnd;
    public TrieNode() {
        this.Node = new TrieNode[26];
        isEnd = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        char[] words = word.toCharArray();
        TrieNode head = this.root;
        for (char w : words) {
            if (head.Node[w - 'a'] == null) {
                head.Node[w - 'a'] = new TrieNode();
            }
            head = head.Node[w - 'a'];
        }
        head.isEnd = true;
    }

    public boolean search(String word) {
        char[] words = word.toCharArray();
        TrieNode head = this.root;
        for (char w : words) {
            if (head.Node[w - 'a'] == null) {
                return false;
            }
            head = head.Node[w - 'a'];
        }
        return head.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] words = prefix.toCharArray();
        TrieNode head = this.root;
        for (char w : words) {
            if (head.Node[w - 'a'] == null) {
                return false;
            }
            head = head.Node[w - 'a'];
        }
        return true;
    }
}

public class _208ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("apple"));
        System.out.println(trie.startsWith("appl"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
