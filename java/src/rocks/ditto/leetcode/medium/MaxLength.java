package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1239. 串联字符串的最大长度
 * https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 */
public class MaxLength {

    // 官方解法，枚举所有的可能性
    public int maxLength(List<String> arr){
        int ans = 0;
        List<Integer> masks = new ArrayList<>();
        // 添加一个空串
        masks.add(0);
        for (String s : arr){
            int mask = 0;
            for (int i=0; i<s.length(); i++){
                int ch = s.charAt(i) - 'a';
                // 先判断字符串自身有没有重复
                // 有重复
                if ((mask >> ch & 1) == 1){
                    mask = 0;
                    break;
                }
                // 没重复
                mask |= 1 << ch;
            }
            if (mask == 0){
                continue;
            }
            int n = masks.size();
            // 尝试拼接现有的
            for (int i=0; i<n; i++){
                int m = masks.get(i);
                // 可以拼接
                if ((mask & m) == 0){
                    masks.add(mask | m);
                    // 取最大
                    ans = Math.max(ans, Integer.bitCount(mask | m));
                }
            }
        }
        return ans;
    }


    // 宫水三叶的dfs解法
    static Map<Integer, Integer> map = new HashMap<>();

    private int get(int cur){
        if (map.containsKey(cur)){
            return map.get(cur);
        }
        int ans = 0;
        for (int i = cur; i>0; i -= lowbit(i)){
            ans++;
        }
        map.put(cur, ans);
        return ans;
    }

    private int lowbit(int x){
        return x & -x;
    }

    int n;
    int ans = Integer.MIN_VALUE;
    int[] hash;

//    public int maxLengthDfs(List<String> arr){
//
//    }
}
