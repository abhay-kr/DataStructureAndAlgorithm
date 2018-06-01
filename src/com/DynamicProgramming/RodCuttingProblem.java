package com.DynamicProgramming;

public class RodCuttingProblem {
    void findMaximumPrice(int val[],int len[],int n){
        int tab[][]=new int[val.length+1][n+1];
        for (int i=1;i<tab.length;i++){
            for (int j=1;j<tab[0].length;j++){
                if (((j-i)>=0)){
                    tab[i][j]=Math.max(tab[i-1][j],val[i-1]+tab[i][j-i]);
                }
                else {
                    tab[i][j]=tab[i-1][j];
                }
            }
        }
        for (int i=0;i<tab.length;i++){
            for (int j=0;j<tab[0].length;j++)
                System.out.print(tab[i][j] +" ");
            System.out.println();
        }
        System.out.print(tab[tab.length-1][n]);
//        for (int i=0)

    }
    public static void main(String Args[]){
        int val[]={1,5,8,9,10,17,17,20,24,30};
        int len[]={1,2,3,4,5,6,7,8,9,10};
        RodCuttingProblem cuttingProblem=new RodCuttingProblem();
        cuttingProblem.findMaximumPrice(val,len,9);
    }
}
