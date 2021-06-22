package src.rocks.ditto.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 回溯算法模版
 */
public class Permutation {

    // 用于去重
    private Set<String> result = new HashSet<>();

    // s的长度 1 <= N <= 8
    private boolean[] used = new boolean[10];

    public String[] permutation(String s) {
        int length = s.length();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        dfs(chars, 0, length, "");
        return result.toArray(new String[0]);
    }

    private void dfs(char[] chs, int cur, int target, String curStr){
        if (cur == target){
            result.add(curStr);
            return;
        }

        for (int i = 0; i < chs.length; i++){
            if (!used[i]) {
                // 尝试ch[i]
                used[i] = true;
                // 递归
                dfs(chs, cur + 1, target, curStr + chs[i]);
                // 回溯
                used[i] = false;
            }
        }
    }
}
