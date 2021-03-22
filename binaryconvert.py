"""
This is a code I wrote in CSCI to convert natural numbers to binary
and vice versa.
"""

def i_to_b(n):
    b = []
    if n == 0:
        return 0
    else:
        while n > 1/3:
            k = n % 2
            if k == 1:
                b.append(1)
            else:
                b.append(0)
            n = n/2
    
        res = ""
        for i in b[::-1]:
            res+=str(i)

        return res


print i_to_b(1024)
