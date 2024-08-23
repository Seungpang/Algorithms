package BJ;
// Contact

import java.util.Scanner;
import java.util.regex.Pattern;

public class No1013 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            String regex = "(100+1+|01)+";
            if (Pattern.matches(regex, s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
