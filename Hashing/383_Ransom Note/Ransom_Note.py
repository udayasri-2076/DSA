def canConstruct(ransomNote: str, magazine: str) -> bool:
    # Optimal Approach - Hashing (Frequency Map)
    # Time Complexity: O(m + n)
    # Space Complexity: O(k)

    char_count = {}  # char_count={}

    # count characters in magazine
    for i in range(len(magazine)):  # i=0 i=1
        ch = magazine[i]  # ch=a ch=b
        char_count[ch] = char_count.get(ch, 0) + 1  # i=0 -> {'a': 1}  i=1 -> {'a': 1, 'b': 1}

    # check characters in ransomNote
    for i in range(len(ransomNote)):  # i=0
        ch = ransomNote[i]  # ch=a

        if ch not in char_count or char_count[ch] == 0:  # 'a' in char_count=true, char_count['a']=1 != 0
            return False

        char_count[ch] -= 1  # char_count['a'] = 1 - 1 = 0

    return True  # true


if __name__ == "__main__":
    ransomNote = "a"  # ransomNote=a
    magazine = "ab"   # magazine=ab
    
    result = canConstruct(ransomNote, magazine)
    print("Optimal Approach:", result)  # true
