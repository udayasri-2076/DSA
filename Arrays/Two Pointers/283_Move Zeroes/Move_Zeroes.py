def move_zeroes():
    # Brute Force Approach
    # Use an extra list to store non-zero elements and fill the rest with zeros.
    # Time Complexity: O(n)
    # Space Complexity: O(n)

    nums_brute = [0, 1, 0, 3, 12]       #nums_brute=0 1 0 3 12
    n_brute = len(nums_brute)           #n_brute=5
    temp = []                           #temp=[]

    for i in range(n_brute):            #i=0 1 2 3 4
        if nums_brute[i] != 0:          #0!=0f 1!=0t 0!=0f 3!=0t 12!=0t
            temp.append(nums_brute[i])  #temp=[1, 3, 12]

    # Fill remaining positions with zeros
    while len(temp) < n_brute:
        temp.append(0)                  #temp=[1, 3, 12, 0, 0]

    for i in range(n_brute):
        nums_brute[i] = temp[i]         #nums_brute=1 3 12 0 0

    print("Brute Force Result:", nums_brute)


    """
    Optimal Approach - Two Pointers
    
    Use two pointers: l and r.
    r scans through the array.
    l tracks the position to place the next non-zero element.
    When nums[r] != 0, swap nums[l] and nums[r], then increment l.

    Time Complexity: O(n)
    Space Complexity: O(1)
    """

    nums = [0, 1, 0, 3, 12]             #nums=0 1 0 3 12
    n = len(nums)                       #n=5
    l = 0                               #l=0

    for r in range(n):                  #r=0 1 2 3 4

        if nums[r] != 0:                #r=0: 0!=0 false
                                        #r=1: 1!=0 true
                                        #r=2: 0!=0 false
                                        #r=3: 3!=0 true
                                        #r=4: 12!=0 true

            # Swap nums[l] and nums[r]
            nums[l], nums[r] = nums[r], nums[l]  #r=1: nums[0],nums[1] = 1,0
                                                 #r=3: nums[1],nums[3] = 3,0
                                                 #r=4: nums[2],nums[4] = 12,3

            l += 1                      #r=1: l=0+1=1
                                        #r=3: l=1+1=2
                                        #r=4: l=2+1=3

    print("Optimal Two Pointers Result:", nums)  #1 3 12 0 0

if __name__ == "__main__":
    move_zeroes()
