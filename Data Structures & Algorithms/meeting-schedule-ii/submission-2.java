/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() < 2) {
            return intervals.size();
        }
        intervals.sort((a,b)-> {
            if (a.start == b.start) {
                return a.end - b.end;
            } else {
                return a.start - b.start;
            }
        });
        for (Interval i: intervals) {
            System.out.println(i.start + " "+ i.end);
        }
        System.out.println(" -- -- ");

        return count(intervals);
    }

    private int count(List<Interval> intervals) {
        List<Interval> tem = new ArrayList();
        int prevEnd = intervals.get(0).end;
        for(int i = 0 ; i < intervals.size() -1; i++) {
            if (prevEnd > intervals.get(i+1).start) {
                tem.add(intervals.get(i+1));
            } else {
                prevEnd = Math.max(prevEnd, intervals.get(i+1).end);
            }
        }
        
        
        for (Interval i: tem) {
            System.out.println("tem " + i.start + " "+ i.end);
        }
        
        if (tem.size() > 0) {
            return count(tem) + 1;
        }
        return 1;
    }
}
