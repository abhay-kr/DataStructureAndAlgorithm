package com.String;

public class CheckingPalindrome {
    boolean checkPalindrome(String str){
        for (int i=0;i<(str.length()-1)/2;i++){
            if (str.charAt(i)!=str.charAt(str.length()-(i+1)))
                return false;
        }
        return true;
    }
    public static void main(String Args[]){
        CheckingPalindrome obj=new CheckingPalindrome();
        String str1="AcabA";
        System.out.println(obj.checkPalindrome(str1));
    }
}
