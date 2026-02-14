package src.rocks.ditto.leetcode.medium;

/**
 * 799. 香槟塔
 * https://leetcode.cn/problems/champagne-tower/?envType=daily-question&envId=2026-02-14
 */
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {

        // row是当前排的酒杯
        double[] row = {poured};

        //一层一层的往下流
        for (int i = 1; i <= query_row ; i++){
            // 默认是0
            double[] nextRow = new double[i+1];
            for (int j = 0; j < i; j++){
                double over_vol = row[j] - 1;
                // j位置溢出的酒会流到下面左右两个杯子中
                if (over_vol > 0 ) {
                    nextRow[j] += over_vol/2;
                    nextRow[j+1] += over_vol/2;
                }
            }
            row = nextRow;
            // 这层流完了
        }
        //
        return Math.min(1, row[query_glass]);
    }

    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();
        System.out.println(champagneTower.champagneTower(1,1,1));
        System.out.println(champagneTower.champagneTower(2,1,1));
    }
}
