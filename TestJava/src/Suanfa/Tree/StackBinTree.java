package Suanfa.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StackBinTree {
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
        //这里的判空很关键。如果元素是空，说明该节点不存在，跳出这一层递归；节点不存在就无法构建子树
        // 如果元素非空，继续递归构建该节点的左右孩子。
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * 二叉树非递归前序遍历
     *
     * @param root
     */
    public static void StackPreTraveral(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.print(treeNode.data + " ");
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
        System.out.println();
    }

    /**
     * 二叉树非递归中序遍历
     *
     * @param root
     */
    public static void StackMidTraveral(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        //在站不为空,且根节点不为空的前提下
        while (treeNode != null || !stack.isEmpty()) {
            //1.将根节点入栈
            //2.将所有左孩子入栈
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //3.访问栈顶元素
            treeNode = stack.pop();
            System.out.print(treeNode.data + " ");
            //4.如果栈顶元素存在右孩子，则将右孩子赋值给tmp，也就是将右孩子入栈
            if (treeNode.rightChild != null) {
                treeNode = treeNode.rightChild;
            }
            //否则，将tmp置为null，表示下次要访问的是栈顶元素
            else {
                treeNode = null;
            }
        }
        System.out.println();
    }

    /**
     * 二叉树非递归后序遍历
     *
     * @param root
     */
    public static void StackAfterTraveral(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;//当前节点
        TreeNode prev = null;//上一次访问的节点
        while (treeNode != null || !stack.empty()) {
            //1.将根节点及其左孩子入栈
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.empty()) {
                //2.获取栈顶元素值
                treeNode = stack.peek();
                //判断是否有左右节点
                //3.没有右孩子，或者右孩子已经被访问过
                if (treeNode.rightChild == null || treeNode.rightChild == prev) {
                    //则可以访问栈顶元素
                    treeNode = stack.pop();
                    System.out.print(treeNode.data + " ");
                    //标记上一次访问的节点
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
     * 后续遍历，后续遍历的过程比稍微复杂一些，需要用到两个栈来实现
     *
     * @param root
     */
    public static void NoPostOrder(TreeNode root) {
        //创建两个栈
        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            root = stack1.pop();
            stack2.push(root);
            // 有左孩子就先压入左孩子
            if (root.leftChild != null)
                stack1.push(root.leftChild);
            // 有右孩子就后压入右孩子
            if (root.rightChild != null)
                stack1.push(root.rightChild);
        }
        // 逆序打印 根 -> 右 -> 左 的结果，就是后序遍历的结果
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
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

    /**
     * 把一个线性的链表转化成非线性的二叉树，链表节点的顺序恰恰是二
     * 叉树前序遍历的顺序。链表中的空值，代表二叉树节点的左孩子或右孩子为空的情况
     *
     * @param args
     */
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[]{3, 2, 9, null, null, 10, null, null, 8, null, 4,}));
        //输入序列创建二叉树
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历：");
        StackPreTraveral(treeNode);
        System.out.println("中序遍历：");
        StackMidTraveral(treeNode);
        System.out.println("后序遍历：");
        StackAfterTraveral(treeNode);
        System.out.println("后序遍历：");
        NoPostOrder(treeNode);

    }
}
