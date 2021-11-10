package BJ;
//BST
//듣보잡

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class No1764 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        while (n-- > 0) {
            String name = sc.next();
            set.add(name);
        }

        while (m-- > 0) {
            String name = sc.next();
            if (set.contains(name)) {
                list.add(name);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
