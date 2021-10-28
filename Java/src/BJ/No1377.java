package BJ;
//정렬
//버블 소트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No1377 {

    static class Pair implements Comparable<Pair> {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }


        public int compareTo(Pair o) {
            if (this.first < o.first) {
                return -1;
            } else if (this.first == o.first) {
                if (this.second < o.second) {
                    return -1;
                } else if (this.second == o.second) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Pair[] a = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(a);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i].second - i > ans) {
                ans = a[i].second - i;
            }
        }
        System.out.println(ans + 1);
    }
}
