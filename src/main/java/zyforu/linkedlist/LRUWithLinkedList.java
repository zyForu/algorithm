package zyforu.linkedlist;

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
    private SingleLinkedList value;

    public static final int DEFAULT_CAPACITY = 1 << 3;

    public LRUWithLinkedList(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.holders = new HashMap<T, Integer>();
        this.value = new SingleLinkedList();
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

    }

    private void removeAndCache(T t) {

    }


}
