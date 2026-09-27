def is_anagram(s, t):
    # Brute Force Approach
    # Time Complexity: O(n log n)
    # Space Complexity: O(n)
    
    if len(s) != len(t):
        return False
        
    s_arr = list(s) #s_arr=['a', 'n', 'a', 'g', 'r', 'a', 'm']
    t_arr = list(t) #t_arr=['n', 'a', 'g', 'a', 'r', 'a', 'm']
    
    s_arr.sort() #s_arr=['a', 'a', 'a', 'g', 'm', 'n', 'r']
    t_arr.sort() #t_arr=['a', 'a', 'a', 'g', 'm', 'n', 'r']
    
    brute_result = True #brute_result=True
    for i in range(len(s_arr)): #i=0..6
        if s_arr[i] != t_arr[i]: #a==a, a==a, a==a, g==g, m==m, n==n, r==r
            brute_result = False
            break
            
    return brute_result


def is_anagram_optimal(s, t):
    # Optimal Approach - Hashing / Frequency Count
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    
    if len(s) != len(t):
        return False
        
    count = [0] * 26 #count=[0, 0, ..., 0]
    
    for i in range(len(s)): #i=0..6
        count[ord(s[i]) - ord('a')] += 1 #increment frequency for s
        count[ord(t[i]) - ord('a')] -= 1 #decrement frequency for t
        
    optimal_result = True #optimal_result=True
    for c in count: #check all character counts
        if c != 0:
            optimal_result = False
            break
            
    return optimal_result

if __name__ == "__main__":
    s = "anagram"
    t = "nagaram"
    print("Brute Force Approach:", is_anagram(s, t))
    print("Optimal Approach:", is_anagram_optimal(s, t))
