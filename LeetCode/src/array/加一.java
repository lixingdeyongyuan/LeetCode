package array;

import java.util.Arrays;

public class 加一 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{2})));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int ret = digits[i] + 1;
            if (ret > 9) {
                digits[i] = 0;
            } else {
                digits[i] = ret;
                break;
            }
        }
        // 这里也不好，每次结束都要判断
        if (digits[0] == 0) {
            int[] tmp = new int[digits.length + 1];
            tmp[0] = 1;
            // TODO 这里不对，当首项为0的时候，其余各位也一定为0
            System.arraycopy(digits, 0, tmp, 1, digits.length);
            return tmp;
        }
        return digits;
    }

    // 正确答案
    public static int[] plusOne1(int[] digits) {
        int len = digits.length;
        for(int i = len - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if(digits[i]!=0)
                return digits;
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}
