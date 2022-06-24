import java.util.Collection;

public class MyList<T> {
    private final int defaultCapacity = 2;
    private Object[] array;
    private int size = 0;

    public MyList() {
        array = new Object[defaultCapacity];
    }

    public MyList(int capacity) {
        array = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        checkArrayLengthSize();
        array[size++] = element;
    }

    public void add(int index, T element) {
        checkArrayLengthSize();
        checkIndex(index);

        if (size > 0) {
            for (int i = size; i >= index; i--) {
                array[i] = array[i - 1];
            }
        }

        array[index] = element;
        size++;
    }

    public void clear() {
        array = new Object[defaultCapacity];
        size = 0;
    }

    public void set(int index, T element) {
        array[index] = element;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T element) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(T element) {
        for (int i = indexOf(element); i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public boolean containsAll(Collection<? extends T> collection) {
        for (T element : collection) {
            if (!contains(element))
                return false;
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }

        for (Object i : array) {
            if (i.equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void checkArrayLengthSize() {
        if (size == array.length) {
            createNewArray();
        }
    }

    private void createNewArray() {
        Object[] newArray = new Object[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >=size)
            throw new IndexOutOfBoundsException();
    }

    @Override

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]).append(" ");
        }
        return sb.toString().trim();
    }

}
