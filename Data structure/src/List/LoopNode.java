package List;

public class LoopNode {
    //节点内容
    int data;
    //下一节点
    LoopNode next=this;
    //构造函数
    public LoopNode(int data){
        this.data=data;
    }
    //追加节点
    public LoopNode append(LoopNode node){
      //记录当前节点
      LoopNode CurrentNode=this;
      //无线追加,判断是否有下一节点
        while(true){
            //取出下一节点
            LoopNode NextNode=CurrentNode.next;
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
    //显示所有节点
    public void show(){
        LoopNode CurrentNode =this;
        while(true){
            System.out.print(CurrentNode.data+" ");
            CurrentNode=CurrentNode.next;
            if (CurrentNode==null){
                break;
            }
        }
    }

    //获取下一节点
    public LoopNode next(){
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
    public void after(LoopNode node){
        //取出下一节点,作为下下一节点
        LoopNode NextNode=next;
        //新节点当前节点的下一节点
        LoopNode CurrentNode=this;
        CurrentNode.next=node;
        //将下下一节点作为新节点的下一节点
        node.next=NextNode;
    }
}
