class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i>=0;i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        if (digits[0] == 0) {
            int res[] = new int[n+1];
            res[0] = 1;
            for (int i = 0;i<n;i++) res[i+1] = digits[i];

            return res;
        }

        return new int[]{};
    }
}

// 1 2 3 4
// 1
// last digit != 9 -> add and return

// 1, 9, 9
// 1
// digit = 9 -> 0
// digit = 9 -> 0
// 1 -> 2

// 9, 9, 9
// digit = 9 -> 0
// digit = 9 -> 0
// digit = 9 -> 0
// 1st digit = 0
// add 1, 0, 0, 0
