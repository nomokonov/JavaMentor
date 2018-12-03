package ru.nomokonov.queues;

public class ObjectBox {
    private Object object;
    private ObjectBox next;
    private ObjectBox previous;

    public ObjectBox getPrevious() {
        return previous;
    }

    public void setPrevious(ObjectBox previous) {
        this.previous = previous;
    }

    public ObjectBox getNext() {
        return next;
    }

    public void setNext(ObjectBox next) {
        this.next = next;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
