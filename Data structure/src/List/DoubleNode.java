package List;

public class DoubleNode {
    //双向循环链表上下一节点且循环
    //上一个节点/循环
    DoubleNode pre=this;
    //下一个节点/循环
    DoubleNode next=this;
    int data;
    public DoubleNode(int data){
       this.data=data;
    }
    //增加节点
    public void after(DoubleNode node){
        //源节点的下一节点
        DoubleNode nextNext=next;
        //新节点作为当前节点的下一个节点
        this.next=node;
        //当前节点做新节点的上一节点
        node.pre=this;
        //让原来的下一个节点作为新节点的下一个节点
        node.next=nextNext;
        //让原来的下一个节点的上一个节点作为新节点
        nextNext.pre=node;
    }
    //获取下一个节点
    public DoubleNode next(){
        return this.next;
    }
    //获取上一个节点
    public DoubleNode pre(){
        return  this.pre;
    }
    //获得数据方法
    public int getData(){
        return this.data;
    }

}
