//package Programmers;
//
//import java.util.*;
//
//public class 두_개_뽑아서_더하기 {
//
//    public static void main(String[] args) {
//        두_개_뽑아서_더하기 a = new 두_개_뽑아서_더하기();
//        int[] numbers = {2, 1, 3, 4, 1};
//        int[] b = a.solution(numbers);
//        for (int i = 0; i < numbers.length; i++) {
//            System.out.printf("%d, ", b[i]);
//        }
//    }
//
//    public int[] solution(int[] numbers) {
//        List<Integer> list = new ArrayList<Integer>();
//        int[] temp = new int[100];
//        int count = 0;
//
//        for (int i = 0; i < numbers.length; i++) {
//            for (int j = i + 1; j < numbers.length; j++) {
//                temp[count++] = numbers[i] + numbers[j];
//
////                if (list.indexOf(tmp) < 0) {
////                    list.add(tmp);
////                }
//            }
//        }
//        for (int i = 0; i < temp.length; i++) {
//            for (int j = i + 1; j < temp.length; j++) {
//                if ()
//            }
//        }
//
//        int[] answer = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            answer[i] = list.get(i);
//        }
//        Arrays.sort(answer);
//
//        Arrays.sort(temp);
//        return temp;
//    }
//}
//
//
//
///*        Set<Integer> set = new HashSet<>();
//
//        for(int i=0; i<numbers.length; i++) {
//            for(int j=i+1; j<numbers.length; j++) {
//                set.add(numbers[i] + numbers[j]);
//            }
//        }
//
//        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
//    }*/
//
