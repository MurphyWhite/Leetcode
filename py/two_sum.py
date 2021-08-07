class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        numToSort =  nums[:]
        numToSort.sort()
        num_one = 0
        num_two = len(nums)-1

        while (num_one < num_two):
            sum = numToSort[num_one] + numToSort[num_two]
            if target == sum:
                break
            if target < sum:
                num_two -= 1
            if target > sum:
                num_one += 1
        result = []
        for i in range(0,len(nums)):
            if nums[i] == numToSort[num_one]:
                result.append(i)
                break
        for i in range(len(nums)-1,-1,-1):
            if nums[i] == numToSort[num_two]:
                result.append(i)
                break
        return result

    def twoSum2(self,nums,target):
        dict = {}
        for i in xrange(len(nums)):
            x = nums[i]
            if target - x in dict:
                return [dict[target-x],i]
            else:
                dict[x] = i

if __name__ == "__main__":
    print "debug begin!"
    solution = Solution()
    numbers = [2,5,1]
    target = 7
    print solution.twoSum2(numbers,target)
    numbers = [3,2,4]
    target = 6
    print solution.twoSum2(numbers,target)
    print "debug end!"
