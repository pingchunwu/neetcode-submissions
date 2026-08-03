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
        if (intervals.size() <= 1) return intervals.size();
        intervals.sort((a,b) -> a.start - b.start);
        List<Integer> ends = new ArrayList();
        for (int i = 0 ; i < intervals.size() ; i ++) {
            Interval interval = intervals.get(i);
            if (ends.size() < 1) {
                ends.add(interval.end);
            } else {
                int endSize = ends.size();
                boolean fit = false;
                for (int j = 0 ; j < endSize ; j++) {
                    if (ends.get(j) <= interval.start) {
                        ends.set(j, interval.end);
                        fit = true;
                        break;
                    }
                }
                if (!fit) {
                    ends.add(interval.end);
                }
            }
        }
        return ends.size();
    }
}
