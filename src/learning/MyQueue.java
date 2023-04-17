package learning;

/**
 * @author Zuohaitao
 * @date 2023-04-17 16:33
 * @describe
 */
public class MyQueue {
    private int[] queue;
    private int front;
    private int rear;

    public MyQueue(int size) {
        queue = new int[size];
        front = -1;
        rear = -1;
    }
    public void enqueue(int x) {
        if (rear == queue.length - 1) {
            throw new RuntimeException("Queue is fuull");
        }
        queue[++rear] = x;
        if (front == -1) {
            front = 0;
        }
    }
    public int dequeue() {
        if (front == -1) {
            throw new RuntimeException("Queue is empty");
        }
        int data = queue[front++];
        if (front > rear) {
            front = -1;
            rear = -1;
        }
        return data;
    }
    public int peek() {
        if (front == -1) {
            throw new RuntimeException("Queue is empty");
        }
        return queue[front];
    }
    public boolean isEmpty() {
        return front == -1;
    }

}
