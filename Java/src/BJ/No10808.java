package BJ;

import java.util.Scanner;

public class No10808 {

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final String word = sc.nextLine();
        int arr[] = new int[27];
        for (int i = 0; i < word.length(); i++) {
            arr[word.charAt(i)] += 1;
        }

        for (int i = 1; i < 27; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
