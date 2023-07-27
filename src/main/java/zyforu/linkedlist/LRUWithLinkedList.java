package zyforu.linkedlist;

import jdk.jshell.Snippet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zy
 * @date 2023/7/26 17:13
 */
public class LRUWithLinkedList<T> {
    private int capacity;
    private int count;
    private Map<T,Integer> holders;
    private SNode value;

    public static final int DEFAULT_CAPACITY = 1 << 3;

    public LRUWithLinkedList(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.holders = new HashMap<T, Integer>();
    }

    public LRUWithLinkedList() {
        this(DEFAULT_CAPACITY);
    }

    // 访问数据
    public void offer(T t) {
        Integer ind = holders.get(t);
        if (ind == null) {
            if(count == capacity) {
                removeAndCache(t);
            }else {
                cache(t);
            }
        }else {
            adjustToHeader(t);
        }
    }

    private void adjustToHeader(T t) {
        SNode s = value;
        SNode pre = null;
        while(s != null && !s.data.equals(t)) {
            pre = s;
            s = s.next;
        }

        if (pre == null) {
            return;
        }
        SNode tmp = pre.next;
        pre.next = pre.next.next;
        holders.remove(tmp.data);
        tmp = null;
        SNode<T> newNode = new SNode<>(t);
        newNode.next = value;
        value = newNode;
        holders.forEach((k,v) -> holders.put(k, v+1));
        holders.put(t, 0);
    }

    private void cache(T t) {
        SNode<T> newNode = new SNode<>(t);
        if (value == null) {
            value = newNode;

        }else {
            newNode.next = value;
            value = newNode;
        }
        count++;
        holders.forEach((k,v) -> holders.put(k, v+1));
        holders.put(t, 0);

    }

    private void removeAndCache(T t) {
        SNode s = value;
        SNode p = null;
        while (s.next!= null) {
            p = s;
            s = s.next;
        }
        holders.remove(s.data);
        if (p != null) {
            p.next = null;
        }else {
            value = null;
        }
        count--;
        cache(t);
    }


    public static class SNode<T> {
        private T data;
        private SNode next;

        public SNode(T t) {
            this.data =t ;
            this.next = null;
        }
    }

    public void printAll() {
        SNode p = value;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
    }


}
