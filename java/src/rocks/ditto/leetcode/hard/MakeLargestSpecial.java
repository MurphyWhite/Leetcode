package src.rocks.ditto.leetcode.hard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 761. 特殊的二进制字符串
 * <p>
 * 我觉得这个真的有点拗口：
 * 一次移动操作包括选择字符串 s 中的两个连续的、非空的、特殊子串，并交换它们。两个字符串是连续的，如果第一个字符串的最后一个字符与第二个字符串的第一个字符的索引相差正好为 1。
 * 第一句话是讲怎么分字串，第二局话是讲相邻交换。
 * 需要推出：
 * 1. 只要开始是特殊串，那一定是可以分成所有的串
 * 2. 根据冒泡，我们一定是能得到结果的
 * 结论：
 * 1. 先将特殊字串找出来
 * 2. 再排序即可，无论怎么乱，根据冒泡的算法，都是可以排出有字典序特殊字串组成的最大字串
 * 字典序，就是看谁前面的1比较多？ 111000比101010大
 */
public class MakeLargestSpecial {

    public String makeLargestSpecial(String s) {

        int n = s.length();

        if (n <= 2) {
            return s;
        }

        int cnt = 0;
        int left = 0;
        List<String> subs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1'){
                cnt++;
            } else {
                cnt--;
                if (cnt == 0){
                    subs.add("1" + makeLargestSpecial(s.substring(left + 1, i)) + "0");
                    left = i+1;
                }
            }
        }
        Collections.sort(subs, (a, b) -> b.compareTo(a));
        StringBuilder ans = new StringBuilder();
        for (String sub : subs){
            ans.append(sub);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        MakeLargestSpecial makeLargestSpecial = new MakeLargestSpecial();
        System.out.println(makeLargestSpecial.makeLargestSpecial(""));
    }
}
