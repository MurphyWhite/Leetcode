package src.rocks.ditto.leetcode.medium;

public class NumSteps {

    public int numSteps(String s) {
        boolean meet1=false;
        int ans = 0;
        // 不能直接format，会超长
        for (int i = s.length() - 1; i >= 0 ; i--) {
            // 当前位是0
            if (s.charAt(i) == '0'){
                //如果上一位是1, 那这个就会因为上一位被加一，导致这里变1，然后需要再+1，再除2消去这一位(两部)
                //如果上一位是0，那只需要一步
                ans += (meet1 ? 2 : 1);
            } else {
                // 如果当前位是1
                if (meet1) {
                    // 如果上一位也是1，那就不需要加一，可以被直接除2消去
                    //特殊情况是如果最高位的1，且上一位也是1，那也是需要消去当前位的，然后取进一的剩下的1
                    ans += 1;
                } else {
                    // 那就需要+1，再除2消去这一位并设置meet1 ,特殊情况是如果最高位的1，不需要被消去
                    if (i != 0){
                        ans += 2;
                    }
                    meet1 = true;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        NumSteps numSteps = new NumSteps();
        System.out.println(numSteps.numSteps("110"));
        System.out.println(numSteps.numSteps("1111011110000011100000110001011011110010111001010111110001"));
    }
}
