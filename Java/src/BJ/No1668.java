package BJ;
//트로피 진열

import java.util.Scanner;

public class No1668 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] trophies = new int[N];

        for (int i = 0; i < N; i++) {
            trophies[i] = sc.nextInt();
        }

        System.out.println(countVisibleTrophies(trophies));
        System.out.println(countVisibleTrophies(reverse(trophies)));
    }

    private static int countVisibleTrophies(int[] trophies) {
        int count = 0;
        int maxHeight = 0;

        for (int height : trophies) {
            if (height > maxHeight) {
                maxHeight = height;
                count++;
            }
        }

        return count;
    }

    private static int[] reverse(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }
}
