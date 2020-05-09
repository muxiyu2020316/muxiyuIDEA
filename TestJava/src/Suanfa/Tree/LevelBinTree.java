package Suanfa.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LevelBinTree {
    /**
     * ����������
     *
     * @param inputList ��������
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        //������пպܹؼ������Ԫ���ǿգ�˵���ýڵ㲻���ڣ�������һ��ݹ飻���Ԫ�طǿգ������ݹ鹹���ýڵ�����Һ��ӡ�
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * �������������
     *
     * @param root ���������ڵ�
     */
    public static void leveTrave(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            //������ӽڵ㲻Ϊ��,��������ӽڵ���ӽڵ㵽����
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            //������ӽڵ㲻Ϊ��,��������ӽڵ�������ӽڵ㵽����
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
        System.out.println();
    }

    /**
     * �������ڵ�
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
        System.out.println("���������");
        leveTrave(treeNode);
    }
}
