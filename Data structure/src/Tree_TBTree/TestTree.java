package Tree_TBTree;

public class TestTree {

    public static void main(String[] args) {
        //创建一棵树
        BinaryTree binaryTree=new BinaryTree();
        //创建一个节点
        TreeNode root=new TreeNode(1);
        //把根节点赋值给树
         binaryTree.setRoot(root);
         //创建节点
         TreeNode lnode=new TreeNode(2);
         //复制给左节点
         root.setLeftNode(lnode);
        //创建节点
         TreeNode rnode=new TreeNode(3);
        //复制给右节点
         root.setRightNode(rnode);
         //为第二层左节点创建子节点
         lnode.setLeftNode(new TreeNode(4));
         lnode.setRightNode(new TreeNode(5));
        //为第二层右节点创建子节点
         rnode.setLeftNode(new TreeNode(6));
         rnode.setRightNode(new TreeNode(7));
         //遍历二叉树
        System.out.print("前序遍历:");
        binaryTree.fontShow();
        System.out.println("\n-----------------------------------");
        System.out.print("中序遍历:");
        binaryTree.midShow();
        System.out.println("\n-----------------------------------");
        System.out.print("后序遍历:");
        binaryTree.afterShow();
        System.out.println("\n-----------------------------------");
        //前序查找
        TreeNode result1=binaryTree.fontSearch(4);
        System.out.println(result1.value);
        //中查找
        TreeNode result2=binaryTree.midSearch(3);
        System.out.println(result2.value);
        //后序查找
        TreeNode result3=binaryTree.afterSearch(7);
        System.out.println(result3.value);
        System.out.println("\n-----------------------------------");
        binaryTree.delete(2);
        binaryTree.fontShow();
    }
}
