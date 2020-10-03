package gfg.ds.array;

public class StockMaxProfit {
    public static void main(String[] args) {
        int[] stockPrices = new int[]{100, 180, 260, 310, 40, 400, 535, 695};
        int length = stockPrices.length;
        adviceBuyForOneTimeBuying(stockPrices, length);
        adviceForMultipleBuySell(stockPrices, length);
    }

    /**
     * Logic to get max profit if provided to buy and sel onc time...
     * Explaination = Find max difference between two numbers..
     * time complexity = O(n)
     */
    private static void adviceBuyForOneTimeBuyingEfficient(int[] stockPrices, int length) {
        System.out.println("Advice for One time buy and sell...");
        int maxDiff = stockPrices[1] - stockPrices[0];
        int buyIndex = 0;
        int sellIndex = 1;
        for (int i=2;i<length;i++){
            if (stockPrices[i]-stockPrices[buyIndex]>maxDiff){
                sellIndex = i;
                maxDiff = stockPrices[i]-stockPrices[buyIndex];
                continue;
            }
//            if (){
//
//            }
        }
        System.out.println("Buy stock on " + buyIndex + " day and Sell on " + sellIndex + " day, You will be making profit of = " + maxDiff+"\n");
    }

    /**
     * Logic to get max profit if provided to buy and sel onc time...
     * Explaination = Find max difference between two numbers..
     * time complexity = O(n sq)
     */
    private static void adviceBuyForOneTimeBuying(int[] stockPrices, int length) {
        System.out.println("Advice for One time buy and sell...");
        int maxDiff = stockPrices[1] - stockPrices[0];
        int buyIndex = 0;
        int sellIndex = 1;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (stockPrices[j] - stockPrices[i] > maxDiff) {
                    maxDiff = stockPrices[j] - stockPrices[i];
                    buyIndex = i;
                    sellIndex = j;
                }
            }
        }
        System.out.println("Buy stock on " + buyIndex + " day and Sell on " + sellIndex + " day, You will be making profit of = " + maxDiff+"\n");
    }

    /**
     * Logic to get max profit if provided to buy and sel multiple times...
     * Explaination = buy on local minima and sell on local maxima...
     */
    private static void adviceForMultipleBuySell(int[] stockPrices, int length) {
        System.out.println("Advice for Multiple times buy and sell...");
        int index = 0;
        int totalProfit = 0;
        while (index < length) {
            int minima = findMinimaFrom(stockPrices, index, length);
            if (minima != -1) {
                System.out.println("Buy on " + minima + " day");
                index = minima + 1;
            }else{
                index = length;
            }
            int maxima = findMaximaFrom(stockPrices, index, length);
            if (maxima != -1) {
                int profit = stockPrices[maxima]-stockPrices[minima];
                totalProfit = totalProfit + profit;
                System.out.println("Sell on " + maxima + " day, for profit = "+profit);
                index = maxima + 1;
            }else{
                index = length;
            }
        }
        System.out.println("Total profit = "+totalProfit);
    }

    /**
     * Find maxima in given array and from provided index.
     */
    private static int findMaximaFrom(int[] stockPrices, int index, int length) {
        for (int i = index; i < length; i++) {
            if ((i != 0 && i != length - 1 && stockPrices[i] > stockPrices[i + 1] && stockPrices[i] > stockPrices[i - 1])
                    || (i == 0 && stockPrices[i] > stockPrices[i + 1])
                    || (i == length - 1 && stockPrices[i] > stockPrices[i - 1])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Find minima in given array and from provided index.
     */
    private static int findMinimaFrom(int[] stockPrices, int index, int length) {
        for (int i = index; i < length; i++) {
            if ((i != 0 && i != length - 1 && stockPrices[i] < stockPrices[i + 1] && stockPrices[i] < stockPrices[i - 1])
                    || (i == 0 && stockPrices[i] < stockPrices[i + 1])
                    || (i == length - 1 && stockPrices[i] < stockPrices[i - 1])) {
                return i;
            }
        }
        return -1;
    }
}
