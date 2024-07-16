import sys

def fibonacci_dinamico(n,  memo = {}):
    if n <= 1:
        return 1

    try:
        return memo[n]
    except KeyError:
        resultado = fibonacci_dinamico(n-1, memo) + fibonacci_dinamico(n-2,memo)
        memo[n] = resultado

        return resultado


def getNthFib(n, memory={}):
    if n == 2:
        return 1
    elif n == 1:
        return 0
    try:
        return memory[n]
    except KeyError:
        result = getNthFib(n-1, memory) + getNthFib(n-2, memory)
        memory[n] = result
        return result

if __name__ == '__main__':
    sys.setrecursionlimit = 10000
    n = int(input('introdusca numero'))
    #resultado = fibonacci_dinamico(n)
    resultado  = getNthFib(n)
    print(resultado)   