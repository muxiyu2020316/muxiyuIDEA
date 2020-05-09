package Suanfa.linear;
   /** ѭ������
     * �����������ʼ�ձ����鳤��С1
     * ȷ������ѭ����ȥ���������ٽ�ֵ
     */
public class DoubleQueue {
    private int []array;
    private int front;//��ͷ
    private int rear;//��β
    public DoubleQueue(int capacity){
        this.array=new int [capacity];
    }

        public static void main(String[] args) throws Exception {
        DoubleQueue myQueue=new DoubleQueue(6);
            System.out.println(myQueue.isEmpty());
            myQueue.enQueue(3);
            myQueue.enQueue(5);
            myQueue.enQueue(6);
            myQueue.enQueue(8);
            myQueue.enQueue(1);
//            myQueue.deQueue();
              myQueue.deQueue();
              myQueue.deQueue();
            myQueue.output();
            myQueue.enQueue(2);
            myQueue.enQueue(4);
            //myQueue.enQueue(9);
            myQueue.output();
            System.out.println(myQueue.isEmpty());
        }
    /**
     * ���
     * @param element ���Ԫ��
     */
    public void enQueue(int element) throws Exception {
        if((rear+1)%array.length == front){
            throw new Exception(" ����������");
        }
        array[rear] = element;
        //��β����
        rear =(rear+1)%array.length;
    }

    /**
     * ����
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if(rear==front)
            throw new Exception("�����ѿ�");
        int deQueueElement=array[front];
        //��ͷ��Ϊ��һ��
        front=(front+1)%array.length;
        //���ض�ͷԪ��
        return  deQueueElement;
    }

    /**
     * �������
     */
    public void output(){
        for (int i = front; i !=rear ; i=(i+1)%array.length) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        if(front==0&&rear==0){
            return true;
        }
        return false;
    }

    }
