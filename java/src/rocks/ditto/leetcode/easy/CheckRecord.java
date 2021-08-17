package src.rocks.ditto.leetcode.easy;

/**
 * 551. 学生出勤记录 I
 * https://leetcode-cn.com/problems/student-attendance-record-i/
 */
public class CheckRecord {

    public boolean checkRecord(String s) {
        int aCnt = 0, lCount = 0;
        char[] records = s.toCharArray();
        for (int i = 0; i < records.length; i++) {
            switch (records[i]){
                case 'A':
                    if (++aCnt >= 2) {
                        return false;
                    }
                    lCount = 0;
                    break;
                case 'L':
                    if (++lCount >= 3) {
                        return false;
                    }
                    break;
                default:
                    lCount = 0;
            }
        }
        return true;
    }
}
