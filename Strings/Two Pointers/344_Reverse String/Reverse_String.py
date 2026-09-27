def reverseString(s):
    n = len(s)              #n=5

    # Optimal Approach - Two Pointers
    # l -> left pointer starting at index 0
    # r -> right pointer starting at the last index (n-1)
    # Time Complexity: O(n)
    # Space Complexity: O(1)

    l = 0                   # l=0 -> s[0]=h
    r = n - 1               # r=4 -> s[4]=o

    while l < r:            # 0<4t  1<3t  2<2f
        temp = s[l]         # temp=h  # temp=e
        s[l] = s[r]         # s[0]=o  # s[1]=l
        s[r] = temp         # s[4]=h  # s[3]=e

        l += 1              # l=0+1=1  # l=1+1=2
        r -= 1              # r=4-1=3  # r=3-1=2

if __name__ == "__main__":
    s = ['h', 'e', 'l', 'l', 'o']
    reverseString(s)
    print("Reversed String:", " ".join(s)) # o l l e h
