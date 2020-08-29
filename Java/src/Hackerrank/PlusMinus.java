package Hackerrank;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class PlusMinus {
    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        double size = arr.length;
        int plusCount = 0;
        int minusCount = 0;
        int zeroCount = 0;

        for(int i=0; i<size; i++){
            if(arr[i] > 0){
                plusCount++;
            } else if(arr[i]<0){
                minusCount++;
            } else{
                zeroCount++;
            }
        }
        System.out.printf("%.6f\n",plusCount/size);
        System.out.printf("%.6f\n",minusCount/size);
        System.out.printf("%.6f\n",zeroCount/size);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }

}
