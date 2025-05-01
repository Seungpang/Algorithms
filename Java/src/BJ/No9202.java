package BJ;
// Boggle

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class No9202 {

    static char[][] board = new char[4][4];
    static boolean[][] visited = new boolean[4][4];
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static Set<String> foundWords = new HashSet<>();
    static TrieNode root;
    static int maxScore, longestWordLength;
    static String longestWord;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int w = Integer.parseInt(br.readLine());

        root = new TrieNode();
        for (int i = 0; i < w; i++) {
            insertWord(br.readLine());
        }

        br.readLine();

        int b = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < b; t++) {
            for (int i = 0; i < 4; i++) {
                String line = br.readLine();
                for (int j = 0; j < 4; j++) {
                    board[i][j] = line.charAt(j);
                }
            }

            foundWords.clear();
            maxScore = 0;
            longestWordLength = 0;
            longestWord = "";

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    dfs(i, j, root);
                }
            }

            sb.append(maxScore).append(" ").append(longestWord).append(" ").append(foundWords.size()).append("\n");

            if (t < b - 1) br.readLine(); // 마지막 보드가 아니면 빈 줄 읽기
        }

        System.out.print(sb);
    }

    static void insertWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'A';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
        node.word = word;
    }

    static void dfs(int x, int y, TrieNode node) {
        if (x < 0 || x >= 4 || y < 0 || y >= 4 || visited[x][y]) return;

        char c = board[x][y];
        int index = c - 'A';
        if (node.children[index] == null) return;

        node = node.children[index];
        visited[x][y] = true;

        if (node.isEndOfWord && !foundWords.contains(node.word)) {
            foundWords.add(node.word);
            updateScore(node.word);
        }

        for (int i = 0; i < 8; i++) {
            dfs(x + dx[i], y + dy[i], node);
        }

        visited[x][y] = false;
    }

    static void updateScore(String word) {
        int length = word.length();
        int score = 0;
        if (length >= 3 && length <= 4) score = 1;
        else if (length == 5) score = 2;
        else if (length == 6) score = 3;
        else if (length == 7) score = 5;
        else if (length == 8) score = 11;

        maxScore += score;

        if (length > longestWordLength || (length == longestWordLength && word.compareTo(longestWord) < 0)) {
            longestWordLength = length;
            longestWord = word;
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
        String word;
    }
}
