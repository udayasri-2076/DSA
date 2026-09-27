def longestOnes(nums, k):
    n = len(nums) #n=11
    
    # Brute Force Approach
    max_len_brute = 0 #max_len_brute=0
    for i in range(n): #i=0..10
        zeros = 0 #zeros=0
        for j in range(i, n): #j=i..10
            if nums[j] == 0:
                zeros += 1 #count zeros
            if zeros <= k:
                max_len_brute = max(max_len_brute, j - i + 1) #update max length
            else:
                break #too many zeros, stop inner loop
                
    print("Brute Force Max Consecutive Ones:", max_len_brute)

    # Optimal Approach - Sliding Window
    l = 0 #l=0
    zerocount = 0 #zerocount=0
    max_len = 0 #max_len=0

    for r in range(n): #r=0..10
        if nums[r] == 0:
            zerocount += 1 #r=3 -> 0, zerocount=1
                           #r=4 -> 0, zerocount=2
                           #r=5 -> 0, zerocount=3

        if zerocount > k: #r=5 -> 3>2 true
            if nums[l] == 0: #nums[0]=1 false
                zerocount -= 1
            l += 1 #l=0->1->...->4
            
        max_len = max(max_len, r - l + 1) #track max window size

    print("Optimal Sliding Window Max Consecutive Ones:", max_len)
    return max_len

if __name__ == "__main__":
    nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0] #nums=1 1 1 0 0 0 1 1 1 1 0
    k = 2 #k=2
    longestOnes(nums, k)
