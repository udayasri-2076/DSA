# Search Insert Position

"""
Brute Force

Traverse the array from left to right.
Compare each element with the target.
If the current element is greater than or equal to the target, return its index.
If the loop finishes without finding such an element, return the length of the array.

Time Complexity: O(n)
Space Complexity: O(1)


Optimal Approach - Binary Search

Use two pointers l and r to define the search space.
Find mid and check if nums[mid] == target.
If nums[mid] > target, search in the left half (r = mid - 1).
If nums[mid] < target, search in the right half (l = mid + 1).
If not found, l will point to the correct insert position.

Time Complexity: O(log n)
Space Complexity: O(1)
"""

def main():
    nums = [1, 3, 5, 6]       #nums=1 3 5 6
    n = len(nums)             #n=4
    target = 5                #target=5

    #
    # Brute Force
    #

    brute_index = n           #brute_index=4

    for i in range(n):        #i=0 0<4t  i=1 1<4t  i=2 2<4t
        if nums[i] >= target: #1>=5f  3>=5f  5>=5t
            brute_index = i   #brute_index=2
            break

    print("Brute Force Index:", brute_index) #2

    #
    # Optimal Approach - Binary Search
    #

    l = 0                     #l=0
    r = n - 1                 #r=3

    while l <= r:             #0<=3t  2<=3t  2<=1f
        mid = l + (r - l) // 2 #mid=1  mid=2

        if nums[mid] == target: #nums[1]=3==5f  nums[2]=5==5t
            break
        elif nums[mid] > target: #3>5f
            r = mid - 1
        else:                   #3<5t
            l = mid + 1         #l=2

    print("Optimal Approach Index:", l) #2

if __name__ == "__main__":
    main()
