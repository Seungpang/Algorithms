package StringAndArray;

public class LicenseKeyFormatting {
    public static void main(String[] args) {
        String str = "8F3Z-2e-9-wabcdef";
        //String str = "8-5g-3-3";

        int k = 4;
        solution(str, k);
        System.out.println(solution(str, k));
    }

    public static StringBuilder solution(String str, int k) {
        String newStr = str.replace("-", "");

        newStr = newStr.toUpperCase();

        int leng = newStr.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<leng; i++){
            sb.append(newStr.charAt(i));
        }

        for(int i=k; i<leng; i=i+k){
            sb.insert(leng-i, '-');
        }

        return sb;
    }
}
