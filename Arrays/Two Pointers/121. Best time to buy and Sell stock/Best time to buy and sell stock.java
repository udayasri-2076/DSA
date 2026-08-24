// Best Time to Buy and Sell Stock

/*
Brute Force

Take every price as the buying price.

Compare it with every price after it
as the selling price.

Profit = Selling Price - Buying Price


Example:

prices = [7,1,5,3,6,4]

Buy at 7 -> check 1,5,3,6,4
Buy at 1 -> check 5,3,6,4

1 -> 5 = Profit 4
1 -> 3 = Profit 2
1 -> 6 = Profit 5
1 -> 4 = Profit 3

Maximum Profit = 5


Time Complexity: O(n²)
Space Complexity: O(1)


Optimal Approach - Two Pointers

l -> Buying day
r -> Selling day

prices = [7,1,5,3,6,4]

Buy at 1
Sell at 6

Maximum Profit = 5


Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;

        int l = 0;      // l=0 -> prices[l]=7
        int r = l + 1;  // r=1 -> prices[r]=1
        int m = 0;      // Maximum Profit


        while (r < n) {

            int diff = prices[r] - prices[l];

            /*
            r=1 -> 1-7=-6
            r=2 -> 5-1=4
            r=3 -> 3-1=2
            r=4 -> 6-1=5
            r=5 -> 4-1=3
            */


            if (prices[r] < prices[l]) {

                // r=1 -> 1<7 -> true
                // l becomes 1 -> prices[l]=1

                l = r;
            }

            else {

                // r=2 -> max(4,0)=4
                // r=3 -> max(2,4)=4
                // r=4 -> max(5,4)=5
                // r=5 -> max(3,5)=5

                m = Math.max(diff, m);
            }


            r++;
        }

        return m;
    }
}
