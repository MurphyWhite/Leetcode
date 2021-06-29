package src.rocks.ditto.leetcode.easy;

/**
 * 171. Excel表列序号
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        // 表达进制，26进制
        int tmp = 1;
        int result = 0;
        for (int i = n - 1; i >= 0 ; i--){
            int num = columnTitle.charAt(i) - 'A';
            // 因为是从1开始的，所以需要加一，做整体偏移
            num++;
            result += num * tmp;
            tmp *= 26;
        }
        return result;
    }
}
