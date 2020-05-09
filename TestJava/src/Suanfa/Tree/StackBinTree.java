package Suanfa.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StackBinTree {
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
     * �������ǵݹ�ǰ�����
     *
     * @param root
     */
    public static void StackPreTraveral(TreeNode root) {
        if (root == null) {
            System.out.println("����");
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //�������ʽڵ�����ӣ�����ջ
            while (treeNode != null) {
                System.out.print(treeNode.data + " ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //����ڵ�û�����ӣ��򵯳�ջ���ڵ㣬���ʽڵ��Һ���
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
        System.out.println();
    }

    /**
     * �������ǵݹ��������
     *
     * @param root
     */
    public static void StackMidTraveral(TreeNode root) {
        if (root == null) {
            System.out.println("����");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        //��վ��Ϊ��,�Ҹ��ڵ㲻Ϊ�յ�ǰ����
        while (treeNode != null || !stack.isEmpty()) {
            //1.�����ڵ���ջ
            //2.������������ջ
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //3.����ջ��Ԫ��
            treeNode = stack.pop();
            System.out.print(treeNode.data + " ");
            //4.���ջ��Ԫ�ش����Һ��ӣ����Һ��Ӹ�ֵ��tmp��Ҳ���ǽ��Һ�����ջ
            if (treeNode.rightChild != null) {
                treeNode = treeNode.rightChild;
            }
            //���򣬽�tmp��Ϊnull����ʾ�´�Ҫ���ʵ���ջ��Ԫ��
            else {
                treeNode = null;
            }
        }
        System.out.println();
    }

    /**
     * �������ǵݹ�������
     *
     * @param root
     */
    public static void StackAfterTraveral(TreeNode root) {
        if (root == null) {
            System.out.println("����");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;//��ǰ�ڵ�
        TreeNode prev = null;//��һ�η��ʵĽڵ�
        while (treeNode != null || !stack.empty()) {
            //1.�����ڵ㼰��������ջ
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.empty()) {
                //2.��ȡջ��Ԫ��ֵ
                treeNode = stack.peek();
                //�ж��Ƿ������ҽڵ�
                //3.û���Һ��ӣ������Һ����Ѿ������ʹ�
                if (treeNode.rightChild == null || treeNode.rightChild == prev) {
                    //����Է���ջ��Ԫ��
                    treeNode = stack.pop();
                    System.out.print(treeNode.data + " ");
                    //�����һ�η��ʵĽڵ�
                    prev = treeNode;
                    treeNode = null;
                } else {
                    treeNode = treeNode.rightChild;
                }
            }
        }
        System.out.println();
    }

    /**
     * �������������������Ĺ��̱���΢����һЩ����Ҫ�õ�����ջ��ʵ��
     *
     * @param root
     */
    public static void NoPostOrder(TreeNode root) {
        //��������ջ
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            // �����Ӿ���ѹ������
            if (root.leftChild != null)
                stack1.push(root.leftChild);
            // ���Һ��Ӿͺ�ѹ���Һ���
            if (root.rightChild != null)
                stack1.push(root.rightChild);
        }
        // �����ӡ �� -> �� -> �� �Ľ�������Ǻ�������Ľ��
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
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
        StackPreTraveral(treeNode);
        System.out.println("���������");
        StackMidTraveral(treeNode);
        System.out.println("���������");
        StackAfterTraveral(treeNode);
        System.out.println("���������");
        NoPostOrder(treeNode);

    }
}
