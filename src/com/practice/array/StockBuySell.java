package com.practice.array;

public class StockBuySell {
    public static void main(String[] args) {
        int[] price = {100, 180, 260, 310,
                40, 535, 695};

        System.out.print(maxProfit(price));
        System.out.print(maxProfitWithMultipleTransactions(price));
    }

    /**
     * The maxProfit method is designed to calculate the maximum profit that can be made by buying and selling a stock once given the price of the stock for each day.
     * Here's how it works:
     * 1.It initializes maxProfit to 0. This variable will hold the maximum profit that can be made.
     * 2.It initializes minSoFar to the price of the stock on the first day. This variable will hold the minimum price of the stock seen so far.
     * 3.It then iterates over the price array. For each day:
     * a). It updates minSoFar to be the minimum of minSoFar and the price of the stock on that day.
     * b). It calculates the profit that can be made if the stock was bought on the day when the price was minSoFar and sold on the current day.
     * This is done by subtracting minSoFar from the price on the current day.
     * c). It updates maxProfit to be the maximum of maxProfit and the profit calculated in the previous step.
     * Finally, it returns maxProfit which is the maximum profit that can be made by buying and selling the stock once.
     */
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

    /**
     * The maxProfitWithMultipleTransactions method is designed to calculate the maximum profit that can be made by buying and selling a stock multiple times
     * given the price of the stock for each day. The key point here is that you are allowed to make as many transactions as you want,
     * i.e., buy one and sell one share of the stock multiple times.
     * ````* Here's how it works:
     * <p>
     * 1. It initializes `profit` to 0. This variable will hold the total profit from all transactions.
     * 2. It then iterates over the price array starting from the second day. For each day:
     * - It checks if the price of the stock on the current day is greater than the price of the stock on the previous day.
     * - If it is, it means that a profit can be made by buying the stock on the previous day and selling it on the current day. So, it adds the difference in prices to `profit`.
     * 3. Finally, it returns `profit` which is the maximum profit that can be made by buying and selling the stock multiple times.
     * </p>
     */
    //This method uses a simple approach to solve the problem. It always makes a transaction (buys and then sells the stock) whenever it is profitable to do so.
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
