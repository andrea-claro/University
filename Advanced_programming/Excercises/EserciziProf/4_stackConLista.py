#Creare una linkedList e dai metodi implementare
# uno stack con la lista
class Node(object):

    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next_node = next_node

    def get_data(self):
        return self.data

    def get_next(self):
        return self.next_node

    def set_next(self, new_next):
        self.next_node = new_next


class LinkedList(object):

    def __init__(self, head=None):
        self.head = head

    def insert(self, data):
        new_node = Node(data)
        new_node.set_next(self.head)
        self.head = new_node

    def size(self):
        current = self.head
        count = 0
        while current:
            count += 1
            current = current.get_next()
        return count

    def search(self, data):
        current = self.head
        found = False
        while current and found is False:
            if current.get_data() == data:
                found = True
            else:
                current = current.get_next()
        if current is None:
            raise ValueError("Data not in list")
        return current

    def delete(self, data):
        current = self.head
        previous = None
        found = False
        while current and found is False:
            if current.get_data() == data:
                found = True
            else:
                previous = current
                current = current.get_next()
        if current is None:
            raise ValueError("Data not in list")
        if previous is None:
            self.head = current.get_next()
        else:
            previous.set_next(current.get_next())

    def toString(self):
        current= self.head
        while current:
            print(current.get_data())
            current = current.get_next()

print("--------------LIST----------------")
x= LinkedList()
x.insert("andrea")
x.insert("sono")
x.insert("minkia")
x.insert("tuo nonno")
x.toString()

class Stack:

    def __init__(self, head= None):
        self.head= head

    @classmethod
    def copyMethod(cls, method= None):
        if(method not in cls.__dict__):
            setattr(cls, method.__name__, method)
        else:
            raise Exception("method "+method.__name__+" already exists in the class")

x= Stack()
x.copyMethod(LinkedList.insert)
print("----------------STACK--------------")
x.insert("andrea")
x.insert("sono")
x.insert("minkia")
x.insert("tuo nonno")
x.copyMethod(LinkedList.toString)
x.toString()