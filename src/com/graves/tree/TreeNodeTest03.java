package com.graves.tree;
import org.omg.CORBA.ULongLongSeqHelper;

import java.util.Arrays;
import	java.util.LinkedList;

import java.util.Queue;

/**
 * @author Graves
 * @title: TreeNodeTest03
 * @projectName Algorithm
 * @description: 按层遍历二叉树
 * @date 2020/3/28 22:59
 */
public class TreeNodeTest03 {

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

    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode> ();
        LinkedList<String> linkedList = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if(node.leftChild != null){
                queue.add(node.leftChild);
            }
            if(node.rightChild != null){
                queue.add(node.rightChild);
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
                Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("按层遍历");
        levelOrderTraversal(treeNode);
    }
}
