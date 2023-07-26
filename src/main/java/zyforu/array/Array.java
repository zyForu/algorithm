package zyforu.array;

/**
 * @author zy
 * @date 2023/7/20 15:50
 * 构建数组容器，完成数组元素的添加，删除，查找
 */

public class Array {
    private int[] data;
    private int size;
    private int count;


    public Array(int capacity) {
        this.size = capacity;
        this.count = 0;
        this.data = new int[capacity];
    }

    public boolean add(int ind, int val) {

        // 容器已满
        if(count == size) {
            System.out.println("容器已满");
            return false;
        }

        // 位置不合法
        if(ind < 0 || ind > count) {
            System.out.println("插入位置不合法:" + ind);
            return false;
        }

        for(int i = count; i > ind; i--) {
            data[count] = data[count-1];
        }
        data[ind] = val;
        count ++;
        return true;
    }

    public boolean del(int ind) {
        // 位置不合法
        if(ind < 0 || ind >= count) {
            System.out.println("删除位置不合法:" + ind);
            return false;
        }
        for(int i = ind; i < count - 1; i++) {
            data[i] = data[i+1];
            // 此处无需清除末尾数据,因为count--会限制访问，对外来说，数据不存在
        }
        count --;
        return true;
    }

    public int find(int ind) {
        // 位置不合法
        if(ind < 0 || ind >= count) {
            System.out.println("查找位置不合法:" + ind);
            return -1;
        }

        return data[ind];
    }

    public void printAll() {
        for(int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.add(0, 3);
        array.add(0, 4);
        array.add(1, 5);
        array.add(3, 9);
        array.add(3, 10);
        array.del(1);
        //array.insert(3, 11);
        array.printAll();
        System.out.println(array.find(4));
    }
}
