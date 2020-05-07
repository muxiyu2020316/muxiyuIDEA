package Suanfa;

public class MyLinkList {
    /**
     * 内部构造类Node
     */
        private static class Node {
            int data;
            Node next;
            Node(int data) {
                this.data = data;
            }
            public void setData(int data) {
                this.data = data;
            }
            public int getData() {
                return data;
            }
        }
    // 头节点指针
    private Node head;
    //尾节点指针
    private Node last;
    //链表实际长度
    private int size;
        public static void main(String[] args) {
            MyLinkList myLinkedList = new MyLinkList();
            myLinkedList.insert(3,0);
            myLinkedList.insert(7,1);
            myLinkedList.insert(9,2);
            myLinkedList.insert(5,3);
            myLinkedList.output();
            myLinkedList.insert(6,1);
            myLinkedList.output();
            myLinkedList.update(234,1);
            myLinkedList.output();
            myLinkedList.remove(3);
            myLinkedList.output();
            System.out.println(myLinkedList.get(2).getData());
        }
    /**
     * 链表插入元素
     * @param data 插入元素
     * @param index 插入位置
     */
    public void insert(int data, int index){
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围！");
        }
        //创建一个新节点
        Node insertnode=new Node(data);
        if (size ==0) {
          // 空链表
            head=insertnode;
            last=insertnode;
        }else if(index==0){
            //头部插入
            insertnode.next=head;
           head=insertnode;
        }else if(size==index){
            //尾部插入
            last.next=insertnode;
            last=insertnode;
        }else{
            //中间插入
            //先获取要插入节点的上一个节点
            Node preNode = get(index - 1);
            //把上一个节点的下一个节点赋值给要插入节点的下一个节点
            insertnode.next = preNode.next;
            //把要插入的节点变成前一个节点的下一个节点
            preNode.next = insertnode;
        }
        size++;
    }
    /**
     * 链表删除元素
     * @param index 删除位置
     */
    public Node remove(int index){
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException(" 超出链表节点范围！");
        }
        //要删除的节点
        Node removedNode = null;
        if(index==0){
            //删除头结点
            removedNode=head;
            head=head.next;
        }else if(index==size-1){
            //获取要删除元素的上一个节点
            Node preNode=get(index-1);
            removedNode=preNode.next;
            //preNode变成尾节点
            preNode.next=null;
            last=preNode;
        }else{
            //删除中间节点
            //获取要删除元素的上一个节点
            Node preNode = get(index - 1);
            //获取要删除节点的下一个节点
            //Node nextNode=preNode.next.next;
            Node nextNode = get(index + 1);
            removedNode = preNode.next;
            preNode.next = nextNode;
        }
        size--;
        //返回要删除的节点
        return removedNode;
    }
    /**
     * 链表修改元素
     * @param data 修改的元素
     */
    public void update(int data,int index){
        Node updataNode=get(index);
        updataNode.setData(data);
    }
    /**
     * 链表查找元素
     * @param index 查找位置
     */
    public Node get(int index){
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("超出链表节点范围！");
        }
        //从头部开始查找
        Node temp=head;
        for (int i = 0; i <index ; i++) {
            //当找到index的前一个时temp.next知道我就是Node[index]
            temp=temp.next;
        }
        //返回查找的节点,和数组类似
        return temp;
    }
    /**
     * 输出链表
     */
    public void output(){
        //从头结点开始输出
        Node first=head;
        while(first!=null){
            System.out.print(first.data+" ");
            first=first.next;
        }
        System.out.println();
    }
}