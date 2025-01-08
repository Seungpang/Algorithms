package BJ;
// 전설

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class No19585 {
    static Trie cTrie = new Trie();
    static HashSet<String> nHs = new HashSet<>();
    static int cMin, nMin, cMax, nMax;

    private static boolean searchTeamName(String s) {
        int len = s.length();
        Trie iter = cTrie;
        for (int i = 0; i < len; i++) {
            if (len - i < nMin)
                break;
            iter = iter.getChild(s.charAt(i));
            if (iter == null) break;
            if (iter.isWordEnd) {
                if (nHs.contains(s.substring(i + 1)))
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        cMin = nMin = 1001;
        cMax = nMax = 0;
        for (int i = 0; i < c; i++) {
            String cur = br.readLine();
            int len = cur.length();
            if (len < cMin) cMin = len;
            if (len > cMax) cMax = len;
            Trie iter = cTrie;
            for (int j = 0; j < len; j++) {
                iter = iter.addAndGetChild(cur.charAt(j));
            }
            iter.markingWordEnd();
        }
        for (int i = 0; i < n; i++) {
            String cur = br.readLine();
            int len = cur.length();
            if (len < nMin) nMin = len;
            if (len > nMax) nMax = len;
            nHs.add(cur);
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            String cur = br.readLine();
            boolean chk = cur.length() <= cMax + nMax && searchTeamName(cur);
            if (chk) {
                sb.append('Y').append('e').append('s').append('\n');
            } else {
                sb.append('N').append('o').append('\n');
            }
        }
        System.out.print(sb);
    }

    static class Trie {
        boolean isWordEnd;
        Trie[] child;

        public Trie() {
            isWordEnd = false;
            child = new Trie[26];
        }

        public Trie addAndGetChild(char c) {
            if (child[c - 'a'] == null)
                child[c - 'a'] = new Trie();
            return child[c - 'a'];
        }

        public Trie getChild(char c) {
            return child[c - 'a'];
        }

        public void markingWordEnd() {
            this.isWordEnd = true;
        }
    }
}
