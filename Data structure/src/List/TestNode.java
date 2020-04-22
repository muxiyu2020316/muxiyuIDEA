package List;

public class TestNode {
    public static void main(String[] args) {
        //创建节点
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(111);
        //追加节点,无限制追加
        node1.append(node2).append(node3).append(new Node(222));
        node1.show();
        //判断是否是最后一个节点
        System.out.println(node1.next.isLast());
        // 插入一节点
             Node node5=new Node(333);
             node1.next.after(node5);
             node1.show();
             //删除节点
             node1.RemoveNext();
            //取出下一节点的数据
        System.out.println("\n"+node1.next.next.getData());
             node1.show();
    }
}
