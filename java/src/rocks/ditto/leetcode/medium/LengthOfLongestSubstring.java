package src.rocks.ditto.leetcode.medium;


/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        //        HashMap<Character, Integer> unique = new HashMap<>();
        // 只有符号，数字，英文，空格，改用数组
        int[] unique = new int[128];

        int maxLength = 0;

        int left = 0;
        int right = 0;

        /**
         * @TODO 优化逻辑，改成缓存字母最后出现位置，快速移动left指针，减少循环
         */

        while (right < s.length()) {
            char ch = s.charAt(right);
            unique[ch]++;
            ++right;
            // 判断这个串是否符合条件，不符合时，left加一，缩小窗口
            while (unique[ch] > 1) {
                char removeCh = s.charAt(left);
                unique[removeCh]--;
                left++;
            }

            if (maxLength < right - left){
                maxLength = right - left;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(s));
    }
}
