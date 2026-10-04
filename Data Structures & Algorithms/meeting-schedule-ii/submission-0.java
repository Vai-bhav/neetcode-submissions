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
        int n = intervals.size();

        int[] startTime = new int[n];
        int[] endTime = new int[n];

        for (int i=0;i<n;i++) {
            startTime[i] = intervals.get(i).start;
            endTime[i] = intervals.get(i).end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int i=0, j=0, count=0, res = 0;

        while(i < n) {
            if (startTime[i] < endTime[j]) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
