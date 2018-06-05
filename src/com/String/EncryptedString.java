package com.String;

public class EncryptedString {

    void Decrypt(String str,int n){
        String temp="";
        String st="";
        String num="";
        for (int i=0;i<str.length();i++){
            if (Character.isAlphabetic(str.charAt(i))){
                str.concat(str.charAt(i)+"");
            }
            else if (Character.isDigit(str.charAt(i))){
                num.concat(str.charAt(i)+"");
                if (Character.isAlphabetic(str.charAt(i+1))){
                    int len=Integer.parseInt(num);
                    int j=0;
                    for (j=0;j<len;j++){
                        temp.concat(st);
                    }
                    if (j==len){
                        st="";
                        num="";
                    }
                }
            }
        }
        System.out.println(temp);
    }

    public static void main(String Args[]){
        EncryptedString obj=new EncryptedString();
        String str="ab4c12ed3";
        obj.Decrypt(str,21);
    }
}
