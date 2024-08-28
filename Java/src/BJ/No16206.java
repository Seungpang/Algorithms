package BJ;
//롤케이크

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class No16206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> tensMultiples = new ArrayList<>();
        List<Integer> others = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cake = Integer.parseInt(st.nextToken());
            if (cake % 10 == 0) {
                tensMultiples.add(cake);
            } else {
                others.add(cake);
            }
        }

        Collections.sort(tensMultiples);
        Collections.sort(others, Collections.reverseOrder());

        int result = 0;
        int cuts = 0;

        // 10의 배수인 케이크 처리
        for (int cake : tensMultiples) {
            int pieces = cake / 10;
            if (cuts + pieces - 1 <= M) {
                result += pieces;
                cuts += pieces - 1;
            } else {
                result += M - cuts;
                cuts = M;
                break;
            }
        }

        // 10의 배수가 아닌 케이크 처리
        if (cuts < M) {
            for (int cake : others) {
                int pieces = cake / 10;
                if (cuts + pieces <= M) {
                    result += pieces;
                    cuts += pieces;
                } else {
                    result += M - cuts;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
