package BJ;
// 숫자 야구

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2503 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        boolean[] ballNumbers = new boolean[1000];
        for (int i = 123; i < 1000; i++) {
            String number = String.valueOf(i);
            if (number.charAt(0) == '0' || number.charAt(1) == '0' || number.charAt(2) == '0') {
                continue;
            }
            if (number.charAt(0) == number.charAt(1) || number.charAt(1) == number.charAt(2)
                    || number.charAt(2) == number.charAt(0)) {
                continue;
            }
            ballNumbers[i] = true;
        }

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int number = 123; number < 1000; number++) {
                if (ballNumbers[number]) {
                    int nStrike = 0;
                    int nBall = 0;
                    for (int i = 0; i < 3; i++) {
                        if (num.charAt(i) == String.valueOf(number).charAt(i)) {
                            nStrike++;
                            continue;
                        }
                        if (String.valueOf(number).contains(num.substring(i, i + 1))) {
                            nBall++;
                        }
                    }
                    if (nStrike == strike && nBall == ball) {
                        ballNumbers[number] = true;
                    } else {
                        ballNumbers[number] = false;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 123; i < 1000; i++) {
            if (ballNumbers[i]) {
                result++;
            }
        }
        System.out.println(result);
    }
}
