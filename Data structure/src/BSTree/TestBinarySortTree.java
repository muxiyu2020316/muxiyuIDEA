package BSTree;

public class TestBinarySortTree {
    public static void main(String[] args) throws Exception {
        int arr[]=new int[]{7,3,10,12,5,1,9};
        BinarySortTree bst=new BinarySortTree();
        for (int i:arr) {
            //递归添加元素
            bst.add(new Node(i));
        }
        bst.fontShow();
        System.out.println("\n------------");
        bst.midShow();
        System.out.println("\n------------");
        bst.afterShow();
        System.out.println("\n------------");
        bst.MidShow();
        System.out.println("\n------------");
        Node node1=bst.FontSearch(3);
        System.out.println(node1.value);
        System.out.println(bst.AfterSearch(10).value);
        System.out.println(bst.Search(12).value);
        System.out.println("\n------------");
        bst.delete(3);
        bst.midShow();
        System.out.println("\n------------");
        bst.delete(12);
        bst.midShow();
        System.out.println("\n------------");
        bst.delete(10);
        bst.midShow();


    }
}
