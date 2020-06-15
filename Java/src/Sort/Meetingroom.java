package Sort;

import java.util.Arrays;
import java.util.Comparator;

class Interval{

    int start;
    int end;

    Interval(){
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
public class Meetingroom {
    public static void main(String[] args) {
        Meetingroom a = new Meetingroom();

        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5, 10);
        Interval in3 = new Interval(0, 30);

        Interval[] intervals = {in1, in2, in3};
        System.out.println(a.solve(intervals));
    }

    public boolean solve(Interval[] intervals){
        if(intervals == null)
            return false;
        Arrays.sort(intervals, Comp);

        for(int i=1; i<intervals.length; i++){
            if(intervals[i-1].end> intervals[i].start){
                return false;
            }
        }
        return true;
    }

    Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start - o2.start;
        }
    };
}
