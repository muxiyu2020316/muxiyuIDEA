package Suanfa.Heap;

import java.util.Arrays;

public class PriorityQueueMax {
    private int[] array;
    public int size;

    public PriorityQueueMax() {
        //���г�ʼ����32
        array = new int[32];
    }

    /**
     * ���
     *
     * @param key ���Ԫ��
     */
    public void enQueue(int key) {
        //���г��ȳ�����Χ������
        if (size >= array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * ����
     */
    public int deQueue() throws Exception {
        if (size <= 0) {
            throw new Exception("the queue is empty !");
        }
        //��ȡ�Ѷ�Ԫ��
        int head = array[0];
        //���һ��Ԫ���ƶ����Ѷ�
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * �ϸ�����
     */
    private void upAdjust() {
        int childIndex = size - 1;
        int parentIndex = (childIndex - 1) / 2;
        // temp��������Ҷ�ӽڵ�ֵ���������ĸ�ֵ
        int temp = array[childIndex];
        while (childIndex > 0 && temp > array[parentIndex]) {
            //������������������ֵ����
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     * �³�����
     */
    private void downAdjust() {
        // temp���游�ڵ�ֵ���������ĸ�ֵ
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            // ������Һ��ӣ����Һ��Ӵ������ӵ�ֵ����λ���Һ���
            if (childIndex + 1 < size && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }
            // ������ڵ�����κ�һ�����ӵ�ֵ��ֱ������
            if (temp >= array[childIndex])
                break;
            //������������������ֵ����
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * ��������
     */
    private void resize() {
        //������������
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    /**
     * ���ѹ�����
     *
     * @param array �������Ķ�
     */
    public void buildHeap(int[] array) {
        // �����һ����Ҷ�ӽڵ㿪ʼ�����������³�������
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            downAdjust();
        }
    }

    public static void main(String[] args) throws Exception {
        PriorityQueueMax minpriorityQueueMax = new PriorityQueueMax();
        minpriorityQueueMax.enQueue(3);
        minpriorityQueueMax.enQueue(5);
        minpriorityQueueMax.enQueue(10);
        minpriorityQueueMax.enQueue(2);
        minpriorityQueueMax.enQueue(7);
//        System.out.println("����Ԫ�أ�" + minpriorityQueueMax.deQueue());
//        System.out.println("����Ԫ�أ�" + minpriorityQueueMax.deQueue());
    }
}

