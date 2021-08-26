package src.rocks.ditto.leetcode.easy;

/**
 * 541. 反转字符串 II
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class ReverseStrII {

    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int n = s.length();
        for (int l = 0; l < n; l = l + 2 * k){
            int r = l + k - 1;
            // 如果最后不够k，就将剩余的都反转
            reverse(chs, l, Math.min(r, n - 1));
        }
        return String.valueOf(chs);
    }

    private void reverse(char[] cs, int l, int r){

        // 将l到r的字母反转
        while ( l < r){
            char temp = cs[l];
            cs[l] = cs[r];
            cs[r] = temp;
            l++;
            r--;
        }
    }
}
