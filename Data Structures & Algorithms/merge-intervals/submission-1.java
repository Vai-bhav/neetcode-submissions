class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i=1;i<n;i++) {
            int[] lastEle = res.get(res.size() - 1);
            if (lastEle[1] >= intervals[i][0]) {
                int min = Math.min(lastEle[0], intervals[i][0]);
                int max = Math.max(lastEle[1], intervals[i][1]);

                res.remove(res.size()-1);
                res.add(new int[]{min, max});
            } else {
                res.add(intervals[i]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
