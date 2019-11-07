package com.example.designpattern.tree;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.tree
 * @ClassName: AVLNode
 * @Description: 平衡二叉树
 * @Author: Grechur
 * @CreateDate: 2019/10/9 11:52
 * @UpdateUser: Grechur
 * @UpdateDate: 2019/10/9 11:52
 */
public class AVLNode {
    public AVLNode parent;
    public AVLNode leftChild, rightChild;
    public int data;

    public AVLNode(AVLNode parent, AVLNode leftChild, AVLNode rightChild, int data) {
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.data = data;
    }

    public AVLNode(int data) {
        this(null, null, null, data);
    }

    public AVLNode(AVLNode parent, int data) {
        this.parent = parent;
        this.data = data;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                " data=" + data +
                ",leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
