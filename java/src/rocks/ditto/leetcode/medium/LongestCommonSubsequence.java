package src.rocks.ditto.leetcode.medium;

/**
 * 1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        char[] c1 = text1.toCharArray(), c2 = text2.toCharArray();
        // dp[i][j]为 s1[0:i] 和 s2[0:j]的
        int dp[][] = new int[m+1][n+1];
        for(int i=0; i<m; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j<n; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i<=m; i++){
            for (int j=1; j<=n; j++){
                if (c1[i-1] == c2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
