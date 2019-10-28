__author__ = ' Zhen Wang'

# 28. Implement strStr()
class ImplementStrStr:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == "":
            return 0
        lenH = len(haystack)
        lenN = len(needle)
        for i in range(lenH - lenN + 1):
            if haystack[i: i + lenN] == needle:
                return i
        return -1