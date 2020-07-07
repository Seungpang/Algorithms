package StringAndArray;
import java.util.*;

public class K번째수 {
    public static void main(String[] args) {
        K번째수 sol = new K번째수();

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands ={{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};


        System.out.print(sol.solution(array, commands));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int k = 0;
        for(int[] command : commands){
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i = command[0]-1 ; i < command[1] ; i++){
                arr.add(array[i]);
            }
            Collections.sort(arr);
            answer[k++] = arr.get(command[2]-1);
        }
        return answer;
    }
}
