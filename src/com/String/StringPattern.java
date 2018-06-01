package com.String;

public class StringPattern {

    String s;
    void pattern(String str,int n) {
        int k = 0;
        s = str;
        String temp = "";
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < (s.length() * (n - k)); i = i + (k + 1)) {

            }
        }
    }
    public static void main(String Args[]){
        StringPattern stringPattern=new StringPattern();
        String str="abcde";
        int n=3;
//        stringPattern.pattern(str,n);
    }
}
