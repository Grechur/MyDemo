package com.example.designpattern.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zz on 2018/7/13.
 */

public class Tree {
    static class  TreeNode {
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "left=" + left +
                    ", right=" + right +
                    ", val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(15);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1 = new TreeNode(20);
        root.left = left;
        root.right = right;
        right.left = left1;
        right.right = right1;
//        System.out.println(maxDepth(root));
//        System.out.println(isValidBST(root));

//        System.out.println(levelOrder(root));
//        int[] nums = {-10,-3,0,5,9};
//        System.out.println(sortedArrayToBST(nums));


        String  s= "acbdsacdacds";
        String str = s.replace("ac","bc");
        System.out.println(str);
        //查找字串的位置
        Pattern pattern = Pattern.compile("ac");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()){
            System.out.println(matcher.group());
            System.out.println(matcher.start());
        }

    }


    /**
     * 二叉树的深度
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }

    /**
     * 判断二叉树是否为BST树
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }

    /**
     *二叉树每层的数据的集合
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null ) return lists;
        levelTree(lists,0,root);

        return lists;
    }

    private static void levelTree(List<List<Integer>> lists, int level, TreeNode treeNode) {
        if(treeNode==null) return;
        if(lists.size()-1<level) lists.add(new ArrayList<>());
        lists.get(level).add(treeNode.val);

        int next = level+1;
        levelTree(lists,next,treeNode.left);
        levelTree(lists,next,treeNode.right);

    }


    /**
     * 数组变为BST树
     * @param nums
     * @return
     */
    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0)
            return null;
        return getTree(nums,0,nums.length - 1);
    }

    public static TreeNode getTree(int []nums,int l,int r){
        if(l <= r){
            int mid = (l+r)/2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getTree(nums,l,mid-1);
            node.right = getTree(nums,mid+1,r);
            return node;
        }else{
            return null;
        }
    }


}
