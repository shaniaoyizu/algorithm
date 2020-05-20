package liner.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020-05-20
 *
 * @author sunbc
 * @Describe LRU algorithm based array
 * @since
 */
public class LRUBasedArray<T> {
    /**
     * the default capacity of array
     */
    private static final int DEFAULT_CAPACITY = 1 << 3;

    /**
     * to store data
     */
    private T[] value;

    /**
     * the capacity of array
     */
    private int capacity;

    /**
     * the size of array
     */
    private int size;

    /**
     *
     */
    private Map<T, Integer> holder;

    public LRUBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.value = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
        this.holder = new HashMap<>(capacity);
    }

    /**
     * Moves the first to nth elements of array right
     *
     * @param index
     */
    private void rightShift(int index) {
        for (int i = index - 1; i >= 0; i--) {
            value[i + 1] = value[i];
            holder.put(value[i], i + 1);
        }
    }

    /**
     * Caches the specified value at the head of array
     *
     * @param object
     * @param index
     */
    private void cache(T object, int index) {
        update(object, index);
        size++;
    }

    /**
     * Updates the specified value's position in the array
     *
     * @param object
     * @param index
     */
    private void update(T object, int index) {
        rightShift(index);
        value[0] = object;
        holder.put(object, 0);
    }

    /**
     * Deletes the specified element from the array
     *
     * @param object
     */
    private void deleteCache(T object) {
        T key = value[--size];
        holder.remove(key);
        cache(object, size);
    }

    /**
     * Access the specified value
     *
     * @param object
     */
    public void offer(T object) {
        if (object == null) {
            throw new RuntimeException("the cache is not supported null value");
        }
        Integer index = holder.get(object);
        if (index == null) {
            if (capacity > size) {
                cache(object, size);
            } else {
                deleteCache(object);
            }
        } else {
            update(object, index);
        }
    }

    /**
     * Prints all the elements of cache
     */
    public void printAll() {
        StringBuilder arrayStr = new StringBuilder("[");
        for (int i = 0; ; i++) {
            if (value[i] != null) {
                arrayStr.append(value[i]);
            } else {
                System.out.println();
                return;
            }
            if (i == size - 1) {
                arrayStr.append("]");
                System.out.println(arrayStr.toString());
                return;
            }
            arrayStr.append(",");
        }
    }
}
