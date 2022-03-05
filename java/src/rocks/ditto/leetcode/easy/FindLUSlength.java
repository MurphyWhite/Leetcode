package src.rocks.ditto.leetcode.easy;

/**
 *  521. 最长特殊序列 Ⅰ
 *  https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/
 */
public class FindLUSlength {

    /**
     * 只要不相同，长的一定是最长特殊序列
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}
