package zyforu.array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zy
 * @date 2023/7/21 11:07
 */
public class GenericArray<T> {
    private T[] data;
    private int size;

    private static final int DEFAULT_SIZE = 10;

    public GenericArray(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isContains(T t) {
        if (find(t) != -1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 无参构造
    public GenericArray() {
        /*this.data = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;*/
        this(10);
    }

    // 普适性添加
    public void add(int index, T t) {
        checkIndexForAdd(index);
        if (size == data.length) {
            // 扩容
            enlarge();
        }
        for(int i = size; i > index; i--) {
            data[size] = data[size-1];
        }
        data[index] = t;
        size ++;
    }

    // 首添加
    public void addFirst(T t) {
        add(0,t);
    }

    // 尾添加
    public void addLast(T t) {
        add(size, t);
    }

    // 删除
    public void delElement(T t) {
       int pos = find(t);
       if(pos != -1) {
           del(pos);
       }
    }

    public void del(int index) {
        checkIndexForGet(index);
        for (int i = index ; i < size-1; i++) {
            data[i] = data[i + 1];
            // 忽略清理最后一位
        }
        size --;
    }

    // 查找
    public int find(T t) {
        for (int i = 0; i < data.length; i++) {
            if (t.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    // 访问
    public T get(int index) {
        checkIndexForGet(index);
        return data[index];
    }

    // 修改
    public void set(int index, T t) {
        checkIndexForGet(index);
        data[index] = t;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i = 0; i < size; i++) {
            res += data[i] + " ";
        }
        //System.out.println(Arrays.toString(data));
        return res;
    }


    // 扩容 todo 缩容
    private void enlarge() {
        // 扩容原数组两倍
        T[] newData = (T[])new Object[size * 2];
        for(int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must be in [0,size]");
        }
    }
    private void checkIndexForGet(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("index must be in [0,size-1]");
        }
    }
}
