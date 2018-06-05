package com.String;

public class KAnagram {

    boolean findKAnagram(String str1,String str2, int num){

        if (str1.length()!=str2.length())
            return false;

        int count=0;
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        int count1[]=new int[26];
        int count2[]=new int[26];

        for (int i=0;i<str1.length();i++){
            count1[str1.charAt(i)-97]++;
        }
        for (int i=0;i<str2.length();i++){
            count2[str2.charAt(i)-97]++;
        }
        for (int i=0;i<26;i++){
            if (count1[i]!=count2[i] &&(count1[i]==0 || count2[i]==0)){
                count++;
            }
        }
        if (count<num)
            return true;
        return false;
    }

    public static void main(String Args[]){
        KAnagram obj=new KAnagram();
        String str1="fodr";
        String str2="gork";
        int n=2;
        System.out.println(obj.findKAnagram(str1,str2,n));
    }
}
