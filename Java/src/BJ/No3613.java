package BJ;
// Java vs C++

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class No3613 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String lowerCase = "(?:_([a-z]))", upperCase = "([A-Z])";
        if (str.matches(".*[A-Z].*") && str.matches(".*_.*") || str.matches(".*(_){2,}.*|^([A-Z]|_).*|.*(_)$")
                || str.equals("")) {
            System.out.println("Error!");
        } else {
            Matcher matcher;
            if(str.contains("_")) {
                matcher = Pattern.compile(lowerCase).matcher(str);
                while(matcher.find()) {
                    str = str.replace(matcher.group(), matcher.group(1).toUpperCase());
                }
            } else if(str.matches(".*([A-Z]).*")) {
                matcher = Pattern.compile(upperCase).matcher(str);
                while (matcher.find()) {
                    str = str.replace(matcher.group(), "_" + matcher.group().toLowerCase());
                }
            }
            System.out.println(str);
        }
    }
}
