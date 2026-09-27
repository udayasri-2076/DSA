def isPalindrome(s):
    """
    Optimal Approach - Two Pointers

    Use two pointers, left at the beginning and right at the end.
    Move left forward if it's not alphanumeric.
    Move right backward if it's not alphanumeric.
    Compare characters case-insensitively.

    Time Complexity: O(n)
    Space Complexity: O(1)
    """
    left = 0                  # left=0
    right = len(s) - 1        # right=29

    while left < right:
        l = s[left]
        r = s[right]

        if not l.isalnum():
            left += 1         # skip non-alphanumeric from left
        elif not r.isalnum():
            right -= 1        # skip non-alphanumeric from right
        else:
            if l.lower() != r.lower():
                return False  # mismatch found
            left += 1         # move left forward
            right -= 1        # move right backward

    return True

if __name__ == "__main__":
    s = "A man, a plan, a canal: Panama"
    result = isPalindrome(s)
    print("Optimal Approach:", result)
