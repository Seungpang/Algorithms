package Programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Lv2_다리를_지나는_트럭 {

    public static void main(String[] args) {
        Lv2_다리를_지나는_트럭 a = new Lv2_다리를_지나는_트럭();

        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        System.out.println(a.solution(bridge_length,weight,truck_weights));
    }


    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int truckSum = 0;
        int idx = 0;

        while (true) {
            if (idx == truck_weights.length) break;

            if (queue.size() == bridge_length) {
                truckSum -= queue.poll();
            } else if(truckSum + truck_weights[idx] > weight) {
                queue.offer(0);
                answer++;
            } else {
                queue.offer(truck_weights[idx]);
                truckSum += truck_weights[idx];
                answer++;
                idx++;
            }
        }
        return answer + bridge_length;
    }
}
