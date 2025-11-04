import java.util.*;

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int num = left; num <= right; num++) {
            if (isSelfDividing(num)) {
                result.add(num);
            }
        }

        return result;
    }

    private boolean isSelfDividing(int num) {
        int n = num;
        while (num > 0) {
            int digit = num % 10;
            if (digit == 0 || n % digit != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
