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
        if (ind != null) {
            if(count == capacity) {
                removeAndCache(t);
            }else {
                cache(t);
            }
        }
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
        holders.put(t, 0);

    }

    private void removeAndCache(T t) {
        if(value.next == null) {
            value = null;
        }else {
            SNode p = value;
            while(p.next != null) {
                p = p.next;
            }
            p.next = null;
        }
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

}
