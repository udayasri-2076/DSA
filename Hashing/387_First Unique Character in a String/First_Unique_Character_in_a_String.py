class FirstUniqueCharacterInAString:
    @staticmethod
    def firstUniqChar(s: str) -> int:
        # Example: s = "leetcode"
        n = len(s)  # n = 8

        # Create a dictionary to store character frequencies
        freq_map = {}

        # First pass: Count frequencies of each character
        for i in range(n):  # i = 0 to 7
            c = s[i]  # i=0: c='l', i=1: c='e', i=2: c='e', etc.
            freq_map[c] = freq_map.get(c, 0) + 1
            # freq_map updates: {'l': 1}, {'l': 1, 'e': 1}, {'l': 1, 'e': 2}, etc.
        # Final freq_map for "leetcode": {'l': 1, 'e': 3, 't': 1, 'c': 1, 'o': 1, 'd': 1}

        # Second pass: Find first unique character with frequency 1
        for i in range(n):  # i = 0 to 7
            c = s[i]  # i=0: c='l'
            if freq_map[c] == 1:  # freq_map['l'] == 1 is True
                return i  # returns index 0

        return -1

if __name__ == "__main__":
    s = "leetcode"
    result = FirstUniqueCharacterInAString.firstUniqChar(s)
    print(f"First unique character index: {result}")
