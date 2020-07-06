package src.Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Interval{
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e;}
}

public class MergeInterval{
    public static void main(String[] args) {
        Interval in2 = new Interval(1, 3);
        Interval in1 = new Interval(2,6);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        MergeInterval a = new MergeInterval();
        List<Interval> list = a.merge(intervals);

        a.print(list);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) return  intervals;

        //1
        List<Interval> result = new ArrayList<>();

        print(intervals);
        Collections.sort(intervals, (a,b) -> a.start-b.start);
        System.out.println("=======");
        print(intervals);

        //2
        Interval before = intervals.get(0);//[1, 3]
        for(int i=1; i<intervals.size(); i++) {
            Interval current = intervals.get(i);
            if(before.end >= current.start){
                before.end = Math.max(before.end, current.end);
            } else {
                result.add(before);
                before = current;
            }
        }

        if(!result.contains(before)){
            result.add(before);
        }

        return result;
    }

    void print(List<Interval> list) {
        for(int i=0; i<list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start+" "+in.end);
        }
    }
}