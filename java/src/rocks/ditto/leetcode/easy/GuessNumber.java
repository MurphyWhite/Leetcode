package src.rocks.ditto.leetcode.easy;

/**
 * 374. 猜数字大小
 * https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 */
public class GuessNumber {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left < right){
            int mid = left + (right - left) / 2;
            int guess = guess(mid);
            if (guess == 0){
                return mid;
            }
            if (guess == 1){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private Integer pick;

    public Integer getPick() {
        return pick;
    }

    public void setPick(Integer pick) {
        this.pick = pick;
    }

    private int guess(int num){
        if (pick < num){
            return -1;
        } else if (pick > num){
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        GuessNumber gu = new GuessNumber();
        gu.setPick(6);
        gu.guessNumber(10);
    }
}
