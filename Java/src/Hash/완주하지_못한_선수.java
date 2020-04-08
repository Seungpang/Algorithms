package Hash;

import java.util.Arrays;

public class 완주하지_못한_선수 {
    public static void main(String[] args) {
        완주하지_못한_선수 sol = new 완주하지_못한_선수();
        String[] participant = {"leo", "kiki", "eden" };
        String[] completion = {"eden", "kiki"};

        System.out.println(sol.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion){
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[i];
    }
}
