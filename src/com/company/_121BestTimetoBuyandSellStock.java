package com.company;

public class _121BestTimetoBuyandSellStock {
    public static void main(String args[]){
        int[] prices={7,1,5,3,6,4};
        int res=maxProfit(prices);
        System.out.println(res);
    }
    public static int maxProfit(int[] prices) {
        int maxprofit=0;
        int[] dp=new int[prices.length];
        dp[0]=prices[0];
        for(int i=1;i<prices.length;i++){
            dp[i]=Math.min(dp[i-1],prices[i]);
            if(prices[i]-dp[i]>maxprofit){
                maxprofit=prices[i]-dp[i];
            }
        }
        return maxprofit;
    }
}
