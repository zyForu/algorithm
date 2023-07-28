package zyforu.queue;

/**
 * @author zy
 * @date 2023/7/28 14:07
 * 1.出队列的时候，head顺移动一位，还需考虑tail（只有一位元素）
 */
public class LinkedListQueue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;


    public void enqueue(T t) {
        Node newNode = new Node(t);
        if(isEmpty()) {
            head = newNode;
            tail = head;
        }else {
            tail.next = newNode;
            tail = tail.next;
        }
        size ++;
    }

    public T dequeue() {
        if(isEmpty()) {
            System.out.println("the queue is full");
            return null;
        }else {
            T res = head.data;
            head = head.next;
            if(head == null) {
                tail = null;
            }

            size --;
            return res;
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static class Node<T> {
        private T data;
        private Node next;

        public Node(T t) {
            this.data = t;
            this.next = null;
        }
    }
}
