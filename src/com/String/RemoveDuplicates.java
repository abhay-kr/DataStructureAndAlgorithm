package com.String;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class RemoveDuplicates {

    void remove(String str){
        LinkedHashSet<Character> set=new LinkedHashSet<Character>();
        for (int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        for (int i=0;i<str.length();i++){
            if (set.contains(str.charAt(i))){
                set.remove(str.charAt(i));
                System.out.print(str.charAt(i));
            }
        }
    }


    public static void main(String Args[]){
        RemoveDuplicates obj=new RemoveDuplicates();
        String str="abhay kumar";
        obj.remove(str);
    }
}
