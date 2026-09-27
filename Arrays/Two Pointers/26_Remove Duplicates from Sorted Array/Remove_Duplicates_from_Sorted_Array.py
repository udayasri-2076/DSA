def removeDuplicates(nums):
    n = len(nums)  # n=10

    # Optimal Approach - Two Pointers
    # l -> points to the last unique element found
    # r -> scans the array to find new unique elements

    l = 0  # l=0 -> nums[l]=0
    
    for r in range(1, n):  # r=1..9
        if nums[r] != nums[l]:  # nums[1]!=nums[0] (f), nums[2]!=nums[0] (t), ...
            nums[l + 1] = nums[r]  # nums[1] = nums[2] -> 1
            l += 1  # l=1

    return l + 1  # l+1=5

if __main__ == "__main__":
    nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]  # nums=0 0 1 1 1 2 2 3 3 4
    print("Optimal Approach Unique Count:", removeDuplicates(nums))