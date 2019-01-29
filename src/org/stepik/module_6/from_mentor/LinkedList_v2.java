package org.stepik.module_6.from_mentor;

public class LinkedList_v2<T> {
    private Part<T> first;
    private Part<T> last;
    private int size;

    //    Добавляем вслед за последним
    public void add(T element) {
        Part<T> l = last;
        Part<T> newElement = new Part<>(l, element, null);
        last = newElement;
        if (l == null)
            first = newElement;
        else
            l.next = newElement;
        size++;
    }

    public T get(int index) {
        Part<T> element = first;
        int  count = 0;
        if ( index < 0 || size < index  ){
            return null;
        }
        while ( count != index){
            element = element.next;
            count++;
        }
        return  element.element;
    }

    public void remove(int index){
        Part<T> element = first;
        int count = 0;
        while ( count != index){
            element = element.next;
            count++;
        }
        element.next.prev = element.prev;
        element.prev.next = element.next;
        element = null;
        size--;
    }

    public int size(){
        return size;
    }


    private static class Part<T> {
        T element;
        Part<T> next;
        Part<T> prev;

        Part(Part<T> prev, T element, Part<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

}






