package BJ;
// 배

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class No1092 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> crane = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            crane.add(sc.nextInt());
        }

        int m = sc.nextInt();
        List<Integer> box = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            box.add(sc.nextInt());
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (box.get(0) > crane.get(0)) {
            System.out.println(-1);
            return;
        }

        int result = 0;
        while (!box.isEmpty()) {
            int idx = 0;
            int i = 0;
            while (n > i) {
                if (idx == box.size()) {
                    break;
                } else if (crane.get(i) >= box.get(idx)) {
                    box.remove(idx);
                    i++;
                } else {
                    idx++;
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
