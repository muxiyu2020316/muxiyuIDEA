package List;

public class TestLoopNode {
    public static void main(String[] args) {
        //创建节点
        LoopNode node1=new LoopNode(1);
        LoopNode node2=new LoopNode(4);
        LoopNode node3=new LoopNode(8);
        LoopNode node4=new LoopNode(12);
        node1.after(node2);
        node2.after(node3);
        node3.after(node4);
             System.out.print("\n"+node1.next().getData());
             System.out.print("\n"+node2.next().getData());
             System.out.print("\n"+node3.next().getData());
             System.out.print("\n"+node4.next().getData());
    }
}
