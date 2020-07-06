package StringAndArray;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        int[] A = { 11, 27, 45, 31, 50};
        int[] B = { 50, 11, 31, 45, 27};
        int[] result = anagramMappings(A, B);
        print(result);
    }

    public static int[] anagramMappings(int[] A, int[] B){
        int[] result = new int[A.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<A.length; i++){
            map.put(B[i],i);
        }

        for(int i=0; i<A.length; i++){
            result[i] = map.get(A[i]);
        }

        return result;
    }

    public static void print(int[] result){
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
