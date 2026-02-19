package src.rocks.ditto.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 计数二进制子串
 * https://leetcode.cn/problems/count-binary-substrings/solutions/367704/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/?envType=daily-question&envId=2026-02-19
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        List<Integer> counts = new ArrayList<>();

        int i = 0;
        int n = s.length();

        while (i < n ){
            char c = s.charAt(i);
            int count = 0;
            while (i < n && s.charAt(i) == c) {
                i++;
                count++;
            }
            counts.add(count);
        }

        int ans = 0;
        for (int j = 1; j < counts.size(); j++){
            ans += Math.min(counts.get(j), counts.get(j-1));
        }
        return ans;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings("0011001"));
    }
}
