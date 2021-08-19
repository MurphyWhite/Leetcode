package src.rocks.ditto.leetcode.easy;

/**
 *  345. 反转字符串中的元音字母
 *  https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 */
public class ReverseVowels {

    //元音字符
    private static final char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    // 用于判断字符是不是元音，题目中规定字符是ASCII，不只有字母
    private static final boolean[] hash = new boolean[128];

    static {
        for (char c : vowels){
            hash[c - ' '] = hash[Character.toUpperCase(c) - ' '] = true;
        }
    }

    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            // 如果都是元音
            if (hash[chars[left] - ' '] && !hash[chars[right] - ' ']){
                swap(chars, left, right);
            } else {
                // 如果其中一个不是元音
                if (!hash[chars[left]]) left++;
                if (!hash[chars[left]]) right--;
            }
        }
        return new String(chars);
    }

    private void swap(char[] chs, int a, int b) {
        char temp = chs[a];
        chs[a] = chs[b];
        chs[b] = temp;
    }

    public static void main(String[] args) {
        ReverseVowels r = new ReverseVowels();
        r.reverseVowels("hello");
    }
}
