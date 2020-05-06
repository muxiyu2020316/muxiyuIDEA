package List;

public class TestNode {
    public static void main(String[] args) {
        //创建节点
        Nodes nodes1 =new Nodes(1);
        Nodes nodes2 =new Nodes(2);
        Nodes nodes3 =new Nodes(111);
        //追加节点,无限制追加
        nodes1.append(nodes2).append(nodes3).append(new Nodes(222));
        nodes1.show();
        //判断是否是最后一个节点
        System.out.println(nodes1.next.isLast());
        // 插入一节点
             Nodes nodes5 =new Nodes(333);
             nodes1.next.after(nodes5);
             nodes1.show();
             //删除节点
             nodes1.RemoveNext();
            //取出下一节点的数据
        System.out.println("\n"+ nodes1.next.next.getData());
             nodes1.show();
    }
}
