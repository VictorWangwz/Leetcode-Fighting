__author__ = ' Zhen Wang'

class Parent:
    DICT = []

    def __init__(self, val):
        dict = self.__class__.get_dict()
        print(dict)
        print(val in dict)

    @classmethod
    def get_dict(cls):
        return cls.DICT


class Child(Parent):
    DICT = ["h"]


if __name__ == "__main__":
    child = Child("h")
    parent = Parent("h")

