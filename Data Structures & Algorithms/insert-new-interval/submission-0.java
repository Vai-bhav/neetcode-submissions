class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i = 0;
        List<int[]> res = new ArrayList<>();

        while(i<n && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        res.add(newInterval);

        while(i<n) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}

// in = [[1,3],[4,6]], ni = [2,5]

// ni[0] <= in[1]
// i = 0
// [1, 5]

// i = 1
// [1, 6]

// intervals = [[1,2],[3,5],[9,10]], newInterval = [6,7]

// [1,2],[3, 5], [6, 7], [9, 10]

