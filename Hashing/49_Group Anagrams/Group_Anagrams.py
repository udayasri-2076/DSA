# Group Anagrams

"""
Optimal Approach - Hashing with Sorted String Key

Use a dictionary to group anagrams together.
Sort each string to create a canonical key for its anagram group.

Example:
strs = ["eat","tea","tan","ate","nat","bat"]

"eat" -> sort -> "aet" -> map["aet"] -> append "eat"
"tea" -> sort -> "aet" -> map["aet"] -> append "tea"
"tan" -> sort -> "ant" -> map["ant"] -> append "tan"
"ate" -> sort -> "aet" -> map["aet"] -> append "ate"
"nat" -> sort -> "ant" -> map["ant"] -> append "nat"
"bat" -> sort -> "abt" -> map["abt"] -> append "bat"

Result:
[["eat","tea","ate"],["tan","nat"],["bat"]]

Time Complexity: O(n * k log k), where n is the number of strings and k is the maximum length of a string
Space Complexity: O(n * k)
"""

from collections import defaultdict

def groupAnagrams(strs):
    anagram_map = defaultdict(list) #anagram_map={}
    
    for i in range(len(strs)): #i=0..5
        str_val = strs[i] #i=0 -> str_val="eat"  i=1 -> str_val="tea"
        
        sorted_key = "".join(sorted(str_val)) #i=0 -> "aet"  i=1 -> "aet"  i=2 -> "ant"
        
        anagram_map[sorted_key].append(str_val) #anagram_map={"aet":["eat","tea"]}...
        
    return list(anagram_map.values()) #result=[["eat","tea","ate"],["tan","nat"],["bat"]]

if __name__ == "__main__":
    n = int(input("enter the number of strings:\n")) #n=6
    print("enter the strings:")
    strs = []
    for i in range(n):
        strs.append(input()) #strs=["eat","tea","tan","ate","nat","bat"]
        
    result = groupAnagrams(strs)
    print("Grouped Anagrams:", result)
