package src.rocks.ditto.leetcode.easy;

/**
 * 67. 二进制求和
 * https://leetcode.cn/problems/add-binary/description/?envType=daily-question&envId=2026-02-15
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int maxLength = Math.max(a.length() , b.length());

        int aLength = a.length();
        int bLength = b.length();

        int carry = 0;
        for (int i = 0; i < maxLength ; i++){
            // 字符相减 ASCII
            carry += i<aLength? a.charAt(aLength - i - 1) - '0' : 0;
            carry += i<bLength? b.charAt(bLength - i - 1) - '0' : 0;
            result.append((char) (carry % 2  + '0'));
            // 如果大于2要进位
            carry /= 2;
        }
        // 如果最后还多一位
        if (carry > 0){
            result.append('1');
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();
        System.out.println(solution.addBinary("111", "1"));
    }
}
