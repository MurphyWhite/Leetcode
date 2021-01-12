package src.rocks.ditto.leetcode.easy;


import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        Map<Integer, Integer> dict = new HashMap<>();
        for (int i=0; i < nums.length; i++){
            int tmp = nums[i];
            if (dict.containsKey(tmp)){
                indexs[0] = dict.get(tmp);
                indexs[1] = i;
                return indexs;
            }
            dict.put(target - tmp, i);
        }
        return indexs;
    }
}
