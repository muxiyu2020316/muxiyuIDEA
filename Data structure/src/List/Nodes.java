package List;

public class Nodes {
    //节点内容
    int data;
    //下一节点
    Nodes next;
    //构造函数
    public Nodes(int data){
        this.data=data;
    }
    //追加节点
    public Nodes append(Nodes nodes){
      //记录当前节点
      Nodes currentNodes =this;
      //无线追加,判断是否有下一节点
        while(true){
            //取出下一节点
            Nodes nextNodes = currentNodes.next;
            //如果下一个节点为空
            if(nextNodes ==null){
                break;
            }
            //赋值给当前节点
            currentNodes = nextNodes;
        }
        //把需要追加的节点追加为找到的当前节点的下一个节点
        currentNodes.next= nodes;
        return this;
    }
    //删除下一节点
    public void RemoveNext(){
        //取出当前节点下下一个节点
       Nodes newNodes =next.next;
       //把下下一节点设置为当前节点
       this.next= newNodes;
    }
    //显示所有节点
    public void show(){
        Nodes currentNodes =this;
        while(true){
            System.out.print(currentNodes.data+" ");
            currentNodes = currentNodes.next;
            if (currentNodes ==null){
                break;
            }
        }
    }

    //获取下一节点
    public Nodes next(){
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
    public void after(Nodes nodes){
        //取出下一节点,作为下下一节点
        Nodes nextNodes =next;
        //新节点当前节点的下一节点
        Nodes currentNodes =this;
        currentNodes.next= nodes;
        //将下下一节点作为新节点的下一节点
        nodes.next= nextNodes;
    }
}
