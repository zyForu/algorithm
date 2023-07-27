package zyforu.stack;

/**
 * @author zy
 * @date 2023/7/27 16:05
 */

/**
 * 1.以链表做栈的时候，最好push以头部添加的方式做
 */
public class StackWithLinkedList {

    public static class Node{
        private int data;
        private Node next;

        public Node(int val) {
            this.data = val;
            this.next = null;
        }
    }

    private int size;
    private Node data;
    // 栈帧的前一位
    private Node stackFrame;


    public int pop() {
        if(data == null) {
            System.out.println("stack size is empty, can not pop");
        }
        int res;
        if (data.next == null) {
            res = data.data;
            data = null;
        }else {
            res = stackFrame.next.data;
            stackFrame.next = null;
        }
        size --;
        return res;

    }

    public void push(int val) {
        Node newNode = new Node(val);
        if (data == null) {
            data = newNode;
        }if(data.next == null) {
            stackFrame = data;
        }else {
            data.next = newNode;
            stackFrame = stackFrame.next;
        }
        size++;
    }

    public int getSize() {
        return size;
    }
}
