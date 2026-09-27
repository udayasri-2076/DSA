# Squares of a Sorted Array

"""
Brute Force Approach

Square every element in the array first, then sort the array.

Example:
nums = [-4,-1,0,3,10]

Square each element:
nums = [16,1,0,9,100]

Sort the array:
nums = [0,1,9,16,100]

Time Complexity: O(n log n)
Space Complexity: O(n)


Optimal Approach - Two Pointers

Since the array is already sorted, the largest squared values
will always be at the extreme ends (either very large negative numbers
or very large positive numbers).

Use two pointers (l and r) starting at both ends of the array.
Compare absolute values, place the larger square at the end of the result array,
and move the corresponding pointer inward.

Example:
nums = [-4,-1,0,3,10]
n = 5
l = 0, r = 4

res = [0, 0, 0, 0, 0]

i = 4 -> |-4| > |10| (4 > 10) false -> res[4] = 10*10 = 100, r = 3
i = 3 -> |-4| > |3| (4 > 3) true -> res[3] = (-4)*(-4) = 16, l = 1
i = 2 -> |-1| > |3| (1 > 3) false -> res[2] = 3*3 = 9, r = 2
i = 1 -> |-1| > |0| (1 > 0) true -> res[1] = (-1)*(-1) = 1, l = 2
i = 0 -> |0| > |0| (0 > 0) false -> res[0] = 0*0 = 0, r = 1

Result = [0, 1, 9, 16, 100]

Time Complexity: O(n)
Space Complexity: O(n)
"""

def main():
    n = int(input("enter the size of the array:\n")) #n=5

    print("enter the elements of the array:")
    nums = list(map(int, input().split())) #nums=-4 -1 0 3 10

    # Brute Force
    brute_res = [x * x for x in nums] #brute_res=16 1 0 9 100
    brute_res.sort() #brute_res=0 1 9 16 100

    print("Brute Force: ", end="")
    for i in range(n):
        print(brute_res[i], end=" ") #0 1 9 16 100
    print()

    # Optimal Approach - Two Pointers
    l = 0 #l=0 -> nums[l]=-4
    r = n - 1 #r=4 -> nums[r]=10

    res = [0] * n #res=0 0 0 0 0

    for i in range(n - 1, -1, -1): #i=4 3 2 1 0
        if abs(nums[l]) > abs(nums[r]): #|-4|>|10|f  |-4|>|3|t  |-1|>|3|f  |-1|>|0|t  |0|>|0|f
            res[i] = nums[l] * nums[l] #i=3 -> res[3]=16  i=1 -> res[1]=1
            l += 1 #l=2  l=2
        else:
            res[i] = nums[r] * nums[r] #i=4 -> res[4]=100  i=2 -> res[2]=9  i=0 -> res[0]=0
            r -= 1 #r=3  r=2  r=0

    print("Optimal Approach: ", end="")
    for i in range(n):
        print(res[i], end=" ") #0 1 9 16 100
    print()

if __name__ == "__main__":
    main()
