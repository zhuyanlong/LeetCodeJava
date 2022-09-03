package com.company;

public class _34FindFirstandLastPositionofElementinSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int []res=new int[]{-1,-1};
        int i=0;
        int j=nums.length-1;
        int m=0;
        while(i<=j){
            m=(i+j)/2;
            System.out.println(m);
            if(nums[m]>target){
                j=m-1;
            }else if(nums[m]<target){
                i=m+1;
            }else{
                i=m;
                while(i!=-1 && nums[i]==nums[m]){
                    i-=1;
                }
                j=m;
                while(j!=nums.length && nums[j]==nums[m]){
                    j+=1;
                }
                res[0]=i+1;
                res[1]=j-1;
                break;
            }
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums={1};
        int target=1;
        int[]res=searchRange(nums,target);
        System.out.println(res[0]+" "+res[1]);
    }
}
