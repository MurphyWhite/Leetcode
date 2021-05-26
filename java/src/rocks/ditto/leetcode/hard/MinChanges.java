package src.rocks.ditto.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1787. 使所有区间的异或结果为零
 * https://leetcode-cn.com/problems/make-the-xor-of-all-segments-equal-to-zero/
 * @TODO learn more
 */
public class MinChanges {

    public int minChanges(int[] nums, int k) {
        // 状态转移方程
        // nums[i] = nums[i+k]
        // 1. 假设区间 [i, j] 长度为 k，其异或结果为0。即
        // nums[i] ⊕ nums[i + 1] ⊕ ... ⊕ nums[j] = 0nums[i]⊕nums[i+1]⊕...⊕nums[j]=0
        // 2. 长度不变，将区间整体往后移动一位 [i + 1, j + 1][i+1,j+1]，其异或结果为 0
        // 即 nums[i + 1] ⊕ ... ⊕ nums[j] ⊕ nums[j + 1] = 0nums[i+1]⊕...⊕nums[j]⊕nums[j+1]=0
        // 3. 两式结合，中间[i+1,j] 区间的数值出现两次，抵消掉最终剩下
        // nums[i] ⊕ nums[j + 1] = 0nums[i]⊕nums[j+1]=0，即推出nums[i]必然等于num[j + 1]

        /**
         * 数组必然是每k个一组进行重复
         */
        int n = nums.length;
        int max = 1024;
        int[][] f = new int[k][max];
        int[] g = new int[k];
        for (int i=0; i < k ; i++){
            Arrays.fill(f[i], 0x3f3f3f3f);
            // 0x3f3f3f3f 是一个比较大的数，加上另一个0x3f3f3f3f也不会溢出
            // 可以用 Integer.MAX_VALUE/2代替亦可
            g[i] = 0x3f3f3f3f;
        }
        for (int i=0, cnt=0; i<k ; i++, cnt = 0){
            Map<Integer, Integer> map = new HashMap<>();
            for (int j=i; j<n; j+=k){
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                cnt++;
            }
            if (i==0) {
                // 第0列，考虑如何将该列变为xor即可
                for (int xor = 0; xor < max; xor++) {
                    f[0][xor] = Math.min(f[0][xor], cnt - map.getOrDefault(xor, 0));
                    g[0] = Math.min(g[0], f[0][xor]);
                }
            } else {
                // 其他列：考虑与前面列的关系
                for (int xor=0; xor < max; xor++){
                    f[i][xor] = g[i-1] + cnt; //整列替换
                    for (int cur : map.keySet()) {
                        // 部分替换
                        f[i][xor] = Math.min(f[i][xor], f[i-1][xor ^ cur] + cnt - map.get(cur));
                    }
                    g[i] = Math.min(g[i], f[i][xor]);
                }
            }
        }
        return f[k-1][0];
    }
}
