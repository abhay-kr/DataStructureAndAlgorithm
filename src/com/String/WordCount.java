package com.String;

import java.util.HashMap;

public class WordCount {

    int countWord(String str){
        str=str.trim();
        if (str.equals(""))
            return 0;
        int count=1;
        int n=str.length();
        str=str.concat(" ");
        for (int i=0;i<n;i++){
            char temp1=str.charAt(i);
            char temp2=str.charAt(i+1);
            if ((temp1==' ' || temp1=='\n' || temp1=='\t') && (temp2!=' ' && temp2!='\n' && temp2!='\t')){
                count++;
            }
        }
        return count;
    }

//    i-th letter is either (i-1)-th, i-th, or (i+1)-th letter
    int countWordSpecial(String str){
        if (str.length()==1)
            return 1;
        int count=1;
        str=str.toLowerCase();
        for (int i=0;i<str.length();i++){
            if (i==0){
                if (str.charAt(i)==str.charAt(i+1));
                else {
                    count=count*2;
                }
            }
            else if (i==str.length()-1){
                if (str.charAt(i-1)==str.charAt(i));
                else {
                    count=count*2;
                }
            }
            else if (i!=0  && i!=str.length()-1){
                if (str.charAt(i)!=str.charAt(i-1) && str.charAt(i)!=str.charAt(i+1)){
                    count=count*3;
                }
                else if(str.charAt(i)==str.charAt(i-1) && str.charAt(i)!=str.charAt(i+1)){
                    count=count*2;
                }
                else if (str.charAt(i)!=str.charAt(i-1) && str.charAt(i)==str.charAt(i+1)){
                    count=count*2;
                }
                else if(str.charAt(i)==str.charAt(i-1) && str.charAt(i)==str.charAt(i+1)){

                }
            }
        }

        return count;
    }

    char maximumRepeatedCharacter(String str){
        char temp=str.charAt(0);
        char temp1=str.charAt(1);
        int count=0;
        int count1=0;
        char strtemp=' ';
        for (int i=1;i<str.length();i++){
            temp=str.charAt(i-1);
            temp1=str.charAt(i);
            if (temp==temp1){
                count++;
            }
            else if (temp1!=temp){
                count=0;
            }
            if (count>count1){
                count1=count;
                strtemp=temp1;
            }
        }
        return strtemp;
    }

    void permutationString(String str,int n){
        HashMap<Character,Integer> map =new HashMap<>();
        for (int i=0;i<n;i++){
            str=str.concat("a");
        }
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.containsKey(ch)){
                int temp=map.remove(ch);
                temp++;
                map.put(ch,temp);
            }
            else {
                map.put(ch,1);
            }
        }
        char chAry[]=new char[map.size()];
        int intAry[]=new int[map.size()];
        int cnt=0;
        System.out.println(map);
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (map.containsKey(ch)){
               chAry[cnt]=ch;
               intAry[cnt]=map.remove(ch);
               cnt++;
            }
        }
        char res[]=new char[n];
        permutationUtil(chAry,intAry,res,0);
    }
    void permutationUtil(char chAry[],int intAry[],char res[],int resLen){
        if (resLen==res.length){
            print(res);
            return;
        }
        for (int i=0;i<chAry.length;i++){
            if (intAry[i]==0)
                continue;
            res[resLen]=chAry[i];
            intAry[i]--;
            permutationUtil(chAry, intAry, res, resLen+1);
            intAry[i]++;
        }
    }
    void print(char res[]){
        for (int i=0;i<res.length;i++){
            System.out.print(res[i]);
        }
        System.out.println();
    }

    public static void main(String Args[]){
        WordCount obj=new WordCount();
        String str="One two       three\n\n\\n four\tfive  ";
        System.out.println(obj.countWord(str)+"");
        System.out.println(obj.countWordSpecial("abbc"));
        System.out.println(obj.maximumRepeatedCharacter("geeekk"));
        obj.permutationString("bbc",4);
    }
}
