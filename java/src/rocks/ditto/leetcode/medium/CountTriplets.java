package src.rocks.ditto.leetcode.medium;

/**
 * 1442. 形成两个异或相等数组的三元组数目
 * https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 */
public class CountTriplets {

    public int countTriplets(int[] arr) {

        int length = arr.length;
        // 前缀异或和
        // s[i] = arr[i-1] ^ ..... ^ arr[1]

        int[] s = new int[length+1];
        for (int i=0; i<length; i++){
            s[i+1] = s[i] ^ arr[i];
        }
        int ans = 0;
        // 获取（i,j,k）
        // s[i] ^ s[j] = s[j] ^ s[k]
        // 简化后 s[i] == s[j]
        // 当等式 S[i]=S[k+1]成立时，[i+1,k]的范围内的任意 j 都是符合要求的，对应的三元组个数为 k−i。因此我们只需枚举下标 i 和 k。

        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length; j++){
                if (s[i] == s[j+1]){
                    ans += j - i;
                }
            }
        }
        return ans;
    }
}
