package com.String;

import java.util.LinkedHashMap;

public class KthNonRepeating {

    private char findRepeating(String str, int n){

        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();

        for (int i=0;i<str.length();i++){
            char ch1=str.charAt(i);
            if (map.containsKey(ch1)){
                int temp=map.remove(ch1);
                temp++;
                map.put(ch1,temp);
            }
            else{
                map.put(ch1,1);
            }
        }
        int temp=0;
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.get(ch)==1){
                temp++;
                if (temp==n)
                    return ch;
            }
        }
        return ' ';
    }

    public static void main(String Args[]){
        KthNonRepeating obj=new KthNonRepeating();
        System.out.println(obj.findRepeating("geeksforgeeks",4));
    }
}
