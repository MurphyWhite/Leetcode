package src.rocks.ditto.leetcode.easy;

/**
 * 1736. 替换隐藏数字得到的最晚时间
 * https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 */
public class MaximumTime {

    /**
     * 速度有点慢
     * @param time
     * @return
     */
    public String maximumTime(String time) {

        char[] chars = time.toCharArray();
        char h1 = chars[0], h2 = chars[1], m1 = chars[3], m2 = chars[4];
        if (h1 == '?') {
            if (h2 - '0' >= 4 && h2 != '?') {
                h1 = '1';
            } else {
                h1 = '2';
            }
        }
        if (h2 == '?') {
            if (h1 == '2') {
                h2 = '3';
            } else {
                h2 = '9';
            }
        }
        if (m1 == '?') {
            m1 = '5';
        }
        if (m2 == '?') {
            m2 = '9';
        }

        return String.format("%s%s:%s%s", h1, h2, m1, m2);
    }

    /**
     * 这个应该是用到了数组缓存，就会快很多
     * @param time
     * @return
     */
    public String maximumTime2(String time) {

        StringBuilder sb = new StringBuilder();

        sb.append( time.charAt(0) == '?' ? (time.charAt(1) == '?' || time.charAt(1) < '4' ? '2' : '1') : time.charAt(0));
        sb.append( time.charAt(1) == '?' ? (sb.charAt(0) == '2' ? '3' : '9') : time.charAt(1));
        sb.append(':');
        sb.append( time.charAt(3) == '?' ? '5' : time.charAt(3));
        sb.append( time.charAt(4) == '?' ? '9' : time.charAt(4));

        return sb.toString();
    }



    public static void main(String[] args) {
        MaximumTime solution = new MaximumTime();
        System.out.println(solution.maximumTime("1?:2?"));
    }
}
