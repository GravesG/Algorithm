package com.graves.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author Graves
 * @title: TreeNodeTest02
 * @projectName Algorithm
 * @description: 非递归遍历二叉树
 * @date 2020/3/28 22:16
 */
public class TreeNodeTest02 {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * @return void
     * @Author Graves
     * @Description //先序
     * @Date 22:22
     * @Param [root]
     */
    public static void preOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            // 迭代访问节点得左孩子，并 入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            // 如果没有左孩子，则弹出栈顶，访问节点得右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
    * @Author Graves
    * @Description //中序
    * @Date  22:31
    * @Param [root]
    * @return void
    */
    public static void inOrderTraveralWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历");
        preOrderTraveralWithStack(treeNode);
        System.out.println("中序遍历");
        inOrderTraveralWithStack(treeNode);
//        System.out.println("后序遍历");
//        postOrderTraveral(treeNode);
    }
}
