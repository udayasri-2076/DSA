# Container With Most Water

# Brute Force
# Check every possible pair of lines (i, j) to find the container
# that holds the most water.
# Area = width * min height = (j - i) * min(height[i], height[j])
# Time Complexity: O(n^2)
# Space Complexity: O(1)

height = [1, 8, 6, 2, 5, 4, 8, 3, 7]  # height=1 8 6 2 5 4 8 3 7
n = len(height)                     # n=9

maxi_bf = 0  # maxi_bf=0

for i in range(n):  # i=0..8
    for j in range(i + 1, n):  # j=i+1..8
        width = j - i
        h = min(height[i], height[j])
        area = width * h
        maxi_bf = max(area, maxi_bf)  # update max area

print("Brute Force Max Area:", maxi_bf)  # 49


# Optimal Approach - Two Pointers
# l -> left pointer at index 0
# r -> right pointer at index n-1
# Width starts at maximum (n-1).
# Move the pointer pointing to the shorter line inward to find a potentially taller line.
# Time Complexity: O(n)
# Space Complexity: O(1)

l = 0            # l=0 -> height[l]=1
r = n - 1        # r=8 -> height[r]=7
maxi = 0         # maxi=0

while l < r:     # 0<8t  1<8t  ...  1<7t
    width = r - l  # 8-0=8  8-1=7  ...
    h = min(height[l], height[r])  # min(1,7)=1  min(8,7)=7  ...
    area = width * h  # 8*1=8  7*7=49  ...
    maxi = max(area, maxi)  # max(8,0)=8  max(49,8)=49  ...

    if height[l] < height[r]:  # 1<7t  8<7f  ...
        l += 1  # l=0+1=1
    else:
        r -= 1

print("Optimal Approach Max Area:", maxi)  # 49
