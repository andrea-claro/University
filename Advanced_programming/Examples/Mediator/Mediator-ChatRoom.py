import abc
import functools


def coroutine(function):
    @functools.wraps(function)
    def wrapper(*args, **kwargs):
        generator = function(*args, **kwargs)
        next(generator)
        return generator
    return wrapper


class User(metaclass=abc.ABCMeta):
    def __init__(self, mood, name):
        self.mood = mood
        self.name = name

    @abc.abstractmethod
    def send(self, msg):
        pass

    @abc.abstractmethod
    def receive(self, msg):
        pass


class UserImpl(User):
    def __init__(self, name, mood):
        self.mediator = None
        super().__init__(mood, name)

    def send(self, msg):
        print(self.name + ": Sending Message: " + msg)
        if self.mediator is not None:
            print((msg, self.name))
            self.mediator.send((msg, self))

    def receive(self, msg):
        print(self.name + ": Received Message: " + msg)


class ChatRoom:
    def __init__(self, users):
        self.room = []
        self.createUsers(users)
        self.createMediator()

    def createUsers(self, users):
        for x in users:
            user = UserImpl(x.name, x.mood)
            self.room.append(user)

    def createMediator(self):
        self.mediator = self._sad_user()
        for user in self.room:
            user.mediator = self.mediator

    @coroutine
    def _sad_user(self, successor=None):
        while True:
            message, user = (yield)
            if(user.mood == "triste"):
                for x in users:
                    if x != user:
                        print("{} : ho ricevuto '{}' un messaggio dall'utente {} che e' triste".format(
                            x.name, message, user.name))
            if successor is not None:
                successor.send(user)


if __name__ == '__main__':
    users = (UserImpl("gerardo", "triste"), UserImpl("Andrea", "ricco"))
    room = ChatRoom(users)
    room.room[0].send("hi all")
