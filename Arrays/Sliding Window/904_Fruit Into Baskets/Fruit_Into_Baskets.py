def totalFruit(fruits):
    n = len(fruits)         #n=5
    l = 0                   #l=0
    maxlen = 0              #maxlen=0
    freq = {}               #freq={}

    for r in range(n):      #r=0..4
        
        freq[fruits[r]] = freq.get(fruits[r], 0) + 1
        #r=0 -> freq={1:1}
        #r=1 -> freq={1:1, 2:1}
        #r=2 -> freq={1:2, 2:1}
        #r=3 -> freq={1:2, 2:2}
        #r=4 -> freq={1:2, 2:2, 3:1}

        while len(freq) > 2:
            leftFruit = fruits[l]
            freq[leftFruit] -= 1

            if freq[leftFruit] == 0:
                del freq[leftFruit]

            l += 1          #move l forward to shrink window

        maxlen = max(maxlen, r - l + 1)
        #r=0 -> max(0, 0-0+1)=1
        #r=1 -> max(1, 1-0+1)=2
        #r=2 -> max(2, 2-0+1)=3
        #r=3 -> max(3, 3-0+1)=4
        #r=4 -> len(freq)>2 -> l moves, max(4, 4-2+1)=3

    return maxlen

if __name__ == "__main":
    fruits = [1, 2, 1, 2, 3]
    print("Max Length:", totalFruit(fruits)) #4
