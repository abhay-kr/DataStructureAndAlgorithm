package com.String;

import java.util.HashMap;
import java.util.Map;


public class CheckingAnagram {

    private boolean anagramCheck(String str1,String str2){
        if (str1.length()!=str2.length())
            return false;
        Map<Character,Integer> map=new HashMap<>();
        for (int i=0;i<str1.length();i++){
            char ch=str1.charAt(i);
            if (map.containsKey(ch)){
                int a=map.remove(ch);
                a++;
                map.put(ch,a);
            }
            else {
                map.put(ch,1);
            }
        }
        for (int i=0;i<str2.length();i++){
            char ch=str2.charAt(i);
            if (!map.containsKey(ch))
                return false;
            else{
                int a=map.remove(ch);
                a--;
                if (a==-1)
                    return false;
                map.put(ch,a);
            }
        }
        for (int i=0;i<str1.length();i++){
            int a=map.get(str1.charAt(i));
            if (a!=0)
                return false;
        }
        return true;
    }

    public static void main(String Args[]){
        CheckingAnagram obj=new CheckingAnagram();
        String str1="abhay abhay kumar";
        String str2="abhay kumar abhay";
        System.out.print(obj.anagramCheck(str1,str2));

    }
}
