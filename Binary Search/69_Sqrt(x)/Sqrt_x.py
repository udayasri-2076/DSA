import sys

def main():
    x = 8 #x=8

    # Brute Force Approach
    # Check every integer i starting from 1 upwards
    # until i*i exceeds x.
    # Time Complexity: O(sqrt(x))
    # Space Complexity: O(1)

    brute_ans = 0 #brute_ans=0

    if x >= 2:
        for i in range(1, (x // 2) + 1): #i=1 i=2 i=3
            sq = i * i #i=1 -> sq=1, i=2 -> sq=4, i=3 -> sq=9
            if sq == x: #1==8 false, 4==8 false
                brute_ans = i
                break
            if sq > x: #1>8 false, 4>8 false, 9>8 true
                brute_ans = i - 1 #brute_ans=3-1=2
                break
            brute_ans = i
    else:
        brute_ans = x

    print("Brute Force Approach:", brute_ans) #2

    # Optimal Approach - Binary Search
    # Search space for square root of x lies between 0 and x/2.
    # Time Complexity: O(log x)
    # Space Complexity: O(1)

    opt_ans = 0 #opt_ans=0

    if x < 2:
        opt_ans = x
    else:
        left = 0 #left=0
        right = x // 2 #right=4

        while left <= right: #0<=4 true, 2<=4 true, 2<=1 false
            mid = left + (right - left) // 2 #mid=2, mid=3
            sq = mid * mid #sq=4, sq=9

            if sq == x: #4==8 false, 9==8 false
                opt_ans = mid
                break

            if sq < x: #4<8 true -> left=3
                left = mid + 1
            else: #9<8 false -> right=3-1=2
                right = mid - 1

        if opt_ans == 0:
            opt_ans = right #opt_ans=2

    print("Optimal Approach:", opt_ans) #2

if __name__ == "__main__":
    main()
