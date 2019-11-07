package com.example.designpattern.tree;

/**
 * @ProjectName: MyDemo
 * @Package: com.example.designpattern.tree
 * @ClassName: BinaryTree
 * @CreateDate: 2019/10/9 10:38
 * @UpdateDate: 2019/10/9 10:38
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class BinaryTree {
    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    /**
     * 插入二叉树排序 有序插入 （大于根节点放右边 小于根节点放左边）
     * @param value
     */
    public void insert(String value){
        TreeNode newNode = new TreeNode(value);
        if(root == null){
            root = newNode;
            root.setLeftTreeNode(null);
            root.setRightTreeNode(null);
        }else{
            TreeNode currentNode = root;
            TreeNode parentNode;
            // 有孩子继续循环，一直循环到最后一个节点 和插入的节点比较 大的放到右节点，小于放到左节点
            while (true){
                parentNode = currentNode;
                //向右放
                if(Integer.valueOf(newNode.getValue())>Integer.valueOf(currentNode.getValue())){
                    currentNode = currentNode.getRightTreeNode();
                    if(currentNode == null){
                        parentNode.setRightTreeNode(newNode);
                        return;
                    }
                }else{
                    //向左放
                    currentNode = currentNode.getLeftTreeNode();
                    if(currentNode == null){
                        parentNode.setLeftTreeNode(newNode);
                        return;
                    }
                }
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param treeNode
     */
    public void inOrder(TreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.getLeftTreeNode());
            System.out.print(" " + treeNode.getValue() + " ");
            inOrder(treeNode.getRightTreeNode());
        }
    }

    /**
     * 后序遍历
     *
     * @param treeNode
     */
    public void afterOrder(TreeNode treeNode) {
        if (treeNode != null) {
            afterOrder(treeNode.getLeftTreeNode());
            afterOrder(treeNode.getRightTreeNode());
            System.out.print(" " + treeNode.getValue() + " ");
        }
    }

    /**
     * 先序遍历
     *  先访问根节点，再访问左节点，再访问右节点
     * @param treeNode
     */
    public void beforeOrder(TreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(" " + treeNode.getValue() + " ");
            beforeOrder(treeNode.getLeftTreeNode());
            beforeOrder(treeNode.getRightTreeNode());
        }
    }

    /**
     * 递归求深度
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 计算左子树的深度
        int left = treeDepth(root.getLeftTreeNode());
        // 计算右子树的深度
        int right = treeDepth(root.getRightTreeNode());

        System.out.println(root.getValue() + " " + left + " " + right);
        // 树root的深度=路径最长的子树深度 + 1
        return left >= right ? (left + 1) : (right + 1);
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert("52");
        tree.insert("7");
        tree.insert("45");
        tree.insert("8");
        tree.insert("6");
        tree.insert("21");
        tree.insert("32");
        tree.insert("9");
        tree.insert("1");
        tree.insert("30");
        System.out.println("插入完成"+tree.root);
        System.out.print("先序遍历");
        tree.beforeOrder(tree.getRoot());
        System.out.println();
        System.out.print("中序遍历");
        tree.inOrder(tree.getRoot());
        System.out.println();
        System.out.print("后序遍历");
        tree.afterOrder(tree.getRoot());

        System.out.println();
        int depth = tree.treeDepth(tree.root);
        System.out.print("高度："+depth);
    }


}
