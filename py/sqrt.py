class Solution(object):
    def mySqrt(self, x):
        """
        :type x: int
        :rtype: int
        """
        if x < 2:
            return x
        else:
            min = 1
            max = x/2
            while min <= max:
                mid =(min + max)/2
                if x < mid*mid:
                    max = mid-1
                elif x > mid*mid:
                    min = mid+1
                    lastMid = mid
                else:
                    return mid
            return lastMid
if __name__ == "__main__":
    solution = Solution()
    for number in [4,81]:
        print solution.mySqrt(number)
