package Suanfa.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelBinTree {
    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；如果元素非空，继续递归构建该节点的左右孩子。
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树层序遍历
     *
     * @param root 二叉树根节点
     */
    public static void leveTrave(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            //如果左子节点不为空,就添加左子节点的子节点到队列
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            //如果右子节点不为空,就添加右子节点的左右子节点到队列
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
        System.out.println();
    }

    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4,}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("层序遍历：");
        leveTrave(treeNode);
    }
}
