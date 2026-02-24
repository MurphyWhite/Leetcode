package src.rocks.ditto.leetcode.easy;

import java.util.*;

/**
 * 1356. 根据数字二进制下 1 的数目排序
 * https://leetcode.cn/problems/sort-integers-by-the-number-of-1-bits/description/?envType=daily-question&envId=2026-02-25
 */
public class SortByBits {

    public int[] sortByBits(int[] arr) {
        // 预处理
        int[] bits = new int[10001];
        for (int i = 1; i < 10001; i++){
            // 看看末位是不是1
            bits[i] = bits[i>>1] + (i & 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int a : arr){
            list.add(a);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bits[o1] != bits[o2]){
                    return bits[o1] - bits[o2];
                }
                else {
                    return o1 - o2;
                }
            }
        });

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
