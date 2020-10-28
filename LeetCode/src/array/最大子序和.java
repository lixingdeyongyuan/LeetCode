package array;

public class 最大子序和 {
    public static void main(String[] args) {

    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int startPos = 0;
        int endPos = 0;
        int bigNumPos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] >= 0) {
                startPos = i - 1;
                if(nums[i] >= 0){
                    startPos = i;
                } else {
                    if (nums[i - 1] + nums[i] >= 0){

                    } else {
                        // 就是说当前这个nums[i]不能加到下一个位置
                    }
                }
            } else {
                if (nums[i] >= 0) {
                    startPos = i;
                } else {
                    // 全是负数
                    if (nums[bigNumPos] < nums[i]) {
                        bigNumPos = i;
                    } else {
                        bigNumPos = i - 1;
                    }
                }
            }


        }
        return startPos;
    }
}
