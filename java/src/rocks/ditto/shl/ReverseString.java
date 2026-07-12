package src.rocks.ditto.shl;

import java.util.Scanner;

/**
 * Question: Reverse String Conversion
 * ---------------------
 * Emerson wants to convert binary string str1 to str2 by reversing substrings
 * of increasing lengths (2, 3, 4, ...). Find minimum steps to convert.
 *
 * Algorithm: Greedy with Character Positioning
 * ---------------------
 * 1. If strings equal, return 0
 * 2. Check if both have same count of 1s (required for conversion)
 * 3. Greedily position each character from left to right
 * 4. For each mismatched position, find target char and reverse to position
 * 5. Use at most 2 reversals per character
 *
 * Why it works: Since reversal operations of length L can be done in any order,
 * we can treat each character independently. By processing left to right,
 * we ensure earlier positions don't get disturbed. Two reversals suffice:
 * one to bring target char to position, possibly one more to align it.
 *
 * Time Complexity: O(n^2) worst case
 * Space Complexity: O(n)
 */
public class ReverseString {

    /**
     * 计算将 str1 转换为 str2 的最少步数
     * @param str1 初始二进制字符串
     * @param str2 目标二进制字符串
     * @return 最少步数，无法转换返回 -1
     */
    static int minSteps(String str1, String str2) {
        // 情况1: 两个字符串已经相同,无需转换
        if (str1.equals(str2)) return 0;

        int n = str1.length();

        // 情况2: 检查两个字符串中 '1' 的个数是否相同
        // 由于反转操作只是重新排列字符,不会改变字符总数,所以必须个数相等才可能转换
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == '1') count1++;
            if (str2.charAt(i) == '1') count2++;
        }
        if (count1 != count2) return -1;

        // 将字符串转换为字符数组,方便原地修改
        char[] s = str1.toCharArray();
        int steps = 0; // 记录使用的步数

        // 贪心策略:从左到右逐个位置确定字符
        for (int i = 0; i < n - 1; i++) {
            // 如果当前字符已经匹配,跳过
            if (s[i] == str2.charAt(i)) continue;

            // 在剩余字符串中寻找目标字符
            int pos = -1;
            for (int j = i + 1; j < n; j++) {
                if (s[j] == str2.charAt(i)) {
                    pos = j;
                    break;
                }
            }

            // 找不到目标字符,无法完成转换
            if (pos == -1) return -1;

            // 第一次反转:将目标字符从 pos 位置反转到 i 位置
            // 例如: s = "1010", i=2, pos=3, 反转 [2,3] -> s = "1001"
            reverse(s, i, pos);
            steps++;

            // 第二次反转:如果 i 位置仍未匹配,需要额外操作
            // 只有当 pos 与 i 相邻时,一次反转就能将目标放到正确位置
            // 否则需要结合第二步长度的反转来调整
            if (s[i] != str2.charAt(i) && i + 2 < n) {
                int len = Math.min(i + 2, n); // 可用的最大反转长度
                if (pos - i + 1 < len) {      // 如果第一步的反转距离小于可用长度
                    reverse(s, i, i + len - 1); // 使用第二步长度进行反转
                    steps++;
                }
            }
        }

        // 检查最后一位是否匹配
        return s[n - 1] == str2.charAt(n - 1) ? steps : -1;
    }

    /**
     * 反转字符数组中指定区间的字符
     * @param s 字符数组
     * @param l 区间左边界
     * @param r 区间右边界
     */
    static void reverse(char[] s, int l, int r) {
        // 边界检查,确保不超过数组长度
        if (r >= s.length) r = s.length - 1;
        // 双指针交换,知道左右指针相遇
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int count = minSteps(str1, str2);

        sc.close();
        System.out.println(count);
    }
}
