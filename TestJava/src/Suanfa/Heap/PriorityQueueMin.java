package Suanfa.Heap;

import java.util.Arrays;

/**
 * ���ȶ���
 * MaxPriorityQueue
 */
public class PriorityQueueMin {
    /**
     * �������е�ʵ��
     */
    public int[] array;
    public int size;

    public PriorityQueueMin() {
        //���г��³���
        array = new int[32];
    }

    /**
     * ��Ӳ���
     *
     * @param key ���Ԫ��
     */
    public void add(int key) {
        //�ж��Ƿ񳬹�����,��������
        if (size > array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * ���Ӳ���
     *
     * @return
     * @throws Exception
     */
    public int poll() throws Exception {
        if (size <= 0) {
            throw new Exception("����һ���ն���");
        }
        //��ȡ�Ѷ�Ԫ��
        int head = array[0];
        //���һ��Ԫ���ƶ����Ѷ�
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * �ϸ�����,�������ӽڵ������.
     */
    public void upAdjust() {
        //���һ���ڵ��±�
        int childIndex = size - 1;
        //���һ���ڵ�ĸ��ڵ��±�
        int parentIndex = (childIndex - 1) / 2;
        //temp ��ʱ��������Ҷ�ӽڵ�ֵ,���������ֵ
        int temp = array[childIndex];
        //�����ӽڵ�,�����һ���ڵ㲻�Ǹ��ڵ�ʱ
        while (childIndex > 0 && temp < array[parentIndex]) {
            //����λ��,����exchage.ֻ�赥�ֵ
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            //�ص���һ���ڵ�ĸ��ڵ�,�������ڽڵ�ĸ��ڵ�
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     *
     */
    public void downAdjust() {
        //temp ���游�ڵ�,�������ĸ�ֵ
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            //��������ӽڵ�,�Һ���С������.��λ�Һ���
            if (childIndex + 1 < size && (array[childIndex + 1] < array[childIndex])) {
                childIndex++;
            }
            //�������ڵ�С���κ�һ���ӽڵ�ֵ,����.
            if (temp <= array[childIndex]) {
                break;
            }
            //����λ��,����exchage.ֻ�赥�ֵ
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
        //�����������з���
        int newSize = this.size * 2;
        this.array = Arrays.copyOf(this.array, newSize);
    }

    public static void main(String[] args) throws Exception {
        PriorityQueueMin priorityQueue = new PriorityQueueMin();
        priorityQueue.add(3);
        priorityQueue.add(5);
        priorityQueue.add(10);
        priorityQueue.add(2);
        priorityQueue.add(7);
        System.out.println("����Ԫ�أ�" + priorityQueue.poll());
        System.out.println("����Ԫ�أ�" + priorityQueue.poll());
    }
}
