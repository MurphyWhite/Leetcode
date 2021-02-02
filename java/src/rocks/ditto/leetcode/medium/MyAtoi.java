package src.rocks.ditto.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串转换整数 (atoi)
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {
    /**
     * 自动状态机
     *
     * @param s
     * @return
     */
    static final int START = 0;
    static final int SIGNED = 1;
    static final int NUM = 2;
    static final int END = 3;
    static Map<Integer, int[]> states;

    static {
        states = new HashMap<>();
        states.put(START, new int[]{START, SIGNED, NUM, END});
        states.put(SIGNED, new int[]{END, END, NUM, END});
        states.put(NUM, new int[]{END, END, NUM, END});
        states.put(END, new int[]{END, END, END, END});
    }

    public int getNext(char c) {
        if (c == ' ') {
            return START;
        }
        if (c == '+' || c == '-') {
            return SIGNED;
        }
        if (c >= '0' && c <= '9') {
            return NUM;
        }
        return 3;
    }

    public int myAtoi(String str) {
        int state = START;
        int sign = 1;
        char[] chars = str.toCharArray();
        long ans = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = chars[i];
            state = states.get(state)[getNext(c)];
            if (state == END){
                break;
            }
            if (state == NUM) {
                ans = ans * 10 + c - '0';
                if (sign == 1 && ans > Integer.MAX_VALUE){
                    state = END;
                    ans = Integer.MAX_VALUE;
                }
                if (sign == -1 && (ans * sign) < Integer.MIN_VALUE ){
                    state = END;
                    ans = Integer.MIN_VALUE;
                }
            }
            if (state == SIGNED) {
                sign = c == '+' ? 1 : -1;
            }
        }
        return (int) ans * sign;
    }

    public static void main(String[] args) {
        MyAtoi test = new MyAtoi();
        System.out.println(Long.parseLong(" 12"));
    }
}
