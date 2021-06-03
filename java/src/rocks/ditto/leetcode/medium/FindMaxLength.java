package src.rocks.ditto.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * https://leetcode-cn.com/problems/contiguous-array/
 */
public class FindMaxLength {

    public int findMaxLength(int[] nums) {
        // 前缀和
        int n = nums.length;
        int[] sum = new int[n+1];
        // 当前和
        int counter = 0;
        for (int i=1; i<=n; i++){
            // 当前是1，就加一
            if (nums[i-1]==1){
                counter++;
            } else {
                // 当前是0，减一处理
                counter--;
            }
            sum[i] = counter;
        }
        // key是前缀和，value是下标值
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int ans = 0;
        for (int i=2; i<=n; i++){
            // 如果没有一样的前缀和，就放进map，要保证map里当前和是数字标号最小，保证数组最长
            if (!map.containsKey(sum[i-2])){
                map.put(sum[i-2], i-2);
            }
            // 如果有前缀和的话，判断是不是最长
            // 数组
            if (map.containsKey(sum[i])) {
                ans = Math.max(ans, i - map.get(sum[i]));
            }
        }
        return ans;
    }
}
