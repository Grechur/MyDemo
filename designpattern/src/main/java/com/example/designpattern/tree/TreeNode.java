package com.example.designpattern.tree;

/**
 * @ClassName: TreeNode
 * @Description: java类作用描述
 * @Author: Grechur
 * @Date: 2019/10/9 10:30
 */
public class TreeNode {
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private String value;

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value='" + value + '\'' +
                ", leftTreeNode=" + leftTreeNode +
                ", rightTreeNode=" + rightTreeNode +
                '}';
    }
}

