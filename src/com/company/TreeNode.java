package com.company;

public class TreeNode implements Comparable<TreeNode> {

    private Occurrency value;

    private TreeNode left, right;

    public TreeNode(Occurrency val, TreeNode left, TreeNode right) {
        this.value = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Occurrency val) {
        this.value = val;
    }

    public void setLeft(TreeNode lft) {
        this.left = lft;
    }

    public void setRight(TreeNode rgt) {
        this.right = rgt;
    }

    public Occurrency getVal() {
        return this.value;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }


    public int compareTo(TreeNode root) {
        return this.value.compareTo(root.value);
    }
}
