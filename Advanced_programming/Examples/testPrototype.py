#Clonazione in diversi modi

import sys
import copy

class Point:

    __slots__ = ("x", "y")

    def __init__(self, x, y):
        self.x = x
        self.y = y


def make_object (cls, *args, **kwargs):
    return cls(*args, **kwargs)

point1 = Point(1, 2)
point2 = eval("{}({}, {})".format("Point", 2, 4))
point3 = getattr(sys.modules[__name__], "Point")(3, 6)
point4 = globals()["Point"](4, 8)
point5 = make_object(Point, 5, 10)
point6 = copy.deepcopy(point5)
point6.x = 6
point6.y = 12
point7 = point1.__class__(7, 14)

print(point1)
print(point2)
print(point3)
print(point4)
print(point5)
print(point6)
print(point7)