package com.codecool.linkedlist;


public class SinglyLinkedList<T> {

    private class Link {
        private T value;
        private Link next;

        Link(T value) {
            this.value = value;
        }

        T getValue() {
            return value;
        }

        Link getNext() {
            return next;
        }

        void setNext(Link next) {
            this.next = next;
        }
    }


    private Link head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public SinglyLinkedList(T value) {
        head = new Link(value);
        size = 1;
    }

    public void add(T value) {
        if (head == null) {
            head = new Link(value);
        } else {
            Link last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(new Link(value));
        }
        size++;
    }


    public T get(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        } else {
            Link pointed = head;
            int pointer = 0;
            while (pointer != index) {
                pointed = pointed.getNext();
                pointer++;
            }
            return pointed.getValue();
        }
    }

    public int indexOf(T number) {
        Link pointed = head;
        int pointer = 0;
        if (pointed == null) return -1;
        while (pointed!= null){
            if(pointed.getValue().equals(number)){
                return pointer;
            }
            pointed = pointed.getNext();
            pointer++;
        }
        return -1;
    }

    public void insert(int index, T number) {
        if (index<0 || index>size) throw new IndexOutOfBoundsException();
        if (index==size) {add(number);
        }else {
            size++;
            Link newLink = new Link(number);
            Link pointed = head;
            if (index==0) {
                newLink.setNext(head);
                head = newLink;
            } else {
                Link tail = null;
                for (int pointer = 0; pointer < size; pointer++) {
                    if (pointer != index-1) {
                        pointed = pointed.getNext();
                    } else {
                        newLink.setNext(pointed.getNext());
                        pointed.setNext(newLink);
                        pointed = pointed.getNext();
                    }
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else {
                head = head.getNext();
            }
            return;
        }
        Link elementBeforeIndex = head;
        while (index - 1 > 0) {
            elementBeforeIndex = elementBeforeIndex.getNext();
            index--;
            if (elementBeforeIndex == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        Link elementAtIndex = elementBeforeIndex.getNext();
        if (elementAtIndex == null) {
            throw new IndexOutOfBoundsException();
        }
        elementBeforeIndex.setNext(elementAtIndex.getNext());
    }

    @Override
    public String toString(){
        String enumeration = "[";
        for (int i = 0; i < size-1; i++) {
            enumeration += get(i);
            enumeration += ", ";
        }
        enumeration += get(size-1);
        enumeration +="]";
        return enumeration;
    }
}
