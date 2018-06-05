package com.String;

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

    public static void main(String Args[]){
        WordCount obj=new WordCount();
        String str="One two       three\n\n\\n four\tfive  ";
        System.out.println(obj.countWord(str)+"");
        System.out.println(obj.countWordSpecial("abbc"));

    }
}
