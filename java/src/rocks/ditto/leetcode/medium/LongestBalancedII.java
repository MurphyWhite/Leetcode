package src.rocks.ditto.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 3714. Longest Balanced Substring II
 * https://leetcode.cn/problems/longest-balanced-substring-ii/description/?envType=daily-question&envId=2026-02-13
 * 给你一个只包含字符 'a'、'b' 和 'c' 的字符串 s。
 */
public class LongestBalancedII {
    public int longestBalancedII(String s) {
        int length = s.length();
        int res = 0;

        // 第一种情况, 最长字段仅包含一种字符
        // 单字符持续长度
        int last = 0;
        for (int i = 0; i < length; i++){
            if (i > 0 && s.charAt(i) == s.charAt(i-1)) {
                last++;
            } else {
                // 不相等时，把上一个长度计入res中，并重置当前计数器
                last = 1;
            }
            res = Math.max(res, last);
        }

        // 第二种情况，最长字段包含两种字符
        res = Math.max(res, longestWithTwo(s, 'a', 'b'));
        res = Math.max(res, longestWithTwo(s, 'a', 'c'));
        res = Math.max(res, longestWithTwo(s, 'b', 'c'));

        // 第三种情况，最长字段包含三种字符
        Map<String, Integer> h = new HashMap<>();
        h.put(length + "+" + length, -1);

        //  b - a 数量
        int diffAB = 0;
        //  c - b 数量
        int diffBC = 0;
        for (int i =0; i < length; i++){
            char c = s.charAt(i);
            // 多一个a，差值减一
            if ( c == 'a') {
                diffAB--;
            } else if ( c == 'b'){
                diffAB++;
                diffBC--;
            } else {
                diffBC++;
            }
            String key = (diffAB +length) + "+" + (diffBC + length);
            Integer pre = h.get(key);
            // 如果前面有相同diff的位置，代表只需要取[pre...i]即可获取一个平衡串
            if (pre != null){
                res = Math.max(res, i - pre);
            } // 没有的话就将当前位置放入数组
            else {
                h.put(key, i);
            }
        }

        System.out.println(res);
        return res;
    }

    private int longestWithTwo(String s, char first, char second){
        int length = s.length();
        int res = 0;
        for (int i = 0; i < length; i++){
            if (s.charAt(i) != first && s.charAt(i) != second){
                // 不属于这两个
                continue;
            }
            // s[i] 是用来储存0到i位置上最长的结果
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, i-1);// 0, -1
            int diff = 0;
            int j = i;
            while (j < length && (s.charAt(j) == first || s.charAt(j) == second)){
                // 当前的差别是多少
                diff += (s.charAt(j) == first) ? 1:-1;

                Integer prev = map.get(diff);
                if (prev != null){
                    res = Math.max(res, j - prev);
                } else {
                    map.put(diff, j);
                }
                j++;
            }
            // 如果
            i = j - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestBalancedII solution = new LongestBalancedII();

        int ret = solution.longestBalancedII("abccccccc");
        ret = solution.longestBalancedII("ccababccc");
        ret = solution.longestBalancedII("ccababcab");
    }
}
