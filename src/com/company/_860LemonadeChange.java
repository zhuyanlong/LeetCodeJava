package com.company;

public class _860LemonadeChange {
    public static void main(String args[]){
        int[] bills={5,10,20,5};
        boolean res=lemonadeChange(bills);
        System.out.println(res);
    }
    public static boolean lemonadeChange(int[] bills) {
        int[] getmoney={0,0,0};
        int returnmoney=0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                getmoney[0]+=1;
            }else if(bills[i]==10){
                getmoney[1]+=1;
            }else{
                getmoney[2]+=1;
            }
            returnmoney=bills[i]-5;
            if(returnmoney==5) {
                if(getmoney[0]>0){
                    getmoney[0]-=1;
                }else{
                    System.out.println(returnmoney);
                    return false;
                }
            }
            if(returnmoney==15){
                if(getmoney[0]>0 && getmoney[1]>0){
                    getmoney[0]-=1;
                    getmoney[1]-=1;
                }else if(getmoney[0]>2){
                    getmoney[0]-=3;
                }else{
//                    System.out.println(returnmoney);
                    return false;
                }
            }
//            System.out.println(getmoney[0]+" "+getmoney[1]+" "+getmoney[2]);
        }
        return true;
    }
}
