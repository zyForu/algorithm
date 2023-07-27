package zyforu.stack;

/**
 * @author zy
 * @date 2023/7/27 16:49
 */
public class BrowserWithStack {
    private LinkedListStack forwardStack;
    private LinkedListStack backStack;


    public BrowserWithStack() {
        this.forwardStack = new LinkedListStack();
        this.backStack = new LinkedListStack();
    }

    // 打开网页
    public void open(String page) {
        forwardStack.push(page);
        backStack.clear();
    }

    // 后退
    public void backPage() {
        if(forwardStack.getSize() == 0) {
            System.out.println("no page open ,can not back");
            return;
        }
        String page = forwardStack.pop();
        backStack.push(page);
    }

    // 前进
    public void forward() {
        if (backStack.getSize() == 0) {
            System.out.println("no page ahead, can not forward");
        }
        String page = backStack.pop();
        forwardStack.push(page);
    }

    public String show() {
        if(forwardStack.getSize() == 0) {
            return null;
        }
        System.out.println(forwardStack.top.data);
        return forwardStack.top.data;
    }


    public static class LinkedListStack {
        private Node top;

        private int size;

        public static class Node {
            private String data;
            private Node next;

            public Node(String page) {
                this.data = page;
                this.next = null;
            }
        }

        public void push(String page) {
            Node newNode = new Node(page);
            newNode.next = top;
            top = newNode;
            size ++;
        }

        public String pop() {
            if(top == null) {
                return null;
            }
            String res = top.data;
            top = top.next;
            size --;
            return res;
        }

        public void clear() {
            top = null;
            size = 0;
        }

        public int getSize() {
            return size;
        }

    }
}
