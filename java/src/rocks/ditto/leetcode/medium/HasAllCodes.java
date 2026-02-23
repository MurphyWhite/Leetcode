package src.rocks.ditto.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 * https://leetcode.cn/problems/check-if-a-string-contains-all-binary-codes-of-size-k/description/?envType=daily-question&envId=2026-02-23
 */
public class HasAllCodes {

    public boolean hasAllCodes(String s, int k) {
        // 太短了，不可能有所有
        if (s.length() < ((1 << k) + k - 1)) {
            return false;
        }
        int num = Integer.parseInt(s.substring(0, k), 2);
        Set<Integer> exists = new HashSet<>();
        exists.add(num);
        for (int i = 1; i + k <= s.length(); i++) {
            // 先把最高位的数去掉,再往左一位，再拼一个最低位
            num = ((num - ((s.charAt(i - 1) - '0') << (k - 1))) << 1) + (s.charAt(i + k - 1) - '0');
            exists.add(num);
            System.out.println(num);
        }
        return exists.size() == (1 << k);
    }

    public static void main(String[] args) {
        HasAllCodes hasAllCodes = new HasAllCodes();
        System.out.println(hasAllCodes.hasAllCodes("00110110", 2));
    }
}
