package com.DynamicProgramming;

public class MatrixChainMultiplication {

    void matrixChain(int p[]){
        int n=p.length-1;//6
        int m[][]=new int[n][n];
        int s[][]=new int[n][n];
        for (int i=0;i<n;i++)
            m[i][i]=0;
        for (int l=1;l<n;l++){
            for (int i=0;i<(n-l);i++){
                int j=i+l;
                m[i][j]=555555;
                for (int k=i;k<j;k++){
                    int q=m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if (q<m[i][j]){
                        m[i][j]=q;
                        s[i][j]=k;
                    }
                }
            }
        }
        System.out.println(m[0][n-1]);
        for (int i=0;i<m.length;i++){
            for (int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println();
        }
        MatrixChainMultiplication obj=new MatrixChainMultiplication();
        obj.printOptimalParenthesis(s,0,n-1);
    }

    void printOptimalParenthesis(int s[][], int i,int j){
        if (i==j)
            System.out.print("A"+(i+1)+" ");
        else {
            System.out.print("(");
            printOptimalParenthesis(s,i,s[i][j]);
            printOptimalParenthesis(s,s[i][j]+1,j);
            System.out.print(")");
        }
    }

    public static void main(String Args[]){
        MatrixChainMultiplication obj=new MatrixChainMultiplication();
        int ary[]={30,35,15,5,10,20,25};
        obj.matrixChain(ary);
    }
}
