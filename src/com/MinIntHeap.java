package com;

public class MinIntHeap {

    private int capacity=10;
    private int size=0;

    int items[]=new int[capacity];

    private int getLeftIndex(int parentIndex){return 2*parentIndex+1;}
    private int getRightIndex(int parentIndex){return 2*parentIndex+2;}
    private int getParent(int childIndex){return (childIndex-1)/2;}

//    private boolean

}