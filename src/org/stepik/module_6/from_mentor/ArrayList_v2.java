package org.stepik.module_6.from_mentor;

public class ArrayList_v2<T> {
    private int size = 0;
    private Object[] array_object;

    public ArrayList_v2(int size) {
        this.size = size;
        array_object = new Object[size];
    }

    public ArrayList_v2() {
        this(0);
    }

    public T get(int index) {
        return (T) array_object[index];
    }

    public void add(T obj) {
        Object[] new_arr = new Object[++size];
        if (size > 1) {
            System.arraycopy(array_object, 0, new_arr, 0, size - 1);
        }
        new_arr[size - 1] = obj;
        array_object = new_arr;
        new_arr = null;
    }

    public T remove(int index) {
        T oldValue = (T) array_object[index];
        int numMoved = size - index - 1;
        if (numMoved > 0){
            System.arraycopy(array_object, index+1, array_object, index,
                    numMoved);
            array_object[--size] = null;
        }
        return oldValue;
    }
}
