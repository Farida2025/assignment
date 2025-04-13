import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        MyNode newNode = new MyNode(item);
        MyNode current = getNode(index);
        MyNode prev = current.prev;
        if (prev != null) {
            prev.next = newNode;
        } else {
            head = newNode;
        }
        newNode.prev = prev;
        newNode.next = current;
        current.prev = newNode;
        size++;
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        return head != null ? head.data : null;
    }

    @Override
    public T getLast() {
        return tail != null ? tail.data : null;
    }

    @Override
    public void remove(int index) {
        MyNode node = getNode(index);
        MyNode prev = node.prev;
        MyNode next = node.next;
        if (prev != null) {
            prev.next = next;
        } else {
            head = next;
        }
        if (next != null) {
            next.prev = prev;
        } else {
            tail = prev;
        }
        size--;
    }

    @Override
    public void removeFirst() {
        if (head != null) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
        }
    }

    @Override
    public void removeLast() {
        if (tail != null) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            size--;
        }
    }

    @Override
    public void sort() {
        // Реализовать сортировку для связанного списка
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (MyNode node = head; node != null; node = node.next, index++) {
            if (node.data.equals(object)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        for (MyNode node = tail; node != null; node = node.prev, index--) {
            if (node.data.equals(object)) {
                return index;
            }
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
        int index = 0;
        for (MyNode node = head; node != null; node = node.next) {
            result[index++] = node.data;
        }
        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) current = current.next;
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) current = current.prev;
        }
        return current;
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

}
