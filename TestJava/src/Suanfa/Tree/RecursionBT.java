package Suanfa.Tree;

import javax.swing.tree.TreeNode;
import java.util.Arrays;
import java.util.LinkedList;

public class RecursionBT {
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
        //������пպܹؼ������Ԫ���ǿգ�˵���ýڵ㲻���ڣ�������һ��ݹ飻�ڵ㲻���ھ��޷���������
        // ���Ԫ�طǿգ������ݹ鹹���ýڵ�����Һ��ӡ�
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * ������ǰ�����
     *
     * @param node �������ڵ�
     */
    public static void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.leftChild);
        preOrderTraversal(node.rightChild);
    }

    /**
     * �������������
     *
     * @param node �������ڵ�
     */
    public static void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraversal(node.rightChild);
    }

    /**
     * �������������
     *
     * @param node �������ڵ�
     */
    public static void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.leftChild);
        postOrderTraversal(node.rightChild);
        System.out.print(node.data + " ");
    }

    /**
     * �������ڵ�
     */
    public static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * ��һ�����Ե�����ת���ɷ����ԵĶ�����������ڵ��˳��ǡǡ�Ƕ�
     * ����ǰ�������˳�������еĿ�ֵ������������ڵ�����ӻ��Һ���Ϊ�յ����
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4,}));
        //�������д���������
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("ǰ�������");
        preOrderTraversal(treeNode);
        System.out.println("\n���������");
        inOrderTraversal(treeNode);
        System.out.println("\n���������");
        postOrderTraversal(treeNode);
    }
}
