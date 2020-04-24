package AVLTrees;

public class TestAVLTree {
    public static void main(String[] args) throws Exception {
        int arr[]=new int[]{8,9,6,7,5,4};
        AVLTree bst=new AVLTree();
        int a[]=new int[]{1,2,3,4,5,6,7,8};
        AVLTree avt=new AVLTree();
        for (int i:arr) {
            //递归添加元素
            bst.add(new Node(i));
        }
        for (int i:a) {
            //递归添加元素
            avt.add(new Node(i));
        }
//        bst.fontShow();
//        System.out.println("\n------------");
//        bst.midShow();
//        System.out.println("\n------------");
//        bst.afterShow();
//        System.out.println("\n------------");
//        bst.MidShow();
//        System.out.println("\n------------");
//        Node node1=bst.FontSearch(3);
//        System.out.println(node1.value);
//        System.out.println(bst.AfterSearch(10).value);
//        System.out.println(bst.Search(12).value);
//        System.out.println("\n------------");
//        bst.delete(3);
//        bst.midShow();
//        System.out.println("\n------------");
//        bst.delete(12);
//        bst.midShow();
//        System.out.println("\n------------");
//        bst.delete(10);
//        bst.midShow();
         //查看节点高度
         System.out.println(bst.root.height());
         System.out.println(avt.root.height());
         System.out.println(avt.root.rightHeight());
         System.out.println(avt.root.leftHeight());
         avt.fontShow();

    }
}
