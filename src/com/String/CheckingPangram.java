package com.String;

public class CheckingPangram {

    private boolean checkPangram(String str){
        str=str.toLowerCase();
        char cnt[]=new char[26];
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch!=' '){
                int asc=(int)ch;
                cnt[asc-97]++;
            }
        }
        for (char aCnt : cnt) {
            if (aCnt == 0)
                return false;
        }
        return true;
    }

    public static void main(String Args[]){
        CheckingPangram obj=new CheckingPangram();
        String str="The quick brown fox jumps over the lazy dog ";
        System.out.print(obj.checkPangram(str));
    }
}
