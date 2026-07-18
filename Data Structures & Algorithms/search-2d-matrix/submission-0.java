class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i=0;i<n;i++) {
            if (target >= matrix[i][0] && target <= matrix[i][m-1]) {
                return findTarget(matrix[i], target);
            } else {
                continue;
            }
        }

        return false;
    }

    private boolean findTarget(int[] row, int target) {
        int low = 0, high = row.length;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (row[mid] == target) {
                return true;
            }
            if (target > row[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
