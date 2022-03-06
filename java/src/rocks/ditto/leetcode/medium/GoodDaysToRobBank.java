package src.rocks.ditto.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *  2100. 适合打劫银行的日子
 *  https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/
 *
 */
public class GoodDaysToRobBank {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int length = security.length;
        int[] increaseArray = new int[length];
        int[] decreaseArray = new int[length];

        List<Integer> goodDays = new ArrayList<>();

        increaseArray[0] = 0;
        decreaseArray[length - 1] = 0;
        for (int i =1; i < length; i++){
            if (security[i] > security[i-1]){
                decreaseArray[i] = 0;
            } else {
                decreaseArray[i] = decreaseArray[i-1] + 1;
            }
        }
        for (int i = length - 2; i >= 0 ; i--){
            if (security[i] > security[i + 1]){
                increaseArray[i] = 0;
            } else {
                increaseArray[i] = increaseArray[i + 1] + 1;
            }
        }

        for (int i = 0; i < length - 1; i++){
            if (increaseArray[i] >= time && decreaseArray[i] >= time){
                goodDays.add(i);
            }
        }
        return goodDays;
    }
}
