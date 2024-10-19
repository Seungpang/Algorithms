package BJ;
// 숌 사이 수열

import java.util.Arrays;
import java.util.Scanner;

public class No1469 {
    static int N;
    static int[] numbers;
    static int[] sequence;
    static int[] used;
    static int[] firstIndex;
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];
        sequence = new int[2 * N];
        used = new int[17];
        firstIndex = new int[17];
        Arrays.fill(firstIndex, -1);

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        backtrack(0);

        if (!found) {
            System.out.println(-1);
        }
    }

    static boolean backtrack(int index) {
        if (index == 2 * N) {
            printSequence();
            return true;
        }

        for (int i = 0; i < N; i++) {
            int num = numbers[i];
            if (used[num] < 2) {
                if (used[num] == 0 || (index - firstIndex[num] == num + 1)) {
                    sequence[index] = num;
                    used[num]++;
                    if (used[num] == 1) {
                        firstIndex[num] = index;
                    }

                    if (backtrack(index + 1)) {
                        return true;
                    }

                    used[num]--;
                    if (used[num] == 0) {
                        firstIndex[num] = -1;
                    }
                }
            }
        }
        return false;
    }


    static void printSequence() {
        for (int i = 0; i < 2 * N; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
        found = true;
    }
}
