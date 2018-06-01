package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class TreeNode {
    int num;
    TreeNode left;
    TreeNode right;

    public TreeNode(int num) {
        this.num = num;
        left = null;
        right = null;
    }
}

class Insertion{
    TreeNode root=null;
    public void addNode(int x){
        TreeNode temp=new TreeNode(x);
        if (root==null){
            root=temp;
        }
        else {
            TreeNode focusNode=root;
            TreeNode parent;
            while(true) {
                parent=focusNode;
                if (x < focusNode.num) {
                    focusNode = focusNode.left;
                    if(focusNode==null) {
                        parent.left = temp;
                        return;
                    }
                }
                else{
                    focusNode=focusNode.right;
                    if(focusNode==null) {
                        parent.right = temp;
                        return;
                    }
                }
            }
        }
    }


    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node.left!=null)
                queue.add(node.left);
            if (node.right!=null)
                queue.add(node.right);
            System.out.println(node.num);
        }
    }

    void inorderWithoutRecusion(TreeNode root){
        //if root element is null just return
        if (root==null){return;}
        //we will create a stack for recursive iteration
        Stack <TreeNode> stack=new Stack<>();

        while(true){
            if(root!=null){
                // we'll push the root to the stack
                stack.push(root);
                // we'll keep pushing it's left untill left becomes null
                root=root.left;
            }
            else {
                // we will return if the stack is empty and root is null
                if(stack.empty()){return;}
                else {
                    // if stack is not empty and root is null we will pop the element from stack
                    root=stack.pop();
                    //to print the data
                    System.out.println(root.num);
                    //assign the root to root->right
                    root=root.right;
                }
            }
        }
    }

void reverseLevelOrder(TreeNode root){
        if (root==null){return;}
        Queue <TreeNode> queue=new LinkedList<>();
        Stack <TreeNode> stack=new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()){
            root=queue.poll();
            stack.push(root);
            if(root.right!=null)
                queue.offer(root.right);
            if (root.left!=null)
                queue.offer(root.left);
        }
        while(!stack.empty()){
            System.out.println(stack.pop().num);
        }
}

int countingHalfNode(TreeNode root){
    if (root==null){return 0;}
    int count=0;
    Queue <TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()){
        TreeNode temp=queue.poll();
        if (temp.left!=null)
            queue.offer(temp.left);
        if (temp.right!=null)
            queue.offer(temp.right);
        if((temp.left==null && temp.right!=null) || (temp.left!=null && temp.right==null))
            count++;
    }
    return count;
}

void levelOrderLineByLine(TreeNode root){
    if (root==null){return;}
    Queue <TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    while (true){
        int nodeCount=queue.size();
        if (nodeCount==0){
            break;
        }
        while(nodeCount>0){
            TreeNode temp=queue.poll();
            System.out.print(temp.num +" ");
            if (temp.left!=null)
                queue.offer(temp.left);
            if (temp.right!=null)
                queue.offer(temp.right);
            nodeCount--;
        }
        System.out.println();
    }
}

int countLeafNode(TreeNode root){
    if (root==null){return 0;}
    Queue <TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    int count=0;
    while (!queue.isEmpty()){
        root=queue.poll();
        if (root.left!=null)
            queue.offer(root.left);
        if (root.right!=null)
            queue.offer(root.right);
        if (root.right==null && root.left==null)
            count++;
    }
    return count;
}

int countFullNode(TreeNode root){
    if(root==null){return 0;}
    Queue <TreeNode> queue=new LinkedList<>();
    queue.offer(root);
    int count=0;
    while (!queue.isEmpty()){
        root=queue.poll();
        if (root.left!=null)
            queue.offer(root.left);
        if (root.right!=null)
            queue.offer(root.right);
        if (root.left!=null && root.right!=null)
            count++;
    }
    return count;
}
/*Morris inOrder Traversal
T(n)=O(n)
S(n)=O(1)
  */


void morisInorderTraversal(TreeNode root){
    if (root==null){return;}
    TreeNode current=root;
    while (current!=null){
//        If left is null then print the left and go to right
        if (current.left==null){
            System.out.println(current.num);
            current=current.right;
        }
        else {
//            Find the predecessor
//            To find the predecessor first go to left then go to right till right points to null
            TreeNode predecessor=current.left;
            while(predecessor.right!=null && predecessor.right!=current){
                predecessor=predecessor.right;
            }
//            if right is null then point the right of predecessor to the current so that there must
//            be path between predecessor to current node and make current to current->left
            if (predecessor.right==null){
                predecessor.right=current;
                current=current.left;
            }
//            if not it means left is already visited then remove the link ie make predecessor-> right ==NULL
//            and print the current and make current to current->right
            else {
                predecessor.right=null;
                System.out.println(current.num);
                current=current.right;
            }
        }
    }
}

    public static void main(String[] args){
        Insertion insertion=new Insertion();
        insertion.addNode(3);
        insertion.addNode(6);
        insertion.addNode(4);
        insertion.addNode(1);
        insertion.addNode(2);
        insertion.addNode(5);
        insertion.addNode(7);
//        insertion.addNode(1);
//        insertion.addNode(2);
//        insertion.addNode(3);
//        insertion.addNode(4);
//        insertion.addNode(5);
//        insertion.addNode(6);
        System.out.println("Level Order Traversal");
        insertion.levelOrderTraversal(insertion.root);
        System.out.println("Inorder Traversal Without Recursion");
        insertion.inorderWithoutRecusion(insertion.root);
        System.out.println("Reverse Level Order Traversal");
        insertion.reverseLevelOrder(insertion.root);
        System.out.println("The number of Half Nodes are: ");
        System.out.println(insertion.countingHalfNode(insertion.root));
        System.out.println("Level Order Line By Line");
        insertion.levelOrderLineByLine(insertion.root);
        System.out.println("The number of leaf node are: ");
        System.out.println(insertion.countLeafNode(insertion.root));
        System.out.println("The number of Full node are: ");
        System.out.println(insertion.countFullNode(insertion.root));
        System.out.println("Morris Inorder Traversal");
        insertion.morisInorderTraversal(insertion.root);
    }
}

