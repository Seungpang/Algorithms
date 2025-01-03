package BJ;
// 숫자 구슬

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No2613 {
    static int[] groupMarbleCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] marble = new int[N];
        groupMarbleCnt = new int[M];
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            marble[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, marble[i]);
            sum += marble[i];
        }

        int result = search(marble, min, sum, N, M);

        bw.write(String.valueOf(result));
        bw.newLine();

        for (int i = 0; i < M; i++) {
            bw.write(String.valueOf(groupMarbleCnt[i]));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static int search(int[] marble, int min, int sum, int N, int M) {
        int left = min;
        int right = sum;

        while (left < right) {
            int mid = (left + right) / 2;
            if (marbleCheck(marble, mid, N, M)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean marbleCheck(int[] marble, int mid, int N, int M) {
        int gCnt = 1;
        int mCnt = 0;
        int sum = 0;
        int[] marbleCnt = new int[M];

        for (int i = 0; i < N; i++) {
            if (gCnt > M || marble[i] > mid) {
                return false;
            }

            if (sum + marble[i] > mid || N - i <= M - gCnt) {
                marbleCnt[gCnt - 1] = mCnt;
                gCnt++;
                mCnt = 1;
                sum = marble[i];
            } else {
                mCnt++;
                sum += marble[i];
            }
        }

        if (gCnt > M) {
            return false;
        }

        marbleCnt[gCnt - 1] = mCnt;
        System.arraycopy(marbleCnt, 0, groupMarbleCnt, 0, M);
        return true;
    }
}
