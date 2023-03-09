package Programmers;

public class PG43163 {

    public static void main(String[] args) {
        final PG43163 pg43163 = new PG43163();
        System.out.println(pg43163.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
    }
    boolean[] visited;
    int answer = 0;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer;
    }

    private void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (visited[i]) {
                continue;
            }

            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) == words[i].charAt(j)) {
                    k++;
                }

                if (k + 1 == begin.length()) {
                    visited[i] = true;
                    dfs(words[i], target, words, cnt + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
