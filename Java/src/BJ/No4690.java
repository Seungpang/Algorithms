package BJ;
// 완전 세제곱

public class No4690 {

    public static void main(String[] args) {
        int n = 100;

        for (int a = 2; a <= n; a++) {
            int a3 = a * a * a;
            for (int b = 2; b < a; b++) {
                int b3 = b * b * b;
                if (b3 >= a3) break;
                for (int c = b; c < a; c++) {
                    int c3 = c * c * c;
                    if (b3 + c3 >= a3) break;
                    for (int d = c; d < a; d++) {
                        int d3 = d * d * d;
                        int sum = b3 + c3 + d3;
                        if (sum > a3) break;
                        if (sum == a3) {
                            System.out.printf("Cube = %d, Triple = (%d,%d,%d)%n", a, b, c, d);
                        }
                    }
                }
            }
        }
    }
}
