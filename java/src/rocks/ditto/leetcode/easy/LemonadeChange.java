package src.rocks.ditto.leetcode.easy;

/**
 * 860. 柠檬水找零
 * https://leetcode.cn/problems/lemonade-change/
 */
public class LemonadeChange {

    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     *
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     *
     * 注意，一开始你手头没有任何零钱。
     *
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        int changeFive = 0, changeTen = 0;
        for (int bill : bills){
            switch (bill) {
                case 5:
                    changeFive++;
                    break;
                case 10:
                    if (changeFive > 0) {
                        changeTen++;
                        changeFive--;
                    } else {
                        return false;
                    }
                    break;
                case 20:
                    if (changeTen>0 && changeFive > 0){
                        changeTen--;
                        changeFive--;
                    } else if (changeFive >= 3){
                        changeFive-=3;
                    } else {
                        return false;
                    }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        LemonadeChange solution = new LemonadeChange();
        int[] test = new int[]{5,5,10,20};
        System.out.println(solution.lemonadeChange(test));
    }
}
