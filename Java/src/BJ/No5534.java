package BJ;
// 간판
import java.util.Scanner;

public class No5534 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        String newSignboard = sc.nextLine();

        int count = 0;
        for (int i = 0; i < N; i++) {
            String oldSignboard = sc.nextLine();
            if (canMakeSign(newSignboard, oldSignboard)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean canMakeSign(String newSignboard, String oldSignboard) {
        int n = newSignboard.length();
        int m = oldSignboard.length();

        if (n > m) {
            return false;
        }

        for (int i = 0; i <= m - n; i++) {
            for (int j = 1; j <= (m - i) / (n - 1); j++) {
                boolean match = true;
                for (int k = 0; k < n; k++) {
                    int index = i + k * j;
                    if (index >=m || oldSignboard.charAt(index) != newSignboard.charAt(k)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }

        return false;
    }
}
