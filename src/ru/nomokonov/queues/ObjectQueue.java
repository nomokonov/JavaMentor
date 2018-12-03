package ru.nomokonov.queues;

public class ObjectQueue {
    //Первый объект
    private ObjectBox head = null;
    // последний  - хвост (Tail
    private ObjectBox tail = null;
    //Размер ( пок ол-ву объектов
     private int size = 0;


    public void push(Object object){
        ObjectBox objectBox = new ObjectBox();
        objectBox.setObject(object);

        if( head == null){
            head = objectBox;
        }else{
            if (tail == null){
                tail.setPrevious(head);
            }
            else{
                objectBox.setPrevious(tail);
            }
            tail.setNext(objectBox);
        }
        tail = objectBox;
        size++;
    }

    public Object pull(){
        if ( size == 0){
            return null;
        }
        Object object = tail.getObject();
        if (tail.getPrevious()==null){
            head =null;
            tail =null;
        } else{
            tail = tail.getPrevious();
        }
        size--;
        return  object;

    }

    public Object getIndex(int index){
        if (size ==0 || size < index || index < 0){
            return null;
        }
        int pos =0;
        ObjectBox current = head;
        while (pos != index){
            current = current.getNext();
            pos++;
        }
        Object object = current.getObject();
        return object;
    }

    public int getSize() {
        return size;
    }

    public ObjectBox getHead() {
        return head;
    }

    public ObjectBox getTail() {
        return tail;
    }
}
