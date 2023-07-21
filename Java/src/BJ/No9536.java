package BJ;
// 여우는 어떻게 울지?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No9536 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<String> result;

        while (T-- > 0) {
            String recordedSound = br.readLine();
            result = new ArrayList<>(List.of(recordedSound.split(" ")));
            while (true) {
                String input = br.readLine();
                if (input.equals("what does the fox say?")) {
                    break;
                }
                String[] split = input.split(" ");
                String sound = split[2];
                if (result.contains(sound)) {
                    result.removeAll(Collections.singleton(sound));
                }
            }

            StringBuilder sb = new StringBuilder();
            for (String s : result) {
                sb.append(s).append(" ");
            }
            System.out.println(sb);
        }
    }
}
