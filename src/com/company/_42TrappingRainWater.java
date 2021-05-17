package com.company;

public class _42TrappingRainWater {
    public static void main(String args[]){
        int[] height={4};
        trap(height);
    }
    public static int trap(int[] height) {
        int len=height.length;
        if(len==0){
            return 0;
        }
        int[] leftdp=new int[len];
        leftdp[0]=height[0];
        int[] rightdp=new int[len];
        rightdp[len-1]=height[len-1];
        for(int i=1;i<len;i++){
            leftdp[i]=Math.max(leftdp[i-1],height[i]);
        }
        for(int i=len-2;i>=0;i--){
            rightdp[i]=Math.max(rightdp[i+1],height[i]);
        }
        int res=0;
        for(int i=0;i<len;i++){
            int tmp=Math.min(leftdp[i],rightdp[i]);
            if(tmp>height[i]){
                res+=tmp-height[i];
            }
        }
//        System.out.println(res);
        return res;
    }
}
