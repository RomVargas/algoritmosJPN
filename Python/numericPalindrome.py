def numericPalindrome(number):
    """
    It takes a number, reverses it, and then compares it to the original number
    
    :param number: The number to be checked for palindrome
    """
    temp=number
    rev=0
    while (number > 0):
        digit=number%10
        print(digit)
        rev=rev * 10 + digit
        print(rev)
        number = number//10
        print(number)
    if(temp==rev):
        print('is palindrome')
    else:
        print('is not')

