package src.rocks.ditto.leetcode.hard;

/**
 * 65. 有效数字
 * https://leetcode-cn.com/problems/valid-number/
 */
public class IsNumber {

    public boolean isNumber(String s) {
        int length = s.length();
        // 是否有e/E
        int eIndex = -1;
        for (int i = 0; i < length; i++){
            char c = s.charAt(i);
            if (c == 'e' || c == 'E'){
                if (eIndex == -1 ){
                    eIndex = i;
                } else {
                    // 超过了一个e/E
                    return false;
                }
            }
        }
        //
        if (eIndex == -1){
            return check(s, 0, length - 1, false);
        } else {
            //分别判断e前后
            return check(s, 0, eIndex - 1, false) && check(s, eIndex + 1, length - 1, true);
        }
    }

    private boolean check(String s, int start, int end, boolean mustBeInteger){
        if (start > end){
            return false;
        }
        // 必须一开始是+ / -
        if (s.charAt(start) == '+' || s.charAt(start) == '-'){
            start++;
        }
        boolean hasDot = false, hasNum = false;
        for (int i = start ; i <= end; i++){
            char c = s.charAt(i);
            if (c == '.'){
                // 不能已经有 .
                if (hasDot || mustBeInteger){
                    return false;
                } else {
                    hasDot = true;
                }
            } else if (c >= '0' && c <= '9'){
                // 0-9
                hasNum = true;
            } else {
                // 别的字母
                return false;
            }
        }
        // 没有数字也不行
        return hasNum;
    }
}
