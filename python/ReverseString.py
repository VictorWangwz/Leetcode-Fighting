__author__ = ' Zhen Wang'


def reverseString(s):
    # r = len(s)
    # newS = []
    # for i in range(r):
    #     newS.append(s[r - 1 - i])
    # return ''.join(newS)
    return s[len(s)::-1]


if __name__ == "__main__":
    s = "good"
    print(reverseString(s))