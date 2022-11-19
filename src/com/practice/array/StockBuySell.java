package com.practice.array;

public class StockBuySell {
    public static void main(String[] args) {
        int[] price = {100, 180, 260, 310,
                40, 535, 695};

        System.out.print(maxProfit(price));
        System.out.print(maxProfitWithMultipleTransactions(price));
    }

    static int maxProfit(int[] price) {
        int maxProfit = 0;
        int minSoFar = price[0];
        for (int i = 0; i < price.length; i++) {
            minSoFar = Math.min(minSoFar, price[i]);
            int profit = price[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }

    // Using simple approach if price[i]-price[i-1]>0 then do the transaction
    static int maxProfitWithMultipleTransactions(int[] price) {
        int profit = 0;
        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                profit += price[i] - price[i - 1];
            }
        }
        return profit;
    }
}
