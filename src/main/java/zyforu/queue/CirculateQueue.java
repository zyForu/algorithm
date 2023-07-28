package zyforu.queue;

/**
 * @author zy
 * @date 2023/7/28 14:59
 * 1.循环队列需要浪费一个存储空间来区分队满与队空
 */
public class CirculateQueue {
    private int[] elements;

    private int head;
    private int tail;
    private int capacity;


    public CirculateQueue(int capacity) {
        this.capacity = capacity;
        this.elements = new int[capacity];
    }


    public void enqueue(int e) {
        if (isFull()) {
            System.out.println("queue is full");
            return;
        }

        elements[tail] = e;
        tail = (tail + 1) % capacity;

    }

    public int dequeue() {
        if(isEmpty()) {
            System.out.println("queue is empty");
            return 0; // 此处抛异常
        }
        int res = elements[head];
        head = (head + 1) % capacity;
        return res;
    }

    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public int getSize() {
       if(tail >= head) {
           return tail - head;
       }else {
           return tail - head + capacity;
       }
    }

    public void printAll() {
        if(capacity == 0) {
            System.out.println("null");
        }
        for(int i = head; i % capacity != tail; i = (i + 1) % capacity) {
            System.out.println(elements[i]);
        }
    }

}
