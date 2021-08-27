package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;

/**
 * 881. 救生艇
 * https://leetcode-cn.com/problems/boats-to-save-people/
 */
public class NumRescueBoats {

    public int numRescueBoats(int[] people, int limit) {
        // 体重排序
        Arrays.sort(people);
        int boats = 0;
        // 按照贪心算法来说，1大一小尝试是合理的
        int left = 0, right = people.length - 1;
        while (left <= right){
            if (people[left] + people[right] < limit){
                left++;
                right--;
                boats++;
            } else {
                right--;
                boats++;
            }
        }
        return boats;
    }
}
