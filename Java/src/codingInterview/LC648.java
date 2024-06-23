package codingInterview;

import java.util.List;

public class LC648 {

    public static void main(String[] args) {
        final LC648 lc648 = new LC648();
        System.out.println(lc648.replaceWords(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery"));
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = buildTrie(dictionary);

        String[] words = sentence.split(" ");

        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(findRoot(word, root));
        }

        return result.toString();
    }

    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }
        return root;
    }

    private String findRoot(String word, TrieNode root) {
        TrieNode node = root;
        StringBuilder rootWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null || node.isEnd) {
                break;
            }
            rootWord.append(c);
            node = node.children[c - 'a'];
        }
        return node.isEnd ? rootWord.toString() : word;
    }
}
