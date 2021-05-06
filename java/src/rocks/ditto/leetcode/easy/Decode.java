package src.rocks.ditto.leetcode.easy;

/**
 * 1720. 解码异或后的数组
 * https://leetcode-cn.com/problems/decode-xored-array/
 */
public class Decode {

    public int[] decode(int[] encoded, int first) {
        int length = encoded.length + 1;
        int[] res = new int[length];
        res[0] = first;
        for (int i = 1; i < length; i++){
            // array[i] = array[i-1] XOR encoded[i-1]
            res[i] = res[i-1] ^ encoded[i-1];
        }
        return res;
    }
}
