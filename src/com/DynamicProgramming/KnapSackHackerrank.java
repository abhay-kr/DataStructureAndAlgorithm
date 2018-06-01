package com.DynamicProgramming;


public class KnapSackHackerrank {

    static int unboundedKnapsack(int k, int[] arr) {
        int tab[][]=new int[arr.length+1][k+1];
        for (int i=1;i<tab.length;i++){
            for (int j=1;j<tab[0].length;j++){
                if ((j-arr[i-1])>=0){
                    tab[i][j]=Math.max(tab[i-1][j],arr[i-1]+tab[i][j-arr[i-1]]);
                }
                else{
                    tab[i][j]=tab[i-1][j];
                }
            }
        }
        for (int i=0;i<tab.length;i++){
            for (int j=0;j<tab[0].length;j++)
                System.out.print(tab[i][j]+" ");
            System.out.println();
        }
        return (tab[arr.length][k]);
    }

    public static void main(String[] args){
        int arr[]={2,3,4};
        System.out.print(unboundedKnapsack(10,arr));
    }
}
