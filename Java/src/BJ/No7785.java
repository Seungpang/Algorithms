package BJ;
//BST
//회사에 있는 사람

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class No7785 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        sc.nextLine();
        while (n-- > 0) {
            String[] temp = sc.nextLine().split(" ");
            if (temp[1].equals("enter")) {
                set.add(temp[0]);
            } else {
                set.remove(temp[0]);
            }
        }

        String[] a = set.toArray(new String[set.size()]);
        Arrays.sort(a);
        for (int i = a.length - 1; i >= 0; i--) {
            System.out.println(a[i]);
        }
    }
}
