package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointstoOrigin {
    public static void main(String[] args) {
        KClosestPointstoOrigin a = new KClosestPointstoOrigin();
        int[][] points = {{1,3},{-2,2}};
        int k = 1;

        int[][] result = a.solution(points, k);
        a.print(result);
    }

    public int[][] solution(int[][] points, int k){
        Queue<int[]> queue = new PriorityQueue<>(points.length, Comp);
        int[][] result = new int[k][2];
        int index = 0;

        for(int[] p: points){
            queue.offer(p);
        }
        while (index<k){
            result[index] = queue.poll();
            index++;
        }
        return result;
    }

    Comparator<int[]> Comp = (a, b) -> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]);

    public void print(int[][] result){
        int m = result.length;
        int n = result[0].length;

        for(int i=0; i<result.length; i++){
            for(int j=0; j<result[i].length; j++){
                System.out.println(result[i][j]);
            }
        }
    }
}
