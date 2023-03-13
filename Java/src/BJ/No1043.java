package BJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//거짓말
public class No1043 {

    static int[] parent;
    static int[] truePerson;
    static List<Integer>[] party;

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        truePerson = new int[t];
        int result = 0;
        for (int i = 0; i < t; i++) {
            truePerson[i] = sc.nextInt();
        }

        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            int partySize = sc.nextInt();
            for (int j = 0; j < partySize; j++) {
                party[i].add(sc.nextInt());
            }
        }

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int firstPeople = party[i].get(0);
            for (int j = 1; j < party[i].size(); j++) {
                union(firstPeople, party[i].get(j));
            }
        }

        for (int i = 0; i < m; i++) {
            boolean isPossible = true;
            int current = party[i].get(0);
            for (final int person : truePerson) {
                if (find(current) == find(person)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) result++;
        }
        System.out.println(result);
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }
}
