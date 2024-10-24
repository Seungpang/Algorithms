package BJ;
// 사다리 타기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2469 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        char[] current = new char[k];
        for(int i = 0; i < k; i++) {
            current[i] = (char)('A' + i);
        }
        char[] target = br.readLine().toCharArray();

        char[][] ladder = new char[n][k-1];
        int questionRow = 0;
        for(int i = 0; i < n; i++) {
            ladder[i] = br.readLine().toCharArray();
            if(ladder[i][0] == '?') {
                questionRow = i;
            }
        }

        for(int i = 0; i < questionRow; i++) {
            for(int j = 0; j < k-1; j++) {
                if(ladder[i][j] == '-') {
                    char temp = current[j];
                    current[j] = current[j+1];
                    current[j+1] = temp;
                }
            }
        }

        for(int i = n-1; i > questionRow; i--) {
            for(int j = 0; j < k-1; j++) {
                if(ladder[i][j] == '-') {
                    char temp = target[j];
                    target[j] = target[j+1];
                    target[j+1] = temp;
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < k-1; i++) {
            if(current[i] == target[i]) {
                answer.append("*");
            } else if(current[i] == target[i+1] && current[i+1] == target[i]) {
                answer.append("-");
                char temp = current[i];
                current[i] = current[i+1];
                current[i+1] = temp;
            } else {
                System.out.println("x".repeat(k-1));
                return;
            }
        }

        System.out.println(answer);
    }
}
