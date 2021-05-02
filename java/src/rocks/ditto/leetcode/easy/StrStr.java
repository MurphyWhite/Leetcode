package src.rocks.ditto.leetcode.easy;

import java.util.Arrays;

/**
 * strStr函数
 * https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrStr {

    /**
     * kmp算法
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        int[] next = new int[needle.length()];

        getNext(next, needle);

        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return ( i - needle.length() + 1);
            }
        }
        return -1;
    }

    /**
     * 获取前缀数组
     *
     * @param next 前缀数组
     * @param s    入参字符串
     */
    private void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

    public static void main(String[] args) {
        StrStr solution = new StrStr();
        solution.strStr("", "aab");
    }


}
