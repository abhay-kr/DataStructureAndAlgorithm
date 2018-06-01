package com.String;

import java.util.HashMap;

public class StringPermutation {

    char s[];
    int x[];
    char res[];
    void pattern(String str) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i=0;i<str.length();i++){
            if (map.containsKey(str.charAt(i)+"")){
                int x=map.remove(str.charAt(i)+"");
                x++;
                map.put(str.charAt(i)+"",x);
                x=0;
            }
            else {
                map.put(str.charAt(i)+"",1);
            }
        }
        s=new char[map.size()];
        x=new int[map.size()];
        System.out.println(map);
        int count=0;
        for (int i=0;i<str.length();i++){
            String key=str.charAt(i)+"";
            if (map.containsKey(key)){
                x[count]=map.remove(key);
                s[count]=str.charAt(i);
                count++;
            }
        }
        res=new char[str.length()];
        permutationUtil(s,x,res,0);
    }

    void permutationUtil(char s[],int x[],char res[],int depth){
        if (depth==res.length){
            printResult(res);
            return;
        }
        for (int i=0;i<s.length;i++){
            if (x[i]==0){
                continue;
            }
            res[depth]=s[i];
            x[i]--;
            permutationUtil(s,x,res,depth+1);
            x[i]++;
        }

    }

    void printResult(char res[]){
        String st="";
        for (int i=0;i<res.length;i++)
            System.out.print(res[i]);
        System.out.println();
    }

    public static void main(String Args[]){
        StringPermutation stringPermutation =new StringPermutation();
        String str="aacde";
        stringPermutation.pattern(str);
    }
}
