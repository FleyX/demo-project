package com.fanxb.common;

import java.util.*;
import java.util.stream.Stream;

public class Q211 {
    public static class WordDictionary {
        boolean isEnd;
        WordDictionary[] child;

        public WordDictionary() {
            isEnd = false;
            child = new WordDictionary[26];
        }

        public void addWord(String word) {
            WordDictionary root = this;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (root.child[index] == null) root.child[index] = new WordDictionary();
                root = root.child[index];
            }
            root.isEnd = true;
        }

        public boolean search(String word) {
            return dfs(this, word, word.length(), 0);
        }

        private boolean dfs(WordDictionary node, String word, int length, int index) {
            if (index == length) return node.isEnd;
            char c = word.charAt(index);
            if (c == '.') {
                for (WordDictionary item : node.child) {
                    boolean isOk = item != null && dfs(item, word, length, index + 1);
                    if (isOk) return isOk;
                }
            } else {
                int i = c - 'a';
                if (node.child[i] != null) return dfs(node.child[i], word, length, index + 1);
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Q211.WordDictionary q = new Q211.WordDictionary();
        q.addWord("bad");
        q.addWord("dad");
        q.addWord("mad");
        q.search("pad");
        q.search("bad");
        q.search(".ad");
        q.search("b..");

    }

}
