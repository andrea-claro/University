import binascii
ms6= [b'42756F6E', b'32326573696D6F',b'636F6D706C65616E6E4F2C20', b'4361707461696E']

def birthday(l):
    if len(l) == 1:
        e= binascii.unhexlify(l[0])
        print(str(e, 'ascii'))
    else:
        x, *y= l
        e= binascii.unhexlify(x)
        print(str(e, 'ascii'))
        birthday(y)

birthday(ms6)