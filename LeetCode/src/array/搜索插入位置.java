package array;

public class 搜索插入位置 {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3,5}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] >= target) {
                return 0;
            } else {
                return 1;
            }
        }
        int startPos = 0;
        int endPos = nums.length - 1;
        int middlePos = 0;
        while (startPos <= endPos) {
            middlePos = (startPos + endPos) / 2;
            if (nums[middlePos] == target) {
                return middlePos;
            } else if (nums[middlePos] > target) {
                endPos = middlePos - 1;
            } else {
                startPos = middlePos + 1;
            }
        }
        return startPos;
    }
}
