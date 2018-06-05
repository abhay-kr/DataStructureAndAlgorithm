package com.String;

import java.util.LinkedHashMap;

public class MaximumOccuring {

    char findMaximumOccuring(String str){
        LinkedHashMap <Character,Integer> map=new LinkedHashMap<>();
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.containsKey(ch)){
                int temp=map.get(ch);
                temp++;
                map.remove(ch);
                map.put(ch,temp);
            }
            else {
                map.put(ch,1);
            }
        }
        int temp=0;
        char ch1=' ';
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.get(ch)>temp){
                temp=map.get(ch);
                ch1=ch;
            }
        }
        return ch1;
    }

    private char findSecondMaximum(String str){
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
        char ch1=' ';
        char ch2=' ';
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.get(ch)>temp){
                temp=map.get(ch);
                ch1=ch;
            }
        }
        temp=0;
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.get(ch)>temp && map.get(ch)<map.get(ch1)){
                temp=map.get(ch);
                ch2=ch;
            }
        }
        return ch2;
    }

    public static void main(String Args[]){
        MaximumOccuring max=new MaximumOccuring();
        String str="bbbhhay";
        System.out.println(max.findMaximumOccuring(str));
        System.out.println(max.findSecondMaximum(str));
    }
}

