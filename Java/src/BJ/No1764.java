package BJ;
//BST
//듣보잡

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class No1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        while (n-- > 0) {
            String name = br.readLine();
            set.add(name);
        }

        while (m-- > 0) {
            String name = br.readLine();
            if (set.contains(name)) {
                list.add(name);
            }
        }

        System.out.println(list.size());
        Collections.sort(list);
        list.forEach(System.out::println);
    }
}
