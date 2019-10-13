package Hash;

import java.util.HashMap;

public class Camouflage {
    public static void main(String[] args) {
        Camouflage sol = new Camouflage();

        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(sol.solution(clothes));
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        for(int i=0; i<clothes.length; i++){
            String key = clothes[i][1];
            int count = 1;
            if(hashMap.containsKey(key)){
                count = hashMap.get(key) + 1;
            }

            hashMap.put(key, count);
        }

        int answer = 1;
        for(String key:hashMap.keySet()){
            answer *= (hashMap.get(key)+1);
        }

        return answer - 1;

    }
}
