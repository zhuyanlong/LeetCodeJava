package com.company;

public class _415AddStrings {
    public static void main(String args[]){
        addStrings("999","999");
    }

//    按位计算
    public static String addStrings(String num1, String num2){
        char[] n1;
        char[] n2;
        int len1=0;
        int len2=0;
        if(num1.length()>=num2.length()){
            len1=num1.length()-1;
            len2=num2.length()-1;
            n1=num1.toCharArray();
            n2=num2.toCharArray();
        }else{
            len1=num2.length()-1;
            len2=num1.length()-1;
            n1=num2.toCharArray();
            n2=num1.toCharArray();
        }
//        flag用来表示进位
        int index1=len1;
        int index2=len2;
        int flag=0;
        while(index2!=-1){
            int tmp=(n1[index1]-'0')+(n2[index2]-'0')+flag;
            if(tmp>=10){
                flag=1;
                tmp=tmp-10;
            }else{
                flag=0;
            }
            n1[index1]=(char)(tmp+'0');
            index1--;
            index2--;
        }
        while(index1!=-1 && flag==1){
            int tmp=(n1[index1]-'0')+flag;
            if(tmp>=10){
                flag=1;
                tmp=tmp-10;
            }else{
                flag=0;
            }
            n1[index1]=(char)(tmp+'0');
            index1--;
        }
        String res=String.valueOf(n1);
        if(flag==1){
            res="1"+res;
        }
//        System.out.println(res);
        return res;
    }
}
