package array;

public class 删除排序数组中的重复项 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int newNumPos = 0;
        int modifyPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i == 0){
                continue;
            }
            if (nums[i] != nums[newNumPos]) {
                modifyPos++;
                nums[modifyPos] = nums[i];
                newNumPos = i;
            }
        }
        return modifyPos+1;
    }
}
