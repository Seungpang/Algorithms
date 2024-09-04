package BJ;
// 원자의 에너지

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class No19585 {

    static class Trie {
        private static class Node {
            Node[] children = new Node[26];
            boolean isEnd;
        }

        private final Node root = new Node();

        void insert(char[] word) {
            Node node = root;
            for (char c : word) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Node();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        boolean hasPrefix(char[] word, int start, int end) {
            Node node = root;
            for (int i = start; i < end; i++) {
                int index = word[i] - 'a';
                if (node.children[index] == null) return false;
                node = node.children[index];
                if (node.isEnd) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Trie colorTrie = new Trie();
        Set<String> nicknames = new HashSet<>();

        for (int i = 0; i < C; i++) {
            colorTrie.insert(br.readLine().toCharArray());
        }

        for (int i = 0; i < N; i++) {
            nicknames.add(br.readLine());
        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            char[] teamName = br.readLine().toCharArray();
            sb.append(isValidTeamName(teamName, colorTrie, nicknames) ? "Yes\n" : "No\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean isValidTeamName(char[] teamName, Trie colorTrie, Set<String> nicknames) {
        for (int i = 1; i < teamName.length; i++) {
            if (colorTrie.hasPrefix(teamName, 0, i) &&
                    nicknames.contains(new String(teamName, i, teamName.length - i))) {
                return true;
            }
        }
        return false;
    }
}
