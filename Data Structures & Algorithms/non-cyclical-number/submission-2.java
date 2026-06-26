class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();

        while(n != 1) {
            n = getNumber(n);
            if (set.contains(n)) return false;

            set.add(n);
        }

        return true;
    }

    private int getNumber(int n) {
        int sum = 0;
        while(n>0) {
            int num = n % 10;
            sum += (num * num);
            n /= 10;
        }

        return sum;
    }
}

// 7 = 7*7 = 49
// 49 = 16+81 = 97
// 97 = 81+49 = 130
// 130 = 1+9+0 = 10
// 10 = 1+0 = 1

// 101 = 1*1+0*0+1*1 = 2
// 2 = 2*2 = 4
// 4 = 4*4 =16
// 16 = 1*1+6*6 = 37
// 37 = 9+49 = 58
// 58 = 25+64 = 89
// 89 = 64+81 = 145
// 145 = 1+16+25 = 42
// 42 = 28
// 28 = 4

