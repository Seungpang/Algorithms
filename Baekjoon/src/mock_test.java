import java.util.ArrayList;
import java.util.List;

public class mock_test {
    public int[] solution(int[] answers) {
        int[] supoja1 = {1, 2, 3, 4, 5};
        int[] supoja2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] supoja3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[]{0, 0, 0};
        int maxNum = 0;
        List<Integer> countNum = new ArrayList<>();

        for(int i=0; i< answers.length; i++){
            if(answers[i] == supoja1[i % 5]){
                answer[0]++;
            }
            if(answers[i] == supoja2[i % 8]){
                answer[1]++;
            }
            if(answers[i] == supoja3[i % 10]){
                answer[2]++;
            }

        }

        for(int i : answer) {
            if(i > maxNum){
                maxNum = i;
            }
        }

        for(int i=0; i < 3; i++){
            if(answer[i] == maxNum){
                countNum.add(i+1);
            }
        }
        return countNum.stream().mapToInt(i->i).toArray();
    }
}
