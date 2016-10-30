#coding=utf-8

class Solution(object):
    def intToRoman(self, num):
        """
        :type num: int
        :rtype: str
        """
        val = [
            1000 , 500,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
        ]

        syb = [
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
            ]
        str = ''
        i = 0
        while num > 0:
            for _ in range(num // val[i]):
                print num // val[i]
                str += syb[i]
                num -= val[i]
            i += 1
        return str

if __name__ == "__main__":
    solution = Solution()
    for number in [ 4,3,3999]:
        print solution.intToRoman(number)
