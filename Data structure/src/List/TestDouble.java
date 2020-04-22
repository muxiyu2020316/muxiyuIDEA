package List;

public class TestDouble {
    public static void main(String[] args) {
        DoubleNode node1=new DoubleNode(1);
        DoubleNode node2=new DoubleNode(2);
        DoubleNode node3=new DoubleNode(3);
        //增加节点
        node1.after(node2);
        node2.after(node3);

        //验证
        System.out.print(node2.pre().getData()+"->");
        System.out.print(node2.getData()+"->");
        System.out.print(node2.next().getData()+"->");
        System.out.print(node1.pre().getData()+"->");
        System.out.print(node3.next().getData()+"->");

    }
}
