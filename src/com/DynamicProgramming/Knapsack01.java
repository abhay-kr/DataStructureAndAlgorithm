package com.DynamicProgramming;

public class Knapsack01 {

    void knapsack(int value[],int weight[],int n){
        int tab[][]=new int[value.length+1][n+1];
        for (int i=1;i<tab.length;i++){
            for (int j=1;j<tab[0].length;j++){
                if ((j-weight[i-1])>=0){
                    tab[i][j]=Math.max(tab[i-1][j],(value[i-1]+tab[i-1][j-weight[i-1]]));
                }
                else {
                    tab[i][j]=tab[i-1][j];
                }
            }
        }
        System.out.println(tab[value.length][n]);
        for (int i=0;i<tab.length;i++){
            for (int j=0;j<tab[0].length;j++)
                System.out.print(tab[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String Args[]){
        Knapsack01 knapsack=new Knapsack01();
        int value[]={1,4,5,7};
        int weight[]={1,3,4,5};
        knapsack.knapsack(value,weight,5);
    }
}
