package liner.array;

import java.util.Arrays;

/**
 * Created on 2020-05-15
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class GenericArray<T> {

    private T[] data;
    private int size;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * the capacity of data array
     *
     * @param capacity
     */
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    /**
     * capacity is default 10
     */
    public GenericArray() {
        this(10);
    }

    /**
     * If this array is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get the capacity of data array
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * get the element count of data array
     *
     * @return
     */
    public int count() {
        return size;
    }

    /**
     * If this list contains the specified element
     *
     * @param element
     * @return
     */
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    /**
     * Returns the index if this list contains the specified element,
     * else returns -1;
     *
     * @param element
     * @return
     */
    public int indexOf(T element) {
        if (element == null) {
            for (int index = 0; index < size; index++) {
                if (data[index] == null) {
                    return index;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (element.equals(data[index])) {
                    return index;
                }
            }
        }
        return -1;
    }

    /**
     * Replaces the element at the specified position in this list with
     * the specified element.
     *
     * @param index
     * @param element
     * @return
     */
    public boolean set(int index, T element) {
        rangeCheck(index);
        data[index] = element;
        return true;
    }

    /**
     * Get the element in ths specified position in this list.
     *
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        return data[index];
    }

    /**
     * Inserts the specified element in the specified position of this list
     *
     * @param index
     * @param element
     * @return
     */
    public boolean add(int index, T element) {
        ensureCapacityInternal(size + 1);
        rangeCheckForAdd(index);
        int numMoved = size - index;
        System.arraycopy(data, index, data, index + 1, numMoved);
        data[index] = element;
        size++;
        return true;
    }

    /**
     * Inserts the specified element at the last position of the list
     *
     * @param element
     * @return
     */
    public boolean add(T element) {
        ensureCapacityInternal(size + 1);
        data[size++] = element;
        return true;
    }

    /**
     * Removes the first occurrence of the specified element in the list if is present;
     *
     * @param element
     * @return
     */
    public boolean remove(T element) {
        if (element == null) {
            for (int index = 0; index < size; index++) {
                if (data[index] == null) {
                    fastRemove(index);
                    return true;
                }
            }
        } else {
            for (int index = 0; index < size; index++) {
                if (element.equals(data[index])) {
                    fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes the element at the specified position of the list
     *
     * @param index
     * @return
     */
    public boolean remove(int index) {
        rangeCheck(index);
        fastRemove(index);
        return true;
    }

    /**
     * @param index
     */
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(data, index + 1, data, index, numMoved);
        }
        data[--size] = null;
    }

    /**
     * Ensure the capacity of the list is sufficient
     *
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        if (minCapacity > data.length) {
            grow(minCapacity);
        }
    }

    /**
     * Grow the capacity of the list
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity > minCapacity) {
            newCapacity = minCapacity;
        }
        data = Arrays.copyOf(data, newCapacity);
    }

    /**
     * Trim the capacity of list to the size of the list
     */
    public void trimToSize() {
        if (size < data.length) {
            data = (size == 0) ? (T[]) EMPTY_ELEMENTDATA : Arrays.copyOf(data, size);
        }
    }

    /**
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("the index is out of array bound");
        }
    }

    /**
     * @param index
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("the index is out of array bound");
        }
    }

    @Override
    public String toString() {
        if (size == 0){
            return "[]";
        }

        StringBuilder str = new StringBuilder();
        str.append("[");
        for (int i = 0;; i++) {
            str.append(data[i]);
            if (i == size - 1){
                return str.append("]").toString();
            }
            str.append(",");
        }
    }
}
