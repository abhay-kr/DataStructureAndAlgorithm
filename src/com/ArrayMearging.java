package com;


public class ArrayMearging {
    void merge(int ary1[],int ary2[]){
        int len1=ary1.length;
        int len2=ary2.length;
        int ary[]=new int[len1+len2];
        int x=0,y=0;
        for (int i=0;i<ary.length;i++){
            if (x<len1 && y<len2) {
                if (ary1[x] < ary2[y]) {
                    ary[i] = ary1[x];
                    x++;
                } else if (ary1[x] >= ary2[y]) {
                    ary[i] = ary2[y];
                    y++;
                }
            }
            else if (x>=len1){
               ary[i]=ary2[y];
               y++;
            }
            else if (y>=len2){
                ary[i]=ary1[x];
                x++;
            }
        }
        for (int i=0;i<ary.length;i++)
            System.out.print(ary[i]+" ");
    }
    public static void main(String Args[]){
        ArrayMearging obj=new ArrayMearging();
        int ary1[]={5,8,9,9,10,13,14,16,20};
        int ary2[]={7,13,18,22,24,28};
        obj.merge(ary1,ary2);
    }
}
