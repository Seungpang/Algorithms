package BJ;
// 나는야 포켓몬 마스터 이다솜

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> poketmonByName = new HashMap<>();
        Map<Integer, String> poketmonByNumber = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            poketmonByName.put(name, i + 1);
            poketmonByNumber.put(i + 1, name);
        }

        for (int i = 0; i < M; i++) {
            String request = br.readLine();
            if (isNumeric(request)) {
                System.out.println(poketmonByNumber.get(Integer.parseInt(request)));
            } else {
                System.out.println(poketmonByName.get(request));
            }
        }
    }

    static boolean isNumeric(String n) {
        try {
            Integer.parseInt(n);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
