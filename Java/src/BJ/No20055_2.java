package BJ;
//시뮬레이션 구현
//컨베이어 벨트 위의 로봇

import java.util.Scanner;

public class No20055_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        /**
         * 1.벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
         * 2.가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
         *      로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
         * 3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
         * 4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
         */
        int[] a = new int[n * 2];
        for (int i = 0; i < 2 * n; i++) {
            a[i] = sc.nextInt();
        }
        int[] box = new int[n * 2];
        int zero = 0;
        for (int t = 1; ; t++) {
            //1번
            rotate(a);
            rotate(box);

            // 내리는 위치면 바로 내리기
            if (box[n - 1] == 1) {
                box[n - 1] = 0;
            }

            for (int i = n - 2; i >= 0; i--) {
                if (box[i] == 1) {
                    if (box[i + 1] == 0 && a[i + 1] > 0) {
                        box[i + 1] = 1;
                        box[i] = 0;
                        a[i + 1] -= 1;
                        if (a[i + 1] == 0) {
                            zero++;
                        }
                    }
                }
            }
            if (box[n - 1] == 1) {
                box[n - 1] = 0;
            }
            if (a[0] > 0) {
                box[0] = 1;
                a[0] -= 1;
                if (a[0] == 0) {
                    zero++;
                }
            }

            if (zero >= k) {
                System.out.println(t);
                break;
            }
        }
    }

    static void rotate(int[] a) {
        int temp = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = temp;
    }
}
