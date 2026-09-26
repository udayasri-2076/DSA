def findPeakElement(nums):
    n = len(nums) #n=4

    # Brute Force
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    brute_peak = -1
    for i in range(n): #i=0 i=1 i=2 i=3
        left_ok = (i == 0) or (nums[i] >= nums[i - 1])
        right_ok = (i == n - 1) or (nums[i] >= nums[i + 1])
        if left_ok and right_ok:
            brute_peak = i #brute_peak=2
            break

    print("Brute Force Peak Index:", brute_peak) #2

    # Optimal Approach - Binary Search
    # Time Complexity: O(log n)
    # Space Complexity: O(1)
    l = 0 #l=0
    r = n - 1 #r=3

    while l < r: #0<3t 1<3t 2<3t
        mid = l + (r - l) // 2 #mid=1 mid=2

        if nums[mid] > nums[mid + 1]: #nums[1]>nums[2] false, nums[2]>nums[3] true
            r = mid #r=2
        else:
            l = mid + 1 #l=2

    print("Optimal Peak Index:", l) #2

if __name__ == "__main__":
    nums = [1, 2, 3, 1]
    findPeakElement(nums)
