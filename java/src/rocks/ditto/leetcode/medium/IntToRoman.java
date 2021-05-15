package src.rocks.ditto.leetcode.medium;

/**
 * 12. 整数转罗马数字
 * https://leetcode-cn.com/problems/integer-to-roman/
 */
public class IntToRoman {

    /**
     * 罗马数字对应表
     */
    private final static int[] ints = new int[]{1, 4, 5, 9, 10, 40, 50, 90 , 100, 400, 500, 900, 1000};

    private final static String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for(int i= ints.length - 1; i >=0 ; i--){
            int value = ints[i];
            while(value <= num){
                num -= value;
                result.append(romans[i]);
            }
            if (num == 0){
                break;
            }
        }
        return result.toString();
    }
}
