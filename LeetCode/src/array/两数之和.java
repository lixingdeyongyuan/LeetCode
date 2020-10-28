package array;

import java.util.Arrays;
import java.util.HashMap;

public class 两数之和 {

    public static void main(String[] args) {
        twoSum(new int[]{4, 4, 2, 15},8);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] pos = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int haha = target - nums[i];
            if(hashMap.containsKey(haha)){
                pos[0] = i;
                pos[1] = hashMap.get(haha);
            } else {
                hashMap.put(nums[i],i);
            }
        }
        System.out.println(Arrays.toString(pos));
        return pos;
    }
}
