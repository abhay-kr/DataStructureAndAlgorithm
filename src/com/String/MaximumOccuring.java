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
                map.remove(i);
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

    public static void main(String Args[]){
        MaximumOccuring max=new MaximumOccuring();
        String str="bbbhay";
        System.out.println(max.findMaximumOccuring(str));
    }
}

