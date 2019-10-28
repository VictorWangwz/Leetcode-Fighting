__author__ = ' Zhen Wang'

import collections

class LongestPalindrome:
    def longestPalindrome(self, s: str) -> int:
        rst = 0
        flag = False
        d = collections.Counter(s)
        for  key in d:
            rst += d[key]//2 * 2
            if d[key] %2 == 1:
                flag = True
        return rst + 1 if flag else rst


if __name__ == "__main__":
    s = "abccccdd"
    lp = LongestPalindrome()
    rst = lp.longestPalindrome(s)
    print(rst)
