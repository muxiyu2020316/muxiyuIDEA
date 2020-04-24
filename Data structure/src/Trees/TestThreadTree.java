package Trees;

public class TestThreadTree {

    public static void main(String[] args) {
        //创建一棵树
        ThreadBinaryTree binaryTree=new ThreadBinaryTree();
        //创建一个节点
        ThreadTreeNode root=new ThreadTreeNode(1);
        //把根节点赋值给树
         binaryTree.setRoot(root);
         //创建节点
        ThreadTreeNode lnode=new ThreadTreeNode(2);
         //复制给左节点
         root.setLeftNode(lnode);
        //创建节点
        ThreadTreeNode rnode=new ThreadTreeNode(3);
        //复制给右节点
         root.setRightNode(rnode);
         //为第二层左节点创建子节点
         lnode.setLeftNode(new ThreadTreeNode(4));
         lnode.setRightNode(new ThreadTreeNode(5));
        //为第二层右节点创建子节点
        rnode.setLeftNode(new ThreadTreeNode(6));
         rnode.setRightNode(new ThreadTreeNode(7));
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
        ThreadTreeNode result1=binaryTree.fontSearch(5);
        System.out.println(result1);
        //中序序查找
        ThreadTreeNode result2=binaryTree.midSearch(8);
        System.out.println(result2);
        //前序查找
        ThreadTreeNode result3=binaryTree.afterSearch(1);
        System.out.println(result3);
        System.out.println("\n-----------------------------------");
//        binaryTree.delete(3);
//        binaryTree.fontShow();
//        System.out.println("\n-----------------------------------");
        System.out.print("前序遍历:");
        binaryTree.fontShow();
        System.out.println("\n-----------------------------------");
        System.out.print("中序遍历:");
        binaryTree.midShow();
        System.out.println("\n-----------------------------------");
        System.out.println("中序线索化");
        binaryTree.midthreadNode();
        ThreadTreeNode afternode1=root.rightNode;
        ThreadTreeNode afternode2=root.leftNode;
        System.out.println(afternode2.value+"-"+afternode1.value);
        System.out.println("中序遍历线索二叉树");
        binaryTree.threadIterate();
        System.out.println("\n-----------------------------------");
        System.out.println("前序线索化");
        binaryTree.fontthreadNode();
        ThreadTreeNode afternode=rnode.leftNode;
        ThreadTreeNode prenode=rnode.rightNode;
        System.out.println(afternode.value+"-"+prenode.value);
        System.out.println("前序遍历线索二叉树");
        binaryTree.preThreadIterate(root);
    }
}
