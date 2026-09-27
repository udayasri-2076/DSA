def twoSum(nums, target):
    # Example: nums = [2, 7, 11, 15], target = 9
    mapping = {}

    for i in range(len(nums)):
        diff = target - nums[i]    # 9 - 2 = 7 | 9 - 7 = 2

        if diff in mapping:        # mapping does not have 7 yet | mapping contains key 2 at index 0
            return [mapping[diff], i]  # Returns [0, 1]

        mapping[nums[i]] = i       # mapping stores: {2: 0}

    return [-1, -1]

if __name__ == "__main__":
    nums = [2, 7, 11, 15]
    target = 9
    result = twoSum(nums, target)
    print("Indices:", result)