package liner.stack;

/**
 * Created on 2020-05-24
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class StackBasedArray<T> {
    /**
     * the default capacity of the stack
     */
    private static final int DEFAULT_CAPACITY = 1 << 3;
    /**
     * the array to store data
     */
    private T[] items;
    /**
     * the capacity of the stack
     */
    private int capacity;
    /**
     * the data size of the stack
     */
    private int size;

    /**
     * the default constructor
     */
    public StackBasedArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * @param capacity
     */
    public StackBasedArray(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * Gets the capacity of the stack
     *
     * @return
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Gets the data size of the stack
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * Pushes the specified value into the stack
     *
     * @param value
     * @return
     */
    public boolean push(T value) {
        if (value == null) {
            throw new RuntimeException("It's not supported null value");
        }
        if (capacity == size) {
            throw new RuntimeException("stack overflow");
        }

        items[size++] = value;
        return true;
    }

    /**
     * Removes the head element from the stack and returns it
     *
     * @return
     */
    public T pop() {
        if (size == 0) {
            return null;
        }
        T item = items[--size];
        return item;
    }

    /**
     * Returns the head element of the stack
     *
     * @return
     */
    public T peek() {
        if (size == 0) {
            return null;
        }
        return items[size - 1];
    }

    /**
     * @return
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; ; i++) {
            str.append(items[i]);
            if (i == size - 1) {
                return str.append("]").toString();
            }
            str.append(",");
        }
    }
}
