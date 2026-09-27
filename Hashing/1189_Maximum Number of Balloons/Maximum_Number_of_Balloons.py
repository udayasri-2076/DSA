class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        # Example: text = "nlaebolko"
        freq_map = {}

        # Traverse through each character in the string to build frequency map
        for i in range(len(text)): # i = 0, ch = 'n', freq_map = {'n': 1}
            ch = text[i]           # i = 1, ch = 'l', freq_map = {'n': 1, 'l': 1}
                                   # i = 2, ch = 'a', freq_map = {'n': 1, 'l': 1, 'a': 1}
            freq_map[ch] = freq_map.get(ch, 0) + 1 # Updates frequency for each char

        # We need 'b', 'a', 'l', 'o', 'n' to form the word "balloon"
        # 'l' and 'o' appear twice in "balloon", so their counts must be divided by 2
        b = freq_map.get('b', 0) # b = 1
        a = freq_map.get('a', 0) # a = 1
        l = freq_map.get('l', 0) // 2 # l = 1 // 2 = 0
        o = freq_map.get('o', 0) // 2 # o = 1 // 2 = 0
        n = freq_map.get('n', 0) # n = 1

        # The number of times we can form "balloon" is limited by the bottleneck character
        result = min(b, a, l, o, n) # result = min(1, 1, 0, 0, 1) = 0

        return result # Returns 0