package tree;

import utils.TimeRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.function.Consumer;

/**
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 10^4
 */
public class 根据数字二进制下1的数目排序 {
    public static void main(String[] args) {
        TimeRecord.start();
        System.out.println(Arrays.toString(sortByBits0(new int[]{2,3,5,7,11,13,17,19})));
        TimeRecord.end();



        TimeRecord.start();
        System.out.println(Arrays.toString(sortByBits(new int[]{2,3,5,7,11,13,17,19})));
        TimeRecord.end();
    }

    public static int[] sortByBits0(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            /**
             *  Integer.bitCount
             *  很快速的获取1的数量
             */
            int oneSize = Integer.bitCount(value);
            /**
             * 小于10^4,乘以100000，实现整体排序
             */
            arr[i] = oneSize * 100000 + value;
        }
        /**
         * 双轴快排
         */
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] % 100000;
        }
        return arr;
    }

    public static int[] sortByBits(int[] arr) {
        LinkedHashMap<Integer,ArrayList<Integer>> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int value = arr[i];
            int oneSize = Integer.bitCount(value);
            if(map.containsKey(oneSize)){
                map.get(oneSize).add(value);
            } else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(value);
                map.put(oneSize,tmp);
            }

        }

        map.keySet().forEach(new Consumer<Integer>() {
            int index = 0;
            @Override
            public void accept(Integer integer) {
                ArrayList<Integer> tmp = map.get(integer);
                tmp.sort(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer integer, Integer t1) {
                        return integer - t1;
                    }
                });
                tmp.forEach(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) {
                        arr[index] = integer;
                        index++;
                    }
                });
            }
        });
        return arr;
    }
}
