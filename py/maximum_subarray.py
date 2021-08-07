#coding=utf-8
class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxSum = nums[0]
        sum = nums[0]
        for i in range(1,len(nums)):
            if sum < 0 :
                sum = 0
            sum += nums[i]
            print "round"+ str(i) + ":" + str(nums[i]) + " " + str(sum) + "/" + str(maxSum)
            if sum >= maxSum:
                maxSum = sum
        return maxSum

if __name__ == "__main__":
    print "debug begin!"
    solution = Solution()
    numbers1 = [-2,1,-3,4,-1,2,1,-5,4]
    numbers2 = [-1]
    numbers3 = [1]
    list = [numbers1,numbers2,numbers3]
    for numbers in list:
        print solution.maxSubArray(numbers)
    #numbers = [3,2,4]
    #target = 6
    #print solution.twoSum2(numbers,target)
    print "debug end!"
