import java_import_substitute if False else None

def four_sum():
    nums = [1, 0, -1, 0, -2, 2]       #nums=1 0 -1 0 -2 2
    n = len(nums)                    #n=6
    target = 0                       #target=0

    # Brute Force Approach
    # Time Complexity: O(n^4)
    # Space Complexity: O(n)
    nums.sort()                      #nums=-2 -1 0 0 1 2
    brute_set = set()

    for i in range(n):               #i=0..5
        for j in range(i + 1, n):    #j=i+1..5
            for k in range(j + 1, n): #k=j+1..5
                for l in range(k + 1, n): #l=k+1..5
                    total = nums[i] + nums[j] + nums[k] + nums[l]
                    if total == target:
                        brute_set.add((nums[i], nums[j], nums[k], nums[l]))

    print("Brute Force Result:", [list(x) for x in brute_set])

    # Optimal Approach - Two Pointers
    # Time Complexity: O(n^3)
    # Space Complexity: O(1)
    result = []                      #result=[]

    for i in range(n):               #i=0..5
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        for j in range(i + 1, n):    #j=i+1..5
            if j > i + 1 and nums[j] == nums[j - 1]:
                continue

            l = j + 1                #left pointer starts right after j
            r = n - 1                #right pointer starts at the end

            while l < r:
                total = nums[i] + nums[j] + nums[l] + nums[r] #compute 4-sum

                if total == target:  #target found
                    result.append([nums[i], nums[j], nums[l], nums[r]])
                    l += 1           #move l
                    r -= 1           #move r

                    while l < r and nums[l] == nums[l - 1]:
                        l += 1       #skip duplicate l values

                    while l < r and nums[r] == nums[r + 1]:
                        r -= 1       #skip duplicate r values

                elif total > target: #sum too big -> need smaller number
                    r -= 1           #shrink from right
                else:                #sum too small -> need bigger number
                    l += 1           #grow from left

    print("Optimal Approach Result:", result)

if __name__ == "__main__":
    four_sum()
