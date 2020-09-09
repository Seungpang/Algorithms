package Hackerrank;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        int hour = Integer.parseInt(s.substring(0,2));
        String timeFormat = s.substring(2,8);

        if(hour == 12 && s.indexOf("AM") != -1){
            return ("00" + timeFormat);
        }

        if(hour == 12 && s.indexOf("PM") != -1){
            return (hour + timeFormat);
        }

        if(hour < 12 && s.indexOf("PM") != -1){
            return(12+hour+timeFormat);
        } else{
            if(hour<10){
                return("0"+hour+timeFormat);
            } else{
                return(hour + timeFormat);
            }
        }

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
