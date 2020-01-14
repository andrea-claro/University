m = 500

def foo():
    global m 
    print(f"M: {m}")
    m = 5

print(f"M_1: {m}")
foo()
print(f"M_2: {m}")
