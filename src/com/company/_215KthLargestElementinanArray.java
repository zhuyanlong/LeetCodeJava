package com.company;

public class _215KthLargestElementinanArray {
    public static void main(String args[]){
        int[] nums={4,3,3,1};
        int k=2;
        _215Solution sol=new _215Solution();
        sol.findKthLargest(nums,k);
    }
}

class _215Solution {
    public int findKthLargest(int[] nums, int k) {
        int res=selectSort(nums, k);
        System.out.println(res);
        return res;
    }

    public void sink(){
        
    }

    public int selectSort(int[] nums,int k){
        for(int i=0;i<nums.length;i++){
            int index=i;
            int flag=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[index]<nums[j]){
                    flag=1;
                    index=j;
                }
            }
            if(flag==1) {
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
            }
            k-=1;
            if(k==0){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}