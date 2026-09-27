import math

def threeSumClosest(nums, target):
    n = len(nums) #n=4
    nums.sort() #-4,-1,1,2
    
    close = nums[0] + nums[1] + nums[2] #close=-4+-1+1=-4
    
    for i in range(n - 2): #i=0
        l = i + 1 #l=1
        r = n - 1 #r=3
        
        while l < r:
            total_sum = nums[i] + nums[l] + nums[r] #-4+-1+2=-3
            
            if abs(total_sum - target) < abs(close - target): #|-3-1|=4 < |-4-1|=5 -> true
                close = total_sum #close=-3
                
            if total_sum == target:
                return total_sum
            elif total_sum < target: #-3 < 1 -> true
                l += 1 #move l
            else:
                r -= 1 #move r
                
    return close

if __name__ == "__main__":
    nums = [-1, 2, 1, -4] #nums=-1 2 1 -4
    target = 1 #target=1
    result = threeSumClosest(nums, target) #result=-3
    print("Closest Sum:", result)
