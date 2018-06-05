package com.String;

import java.util.HashMap;

public class MinimumWindow {

    String minwin(String str, String ptn){
        HashMap <Character, Integer> map=new HashMap<>();

        for (int i=0;i<ptn.length();i++){
            char tempch=ptn.charAt(i);
            if (map.containsKey(tempch)){
                int temp=map.remove(tempch);
                temp++;
                map.put(tempch,temp);
            }
            else {
                map.put(tempch,1);
            }
        }
        int ptr1=-1,ptr2=-1;
        for (int i=0;i<str.length();i++){
            if (ptr1==-1){
                if (map.containsKey(str.charAt(i))){

                }
            }
        }
        return "abcd";
    }

    public static void main(String Args[]){

        String str="this is a test string";
        String prn="tist";

    }
}
