package BJ;
// 회전 초밥

import java.util.Scanner;

public class No15961 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) {
            sushi[i] = sc.nextInt();
        }

        int[] eaten = new int[d + 1];
        int types = 0;

        for (int i = 0; i < k; i++) {
            if (eaten[sushi[i]] == 0) {
                types++;
            }
            eaten[sushi[i]]++;
        }

        int maxTypes = types;

        if (eaten[c] == 0) {
            maxTypes++;
        }

        for (int i = 1; i < N; i++) {
            if (--eaten[sushi[i - 1]] == 0) {
                types--;
            }

            if (eaten[sushi[(i + k - 1) % N]]++ == 0) {
                types++;
            }

            int currentTypes = types;
            if (eaten[c] == 0) {
                currentTypes++;
            }

            maxTypes = Math.max(maxTypes, currentTypes);
        }

        System.out.println(maxTypes);
    }
}
