package org.stepik.module_6.from_mentor;

public class LinkedList_v2<T> {
    private Part<T> first;
    private Part<T> last;
    private int size;

    //    Добавляем вслед за последним
    public void add(T element) {
        final Part<T> l = last;
        final Part<T> newNode = new Part<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
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

        public Part<T> getNext() {
            return next;
        }

        public void setNext(Part<T> next) {
            this.next = next;
        }

        public Part<T> getPrev() {
            return prev;
        }

        public void setPrev(Part<T> prev) {
            this.prev = prev;
        }
    }
}




