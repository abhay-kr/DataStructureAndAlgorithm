package com;

public class KnapSackProblem {
    class Item{
        int weight;
        int cost;

        Item(int weight,int cost){
            this.weight=weight;
            this.cost=cost;
        }
    }
    void knapSack(Item item[],int tWeight){
        int l=item.length;
        int av[]=new int[l];
        for (int i=0;i<l;i++){
            av[i]=item[i].cost/item[i].weight;
        }
        int k=0,x=av[0],pos=-1;
        for (int i=0;i<l;i++){
            for (int j=0;j<l;j++){
                if (x>k && x<av[j]){
                    x=av[j];
                    pos=j;
                }
            }
            k=x;
            if (tWeight>=item[pos].weight){
                System.out.print("1 * "+ item[pos].cost);
                tWeight-=item[pos].weight;
            }
            else{
                System.out.print(tWeight/item[pos].weight+" *"+item[pos]    );
            }
        }
    }
}
