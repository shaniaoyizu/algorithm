package liner.array;

import java.util.Arrays;

/**
 * Created on 2020-05-15
 *
 * @author sunbc
 * @Describe 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 * @since
 */
public class Array {
    /**
     * to save data
     */
    private int[] data;
    /**
     * the capacity of array
     */
    private int capacity;
    /**
     * the count of array
     */
    private int count;

    public Array(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
        this.count = 0;
    }

    /**
     * find element in array
     *
     * @param element
     * @return
     */
    public int find(int element) {
        for (int i = 0; i < count; i++) {
            if (element == data[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * find by index
     *
     * @param index
     * @return
     */
    public int findByIndex(int index) {
        rangeCheck(index);
        return data[index];
    }

    /**
     * 添加元素
     *
     * @param index
     * @param element
     */
    public boolean add(int index, int element) {
        rangeCheckForAdd(index);
        if (count == capacity) {
            throw new RuntimeException("the array is full");
        }

        System.arraycopy(data, index, data, index + 1, count - index);
        data[index] = element;
        count++;
        return true;
    }

    /**
     * add element in the first of array
     *
     * @param element
     */
    public boolean addFirst(int element) {
        return add(0, element);
    }

    /**
     * delete element from array
     *
     * @param element
     */
    public boolean delete(int element) {
        for (int i = 0; i < count; i++) {
            if (data[i] == element) {
                return deleteByIndex(i);
            }
        }
        return false;
    }

    /**
     * delete element from array by index
     *
     * @param index
     */
    public boolean deleteByIndex(int index) {
        rangeCheck(index);
        int numMoved = count - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--count] = 0;
        return true;
    }

    public void rangeCheck(int index) {
        if (index >= count) {
            throw new IndexOutOfBoundsException("the index out of array bound");
        }
    }

    public void rangeCheckForAdd(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("the index out of array bound");
        }
    }

    @Override
    public String toString() {
        if (count == 0){
            return "[]";
        }

        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0;; i++) {
            str.append(data[i]);
            if (i == count - 1){
                return str.append("]").toString();
            }
            str.append(",");
        }
    }
}
