package com.company;

public class _912SortanArray {
    public static void main(String args[]){
        int[] nums={0,1,1,0,5};
//        sink(nums,3);
        constructheap(nums);
        heapsort(nums);
        printnums(nums);
    }

//    quicksort
    private static int[] quicksort(int[] nums){
        int p=0;
        int q=nums.length;
        quicksortimpl(nums,p,q);
        printnums(nums);
        return nums;
    }

    private static void quicksortimpl(int[] nums,int p, int r){
        if(r>p){
            int q=partition(nums,p,r);
            quicksortimpl(nums,p,q);
            quicksortimpl(nums,q+1,r);
        }
    }

    private static int partition(int[] nums,int p,int q){
        int i=p;
        int j=p+1;
        int x=nums[p];
        while(j<q){
            if(nums[j]<x){
                i++;
                swap(nums,i,j);
            }
            j++;
        }
        swap(nums,i,p);
        return i;
    }

//    mergesort
    private static void merge(int[] nums,int low,int mid,int high){
        int i=low;
        int j=mid+1;
        int []aux=new int[nums.length];
        for(int k=low;k<=high;k++){
            if(i>mid){
                aux[k]=nums[j++];
            }else if(j>high){
                aux[k]=nums[i++];
            }else if(nums[i]<nums[j]){
                aux[k]=nums[i++];
            }else{
                aux[k]=nums[j++];
            }
        }
        for(int id=low;id<=high;id++){
            nums[id]=aux[id];
        }
    }

    private static void mergesort(int[] nums,int low,int high){
        if(low>=high){
            return;
        }
        int mid=low+(high-low)/2;
        mergesort(nums,low,mid);
        mergesort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

//    heapsort
    private static void sink(int[] nums,int N){
        int k=0;
//        必须交换两者中比较大的那一个
        while((k+1)*2-1<N){
            int j=(k+1)*2-1;
//            查看左节点和右节点哪个更大
            if(j+1<N){
                if(nums[j]<nums[j+1]){
                    j++;
                }
            }
//            如果父节点比子节点大，则进行交换
            if(nums[k]<nums[j]){
                swap(nums,k,j);
            }else{
                break;
            }
            k=j;
        }
    }

    private static void swim(int[] nums,int i){
        while(i>0){
//            k为父节点位置
            int k=(i-1)/2;
            if(nums[i]>nums[k]){
                swap(nums,i,k);
            }else{
                break;
            }
            i=k;
        }
    }

//    构造堆必须用上浮算法
    private static void constructheap(int[] nums){
        for(int i=1;i<nums.length;i++){
            swim(nums,i);
        }
    }

    private static void heapsort(int[] nums){
        for(int i=nums.length-1;i>0;i--){
            swap(nums,0,i);
            sink(nums,i);
        }
    }

    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private static void printnums(int[] nums){
        for(int k=0;k<nums.length;k++){
            System.out.print(nums[k]+" ");
        }
    }
}
