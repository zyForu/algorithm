package zyforu.queue;

import zyforu.array.Array;

/**
 * @author zy
 * @date 2023/7/28 9:47
 * 数组队列
 * 1. 可以增加头尾指针head、tail,这样可以在最后底层数组空间不够时，再统一维护数组
 */
public class ArrayQueue<T> {
    private T[] data;
    private int capacity;
    private int size;
    public static final int DEFAULT_CAPACITY = 1 << 2;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public ArrayQueue() {
        this(DEFAULT_CAPACITY);
    }


    // enqueue
    public void enqueue(T t) {
        if(size == capacity) {
            System.out.println("queue is full");
            return;
        }
        data[size] = t;
        size ++;
    }

    // dequeue
    public T dequeue() {
        if(size == 0) {
            System.out.println("queue si empty");
            return null;
        }
        T res = data[0];
        for(int i = 0; i < size; i++) {
            data[i] = data[i+1];
        }
        size --;
        return res;
    }
}
