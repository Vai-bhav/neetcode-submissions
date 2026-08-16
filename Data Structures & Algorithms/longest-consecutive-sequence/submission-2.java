class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int max = 0;
        for (int ele: set) {
            int temp = 1;
            int num = ele;
            if (!set.contains(num-1)) {
                while(set.contains(num+1)) {
                    temp++;
                    num++;
                }

                max = Math.max(temp, max);
            }
        }

        return max;
    }
}
