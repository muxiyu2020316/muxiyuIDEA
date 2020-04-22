package List;

public class Node {
    //节点内容
    int data;
    //下一节点
    Node next;
    //构造函数
    public Node(int data){
        this.data=data;
    }
    //追加节点
    public Node append(Node node){
      //记录当前节点
      Node CurrentNode=this;
      //无线追加,判断是否有下一节点
        while(true){
            //取出下一节点
            Node NextNode=CurrentNode.next;
            //如果下一个节点为空
            if(NextNode==null){
                break;
            }
            //赋值给当前节点
            CurrentNode=NextNode;
        }
        //把需要追加的节点追加为找到的当前节点的下一个节点
        CurrentNode.next=node;
        return this;
    }
    //删除下一节点
    public void RemoveNext(){
        //取出当前节点下下一个节点
       Node NewNode=next.next;
       //把下下一节点设置为当前节点
       this.next=NewNode;
    }
    //显示所有节点
    public void show(){
        Node CurrentNode =this;
        while(true){
            System.out.print(CurrentNode.data+" ");
            CurrentNode=CurrentNode.next;
            if (CurrentNode==null){
                break;
            }
        }
    }

    //获取下一节点
    public Node next(){
        //返回当前节点的下一个节点
        return this.next;
    }
    //获取节点内容
    public int getData(){
        return this.data;
    }
    //当前节点是否是最后一个节点
    public boolean isLast(){
        //当下一个节点为空时，说明是最后一个节点
        return next==null;
    }
    //插入节点,单链表只能后面插
    //插入一节点,位于两节点之间
    public void after(Node node){
        //取出下一节点,作为下下一节点
        Node NextNode=next;
        //新节点当前节点的下一节点
        Node CurrentNode=this;
        CurrentNode.next=node;
        //将下下一节点作为新节点的下一节点
        node.next=NextNode;
    }
}
