package Suanfa.linear;
   /** 循环队列
     * 队列最大容量始终比数组长度小1
     * 确保可以循环下去而不触发临界值
     */
public class DoubleQueue {
    private int []array;
    private int front;//对头
    private int rear;//队尾
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
     * 入队
     * @param element 入队元素
     */
    public void enQueue(int element) throws Exception {
        if((rear+1)%array.length == front){
            throw new Exception(" 队列已满！");
        }
        array[rear] = element;
        //队尾后移
        rear =(rear+1)%array.length;
    }

    /**
     * 出队
     * @throws Exception
     */
    public int deQueue() throws Exception {
        if(rear==front)
            throw new Exception("队列已空");
        int deQueueElement=array[front];
        //队头变为下一个
        front=(front+1)%array.length;
        //返回队头元素
        return  deQueueElement;
    }

    /**
     * 输出队列
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
