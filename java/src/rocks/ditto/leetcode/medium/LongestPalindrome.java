package src.rocks.ditto.leetcode.medium;

/**
 * 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        int length = s.length();
        String res = "";
        /**
         * 动态规划： s[i:j] = s[i]==s[j] 和 s[i+1][j-1]
         */
        boolean[][] dp = new boolean[length][length];
        for (int l = 0; l < length; ++l) {
            for (int i = 0; i + l < length; ++i) {
                int j = i + l;
                if (l == 0){
                    dp[i][j] = true;
                } else if (l == 1){
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }
                if (dp[i][j]){
                    String tmp = s.substring(i,j + 1);
                    if (res.length() < tmp.length()){
                        res = tmp;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("cabab"));
    }
}
