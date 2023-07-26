package zyforu.linkedlist;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zy
 * @date 2023/7/26 16:11
 */
public class LRUWithArray<T> {
    private Map<T, Integer> caches;
    private T[] values;

    private int count;

    private int capacity;

    private static final int DEFAULT_CAPACITY = 1 << 3;

    public LRUWithArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUWithArray(int capacity) {
        this.capacity = capacity;
        this.caches = new HashMap<T, Integer>();
        this.values = (T[])new Object[capacity];
        this.count = 0;
    }

    // 访问缓存
    public void offer(T t) {
        Integer i = caches.get(t);
        if(i == null) {
            if (isFull()) {
                removeAndCache(t);
            }else {
                cache(t);
            }
        }else {
            update(i);
        }
    }

    // 更新位置
    private void update(Integer i) {
        T target = values[i];
        rightShift(i);
        values[0] = target;
        caches.put(target, 0);

    }

    private void cache(T t) {
        caches.put(t, 0);
        rightShift(count);
        values[0] = t;
        count++;
    }

    // 空出首位，其余所有元素向右移动一位
    private void rightShift(int end) {
        for(int i = end -1; i >= 0; i--) {
            values[i+1] = values[i];
            caches.put(values[i], i+1);
        }
    }

    private void removeAndCache(T t) {
        rightShift(count--);
        caches.put(t,0);
        values[0] = t;
        caches.remove(t);
    }

    private boolean isFull() {
        return count == capacity;
    }


    @Override
    public String toString() {
        return "LRUWithArray{" +
                "values=" + Arrays.toString(values) +
                '}';
    }
}
