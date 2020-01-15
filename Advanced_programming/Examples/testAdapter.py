class Computer:

    def __init__(self, name):
        self.name = name

    def __str__(self):
        return f'the {self.name} computer'

    def execute(self):
        return 'executes a program'


class Synthesizer:

    def __init__(self, name):
        self.name = name
    
    def __str__(self):
        return f'the {self.name} synthesizer'

    def play(self):
        return 'is playing an electronic song'


class Human:

    def __init__(self, name):
        self.name = name

    def __str__(self):
        return f'the human {self.name}'

    def speak(self):
        return 'says hello'


class Adapter:
    
    def __init__(self, obj, adapted_methods):
        self.obj = obj
        self.__dict__.update(adapted_methods)

    def __str__(self):
        return str(self.obj)


obj = [Computer('Asus')]
synth = Synthesizer('moog')
obj.append(Adapter(synth, dict(execute = synth.play)))
human = Human('Bob')
obj.append(Adapter(human, dict(execute = human.speak)))
for i in obj:
    print (f'{str(i)} {i.execute()}')