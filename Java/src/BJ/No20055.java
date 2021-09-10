package BJ;
//시뮬레이션 구현
//컨베이어 벨트 위의 로봇

import java.util.Scanner;

public class No20055 {

    static void rotate(int[] a ){
        int temp = a[a.length - 1];
        for (int i=a.length-1; i>0; i--) {
            a[i] = a[i - 1];
        }
        a[0] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n * 2];
        for (int i=0; i<2*n; i++) {
            a[i] = sc.nextInt();
        }
        int[] box = new int[2 * n];
        int zero = 0;
        for (int t = 1; ; t++) {
            //1번 한 칸 회전
            rotate(a);
            rotate(box);

            //로봇이 내리는 위치에 도달하면 즉시 내림
            if (box[n-1] == 1) {
                box[n - 1] = 0;
            }
            //2번
            for (int i=n-2; i>=0; i--) {
                if (box[i] == 1) {
                    // 2-1번
                    if (box[i+1] == 0 && a[i+1] >0) {
                        box[i + 1] = 1;
                        box[i] = 0;
                        a[i + 1] -= 1;
                        if (a[i + 1] == 0) {
                            zero += 1;
                        }
                    }
                }
            }
            //로봇이 내리는 위치에 도달하면 즉시 내림
            if (box[n-1] == 1) {
                box[n - 1] = 0;
            }
            //3번
            if (a[0] > 0) {
                box[0] = 1;
                a[0] -= 1;
                if (a[0] == 0) {
                    zero += 1;
                }
            }
            //4번
            if (zero >= k) {
                System.out.println(t);
                break;
            }
        }
    }
}
