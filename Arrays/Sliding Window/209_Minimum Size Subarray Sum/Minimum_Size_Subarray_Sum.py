# Minimum Size Subarray Sum - LeetCode 209

# Brute Force Approach
# Check all possible sub-arrays by calculating their sum using nested loops.
# Time Complexity: O(n^2)
# Space Complexity: O(1)

# Optimal Approach - Sliding Window
# Use two pointers l and r to maintain a sliding window.
# Expand r to include elements until the window sum >= target.
# Once valid, record the minimum length and shrink from l to find a smaller valid window.
# Time Complexity: O(n)
# Space Complexity: O(1)

def minSubArrayLen_brute_force(target, nums):
    n = len(nums)                               #n=6
    minsub = float('inf')                       #minsub=inf
    
    for i in range(n):                          #i=0 1 2 3 4 5
        current_sum = 0                         #current_sum=0
        for j in range(i, n):                   #j=0..5
            current_sum += nums[j]              #accumulate sum
            if current_sum >= target:           #check if sum reaches target
                minsub = min(minsub, j - i + 1) #update minsub length
                break                           #found min for this starting point, break inner loop
                
    return minsub if minsub != float('inf') else 0

def minSubArrayLen_optimal(target, nums):
    n = len(nums)                               #n=6
    l = 0                                       #l=0
    sum_val = 0                                 #sum=0
    minsub = float('inf')                       #minsub=inf
    
    for r in range(n):                          #r=0 1 2 3 4 5
        sum_val += nums[r]                      #r=0->2, r=1->5, r=2->6, r=3->8, r=4->10, r=5->9
        
<div>
        while sum_val >= target:                #2>=7f, 5>=7f, 6>=7f, 8>=7t, 10>=7t, 7>=7t, 9>=7t
            minsub = min(minsub, r - l + 1)     #minsub update: (inf, 3-0+1)=4, (4, 4-1+1)=4, (4, 4-2+1)=3, (3, 5-3+1)=3, (3, 5-4+1)=2
            sum_val -= nums[l]                  #8-2=6, 10-3=7, 7-1=6, 9-2=7, 7-4=3
            l += 1                              #l=1, l=2, l=3, l=4, l=5
            
    return 0 if minsub == float('inf') else minsub

if __name__ == "__main__":
    target = 7                                  #target=7
    nums = [2, 3, 1, 2, 4, 3]                   #nums=2 3 1 2 4 3
    
    ans_brute = minSubArrayLen_brute_force(target, nums)
    print("Brute Force Approach:", ans_brute)     #2
    
    ans_optimal = minSubArrayLen_optimal(target, nums)
    print("Optimal Approach (Sliding Window):", ans_optimal) #2
