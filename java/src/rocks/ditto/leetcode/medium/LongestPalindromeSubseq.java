package src.rocks.ditto.leetcode.medium;

/**
 * 516. 最长回文子序列
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        // 动态规划
        int[][] dp = new int[n][n];
        int ans = 0;
        // 回文字符串长度
        for (int len = 1; len <= n; len++) {
            // 回文字符串开始位置
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;
                if (len == 1) {
                    dp[l][r] = 1;
                } else if (len == 2) {
                    dp[l][r] = ch[l] == ch[r] ? 2 : 1;
                } else {
                    // 判断几种情况哪种回文字符串长度比较大
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                    // 如果ch[l] == ch[r], 长度可以加2
                    dp[l][r] = Math.max(dp[l][r], ch[l] == ch[r] ? dp[l + 1][r - 1] + 2 : 0);
                }
            }
        }
        return dp[0][n - 1];
    }
}
