package BTree;

public class TestArrayBinaryTree {
    public static void main(String[] args) {
        int[] data=new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree=new ArrayBinaryTree(data);
        //前序遍历
        arrayBinaryTree.fontShow();
        System.out.println("\n--------------------");
        //中序遍历
        arrayBinaryTree.midShow();
        System.out.println("\n--------------------");
        //后续遍历
        arrayBinaryTree.afterShow();
        System.out.println("\n--------------------");
    }
}
