package com.String;

public class CharacterCount {

    int count(String str){
        str=str.toLowerCase();
        int count=0;
        for (int i=0;i<str.length();i++){
            if ((int)str.charAt(i)-97==i) {
                count++;
            }
        }
        return count;
    }

    public static void main(String Args[]){
        CharacterCount obj=new CharacterCount();
        System.out.println(obj.count("alphabetical"));
    }
}
