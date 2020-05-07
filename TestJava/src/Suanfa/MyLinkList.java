package Suanfa;

public class MyLinkList {
    /**
     * �ڲ�������Node
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
    // ͷ�ڵ�ָ��
    private Node head;
    //β�ڵ�ָ��
    private Node last;
    //����ʵ�ʳ���
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
     * �������Ԫ��
     * @param data ����Ԫ��
     * @param index ����λ��
     */
    public void insert(int data, int index){
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException(" ��������ڵ㷶Χ��");
        }
        //����һ���½ڵ�
        Node insertnode=new Node(data);
        if (size ==0) {
          // ������
            head=insertnode;
            last=insertnode;
        }else if(index==0){
            //ͷ������
            insertnode.next=head;
           head=insertnode;
        }else if(size==index){
            //β������
            last.next=insertnode;
            last=insertnode;
        }else{
            //�м����
            //�Ȼ�ȡҪ����ڵ����һ���ڵ�
            Node preNode = get(index - 1);
            //����һ���ڵ����һ���ڵ㸳ֵ��Ҫ����ڵ����һ���ڵ�
            insertnode.next = preNode.next;
            //��Ҫ����Ľڵ���ǰһ���ڵ����һ���ڵ�
            preNode.next = insertnode;
        }
        size++;
    }
    /**
     * ����ɾ��Ԫ��
     * @param index ɾ��λ��
     */
    public Node remove(int index){
        if (index<0||index>size) {
            throw new IndexOutOfBoundsException(" ��������ڵ㷶Χ��");
        }
        //Ҫɾ���Ľڵ�
        Node removedNode = null;
        if(index==0){
            //ɾ��ͷ���
            removedNode=head;
            head=head.next;
        }else if(index==size-1){
            //��ȡҪɾ��Ԫ�ص���һ���ڵ�
            Node preNode=get(index-1);
            removedNode=preNode.next;
            //preNode���β�ڵ�
            preNode.next=null;
            last=preNode;
        }else{
            //ɾ���м�ڵ�
            //��ȡҪɾ��Ԫ�ص���һ���ڵ�
            Node preNode = get(index - 1);
            //��ȡҪɾ���ڵ����һ���ڵ�
            //Node nextNode=preNode.next.next;
            Node nextNode = get(index + 1);
            removedNode = preNode.next;
            preNode.next = nextNode;
        }
        size--;
        //����Ҫɾ���Ľڵ�
        return removedNode;
    }
    /**
     * �����޸�Ԫ��
     * @param data �޸ĵ�Ԫ��
     */
    public void update(int data,int index){
        Node updataNode=get(index);
        updataNode.setData(data);
    }
    /**
     * �������Ԫ��
     * @param index ����λ��
     */
    public Node get(int index){
        if (index<0 || index>=size) {
            throw new IndexOutOfBoundsException("��������ڵ㷶Χ��");
        }
        //��ͷ����ʼ����
        Node temp=head;
        for (int i = 0; i <index ; i++) {
            //���ҵ�index��ǰһ��ʱtemp.next֪���Ҿ���Node[index]
            temp=temp.next;
        }
        //���ز��ҵĽڵ�,����������
        return temp;
    }
    /**
     * �������
     */
    public void output(){
        //��ͷ��㿪ʼ���
        Node first=head;
        while(first!=null){
            System.out.print(first.data+" ");
            first=first.next;
        }
        System.out.println();
    }
}