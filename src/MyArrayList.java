import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements a custom ArrayList. It dynamically grows as elements are added.
 */
public class MyArrayList<T> implements MyList<T> {
    private Object[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructor that initializes the data array with default capacity.
     */
    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }


    /**
     * Ensures the internal array has enough capacity to store new elements.
     */
    private void ensureCapacity() {
        if (size >= data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }


    /**
     * Adds an element to the end of the list.
     * @param item The item to add
     */
    @Override
    public void add(T item) {
        ensureCapacity();
        data[size++] = item;
    }


    /**
     * Sets the element at the specified index.
     * @param index The index where the item is set
     * @param item The item to set at the given index
     */
    @Override
    public void set(int index, T item) {
        checkIndex(index);
        data[index] = item;
    }


    /**
     * Adds an element at the specified index.
     * @param index The index at which the item is added
     * @param item The item to add
     */
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity();
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = item;
        size++;
    }




    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    @Override
    public T getFirst() {
        return (T) data[0];
    }

    @Override
    public T getLast() {
        return (T) data[size - 1];
    }

    @Override
    public void remove(int index) {
        checkIndex(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
    }

    @Override
    public void removeFirst() {
        remove(0);
    }

    @Override
    public void removeLast() {
        remove(size - 1);
    }

    @Override
    public void sort() {
        // Можно добавить логику сортировки
    }

    @Override
    public int indexOf(Object object) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(object)) return i;
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(data, 0, result, 0, size);
        return result;
    }

    @Override
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }


    /**
     * Checks if the given index is valid.
     * @param index The index to check
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }


    /**
     * Checks if the given index is valid for adding an element.
     * @param index The index to check
     * @throws IndexOutOfBoundsException if the index is invalid
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }



    /**
     * This method returns an iterator that allows iterating over the elements in the array list.
     * The iterator starts from the first element and moves through the list sequentially.
     *
     * @return An iterator that provides access to each element in the list in sequence.
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();  // Необходимо добавление этого импорта
                }
                return (T) data[index++];
            }
        };
    }

}
