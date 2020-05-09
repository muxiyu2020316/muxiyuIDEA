package Suanfa.Heap;

import java.util.Arrays;

/**
 * 优先队列
 * MaxPriorityQueue
 */
public class PriorityQueueMin {
    /**
     * 基本队列的实现
     */
    public int[] array;
    public int size;

    public PriorityQueueMin() {
        //队列出事长度
        array = new int[32];
    }

    /**
     * 入队操作
     *
     * @param key 入队元素
     */
    public void add(int key) {
        //判断是否超过容量,超过扩容
        if (size > array.length) {
            resize();
        }
        array[size++] = key;
        upAdjust();
    }

    /**
     * 出队操作
     *
     * @return
     * @throws Exception
     */
    public int poll() throws Exception {
        if (size <= 0) {
            throw new Exception("这是一个空队列");
        }
        //获取堆顶元素
        int head = array[0];
        //最后一个元素移动到堆顶
        array[0] = array[--size];
        downAdjust();
        return head;
    }

    /**
     * 上浮调整,交换父子节点的数据.
     */
    public void upAdjust() {
        //最后一个节点下标
        int childIndex = size - 1;
        //最后一个节点的父节点下标
        int parentIndex = (childIndex - 1) / 2;
        //temp 临时保存插入的叶子节点值,最后用来赋值
        int temp = array[childIndex];
        //当有子节点,且最后一个节点不是根节点时
        while (childIndex > 0 && temp < array[parentIndex]) {
            //交换位置,无需exchage.只需单项赋值
            array[childIndex] = array[parentIndex];
            childIndex = parentIndex;
            //回到上一个节点的父节点,就是现在节点的父节点
            parentIndex = (parentIndex - 1) / 2;
        }
        array[childIndex] = temp;
    }

    /**
     *
     */
    public void downAdjust() {
        //temp 保存父节点,用于最后的赋值
        int parentIndex = 0;
        int temp = array[parentIndex];
        int childIndex = 1;
        while (childIndex < size) {
            //如果有右子节点,右孩子小于左孩子.定位右孩子
            if (childIndex + 1 < size && (array[childIndex + 1] < array[childIndex])) {
                childIndex++;
            }
            //若果父节点小于任何一个子节点值,跳出.
            if (temp <= array[childIndex]) {
                break;
            }
            //交换位置,无需exchage.只需单项赋值
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 数组扩容
     */
    private void resize() {
        //队列容量进行翻倍
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
        System.out.println("出队元素：" + priorityQueue.poll());
        System.out.println("出队元素：" + priorityQueue.poll());
    }
}
