package BJ;
// 이모티콘

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No14226_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();

        boolean[][] visited = new boolean[1001][1001];
        Queue<Emoticon> queue = new LinkedList<>();

        Emoticon initial = new Emoticon(1, 0, 0);
        visited[1][0] = true;
        queue.offer(initial);

        while (!queue.isEmpty()) {
            Emoticon current = queue.poll();

            if (current.screen == s) {
                System.out.println(current.time);
                break;
            }

            // 1. 화면의 이모티콘을 모두 복사, 클립보드에 저장
            if (!visited[current.screen][current.screen]) {
                visited[current.screen][current.screen] = true;
                queue.offer(new Emoticon(current.screen, current.screen, current.time + 1));
            }

            // 2. 클립보드에 있는 이모티콘을 화면에 붙여넣기
            if (current.clipboard > 0 && current.screen + current.clipboard <= 1000 &&
                    !visited[current.screen + current.clipboard][current.clipboard]) {
                visited[current.screen + current.clipboard][current.clipboard] = true;
                queue.offer(new Emoticon(current.screen + current.clipboard, current.clipboard, current.time + 1));
            }

            // 3. 화면에 있는 이모티콘 중 하나를 삭제
            if (current.screen > 0 && !visited[current.screen - 1][current.clipboard]) {
                visited[current.screen - 1][current.clipboard] = true;
                queue.offer(new Emoticon(current.screen - 1, current.clipboard, current.time + 1));
            }
        }
    }

    static class Emoticon {
        int screen;
        int clipboard;
        int time;

        public Emoticon(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
}
