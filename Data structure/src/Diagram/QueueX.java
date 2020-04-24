package Diagram;

public     class QueueX {
    private final int SIZE = 20;
    private int[] queArray;
    private int front;
    private int rear;

    public QueueX() {
        queArray = new int[SIZE];
        front = 0;
        rear = -1;
    }

    public void insert(int j) {// 入队
        if (rear == SIZE - 1) {
            rear = -1;
        }
        queArray[++rear] = j;
    }

    public int remove() {// 出队
        if (!isEmpty()) {
            return queArray[front++];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return (rear + 1 == front);
    }
}
