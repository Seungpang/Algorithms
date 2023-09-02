package BJ;
// 큐 2
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class No18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> q = new ArrayDeque<>();
        while (N-- > 0) {
            String[] commands = br.readLine().split(" ");
            String command = commands[0];
            if (command.equals("push")) {
                q.add(Integer.valueOf(commands[1]));
            } else if (command.equals("pop")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else if (command.equals("size")) {
                bw.write(q.size() + "\n");
            } else if (command.equals("empty")) {
                if (q.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if (command.equals("front")) {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.peek() + "\n");
                }
            } else {
                if (q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.peekLast() + "\n");
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
