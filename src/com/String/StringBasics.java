package com.String;

import java.lang.reflect.Array;

public class StringBasics {

    void reverseSpecial(String str){
        char ary[];
        ary=str.toCharArray();
        int i=0,j=ary.length-1;
        while (i<j){
           if (!Character.isAlphabetic(ary[i])){
               i++;
               continue;
           }
           else if(!Character.isAlphabetic(ary[j])){
               j--;
               continue;
           }
           char a=ary[i];
           ary[i]=ary[j];
           ary[j]=a;
           i++;
           j--;
        }

        System.out.println(new String(ary));
    }

    void removeDuplicacy(String str){

    }

    public static void main(String Args[]){
        StringBasics obj=new StringBasics();
        obj.reverseSpecial("a!!!b.c.d,e'f,ghi");// i!!!h.g.f,e'd,cba

        String str="abhay-kumar-abhay";
        for (int i=0;i< str.split("-").length;i++){
            System.out.print(str.split("-")[i]+"  ");
        }
        System.out.println(str.replace("-",""));

    }
}
