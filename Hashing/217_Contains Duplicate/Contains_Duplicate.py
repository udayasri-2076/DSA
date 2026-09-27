def containsDuplicate(nums):
    seen = set()
    for num in nums:
        if num in seen:
            return True
        seen.add(num)
    return False
if __name__ == "__main__":
    nums = [1, 2, 3, 1]
    result = containsDuplicate(nums)
    print("Contains Duplicate:", result)