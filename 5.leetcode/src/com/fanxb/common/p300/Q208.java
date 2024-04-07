package com.fanxb.common.p300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q208 {

    private class Trie {

        private boolean isEnd;
        private Trie[] child;


        public Trie() {
            isEnd = false;
            child = new Trie[26];
        }

        public void insert(String word) {
            Trie root = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (root.child[index] == null) {
                    Trie trie = new Trie();
                    root.child[index] = trie;
                }
                root = root.child[index];
            }
            root.isEnd = true;
        }


        public boolean search(String word) {
            Trie trie = searchRes(word);
            return trie != null && trie.isEnd;
        }

        private Trie searchRes(String word) {
            Trie root = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (root.child[index] == null) return null;
                root = root.child[index];
            }
            return root;
        }

        public boolean startsWith(String prefix) {
            return searchRes(prefix) != null;
        }
    }
}
