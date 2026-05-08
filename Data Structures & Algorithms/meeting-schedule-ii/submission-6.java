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
        intervals.sort((a,b) -> a.start-b.start);
        Queue<Integer> q = new PriorityQueue<>();
        q.offer(intervals.get(0).end);

        for(int i = 1 ; i < intervals.size(); i++) {
            if (intervals.get(i).start >= q.peek()) {
                q.poll();
            }
            q.offer(intervals.get(i).end);
        }
        return q.size();

    }
    //     if(intervals.size() < 2) {
    //         return intervals.size();
    //     }
    //     intervals.sort((a,b)-> {
    //         if (a.start == b.start) {
    //             return a.end - b.end;
    //         } else {
    //             return a.start - b.start;
    //         }
    //     });

    //     return count(intervals);
    // }

    // private int count(List<Interval> intervals) {
    //     List<Interval> tem = new ArrayList();
    //     int prevEnd = intervals.get(0).end;
    //     for(int i = 0 ; i < intervals.size() -1; i++) {
    //         if (prevEnd > intervals.get(i+1).start) {
    //             tem.add(intervals.get(i+1));
    //         } else {
    //             prevEnd = Math.max(prevEnd, intervals.get(i+1).end);
    //         }
    //     }
        
    //     if (tem.size() > 0) {
    //         return count(tem) + 1;
    //     }
    //     return 1;
    // }
}
