package array;

import java.util.Arrays;

public class 合并两个有序数组 {

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[index1] > nums2[index2]) {
                nums1[i] = nums2[index2];
                index2++;
                if (index2 >= n) {
                    break;
                }
            } else {
                index1++;
                if (index1 >= m) {
                    if (index2 < n) {

                        nums1[i] = nums2[index2];
                        index2++;
                    }
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(nums1));
    }
}
