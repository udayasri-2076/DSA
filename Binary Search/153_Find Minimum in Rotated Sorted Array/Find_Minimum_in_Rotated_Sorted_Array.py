def findMin(nums):
    n = len(nums) #n=5

    # Brute Force Approach
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    min_brute = nums[0] #min_brute=3
    for i in range(n): #i=0 i=1 i=2 i=3 i=4
        if nums[i] < min_brute: #3<3f 4<3f 5<3f 1<3t 2<1f
            min_brute = nums[i] #min_brute=1

    print("Brute Force Minimum:", min_brute) #1

    # Optimal Approach - Binary Search
    # Time Complexity: O(log n)
    # Space Complexity: O(1)
    l = 0 #l=0
    r = n - 1 #r=4 -> nums[r]=2

    while l < r: #0<4t 0<2t 3<2f
        mid = l + (r - l) // 2 #mid=2 -> nums[mid]=5
                               #mid=1 -> nums[mid]=4

        if nums[mid] <= nums[r]: #5<=2f 4<=2f
            r = mid
        else:
            l = mid + 1 #l=3 -> nums[l]=1
                        #l=2 -> nums[l]=5

    min_optimal = nums[l] #min_optimal=1
    print("Optimal Approach Minimum:", min_optimal) #1

if __main__ == "__main__":
    nums = [3, 4, 5, 1, 2] #nums=3 4 5 1 2
    findMin(nums)
