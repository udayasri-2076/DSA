def search(nums, target):
    # Brute Force
    # Traverse every element and check if it matches target
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    brute_result = -1 #brute_result=-1
    for i in range(len(nums)): #i=0 1 2 3 4
        if nums[i] == target: #4==0f 5==0f 6==0f 7==0f 0==0t
            brute_result = i #brute_result=4
            break

    print("Brute Force Index:", brute_result) #4

    # Optimal Approach - Binary Search
    # Divide array and use sorted half property
    # Time Complexity: O(log n)
    # Space Complexity: O(1)
    l = 0             #l=0 -> nums[l]=4
    r = len(nums) - 1 #r=6 -> nums[r]=2
    optimal_result = -1 #optimal_result=-1

    while l <= r: #0<=6t 4<=2t
        mid = l + (r - l) // 2 #mid=3 -> nums[3]=7
                              #mid=5 -> nums[5]=1

        if nums[mid] == target: #7==0f 1==0f
            optimal_result = mid
            break

        elif nums[mid] >= nums[l]: #left sorted: 7>=4t
            if nums[l] <= target and target < nums[mid]: #4<=0f and 0<7
                r = mid - 1
            else:
                l = mid + 1 #l=3+1=4
        else: #right sorted
            if nums[mid] < target and target <= nums[r]: #1<0f and 0<=2
                l = mid + 1
            else:
                r = mid - 1 #r=5-1=4

    # next loop: l=4, r=4 -> mid=4 -> nums[4]=0 == target -> optimal_result=4

    print("Optimal Approach Index:", optimal_result) #4

if __name__ == "__main__":
    nums = [4, 5, 6, 7, 0, 1, 2] #nums=4 5 6 7 0 1 2
    target = 0                   #target=0
    search(nums, target)
