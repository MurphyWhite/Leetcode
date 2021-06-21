package src.rocks.ditto.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 401. 二进制手表
 * https://leetcode-cn.com/problems/binary-watch/submissions/
 */
public class ReadBinaryWatch {

    // 打表
    static Map<Integer, List<String>> resultMap = new HashMap<>();

    static {
        for (int i = 0; i <= 11 ; i++){
            for (int j=0; j <= 59; j++){
                int rowCnt = Integer.bitCount(i) + Integer.bitCount(j);
                List<String> result = resultMap.getOrDefault(rowCnt, new ArrayList<>());
                result.add(i + ":" + (j <= 9 ? "0" + j : j));
                resultMap.put(rowCnt, result);
            }
        }
    }

    public List<String> readBinaryWatch(int turnedOn) {
        return resultMap.getOrDefault(turnedOn, new ArrayList<>());
    }
}
