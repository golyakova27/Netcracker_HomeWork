package linkedList;
import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> head;
    private int length = 0;
    private Node<E> tail;

    public boolean isEmpty() {

        return head == null;
    }

    public void add(E element) {

        Node<E> node = new Node<>(element, null);

        if (isEmpty()) {

            head = node;
            tail = node;
        }
        else {
            tail.setNext(node);
            tail = node;
        }

        length++;
    }

    public void add(int index, E element) {

        Node<E> node = new Node<>(element, null);
        Node<E> p = head;

        if (index < length && index > -1) {
                for (int i = 0; i != index; i++) {
                    p = p.getNext();
                }
        }
        else {
            add(element);
        }

        length++;
    }

    public void clear() {
        while (!isEmpty()) {
            remove(0);
        }
        length = 0;
    }

    public E get(int index) {

        if (index > length - 1 || index < 0) {
            System.out.println("Index out of list size");
        }
        else {
            Node<E> p = head;

            for (int i = 0; i != index; i++) {
                p = p.getNext();
            }

            return p.getElement();
        }

        return null;
    }

    public int indexOf(E element) {

        Node<E> p = head;
        int index = 0;

        for (index = 0; index < length; index++) {
            if (p.getElement().equals(element)) {
                return index;
            }
            p = p.getNext();
        }

        return index;
    }

    public E remove(int index) {

        E element = null;

        if(index < length - 1 && index > 0) {

            Node<E> p = head;

            for (int i = 0; i < length; i++) {

                if (i + 1 == index) {
                    element = p.getNext().getElement();
                    p.setNext(p.getNext().getNext());

                    break;
                }

                p = p.getNext();
            }
            length--;
        }

        else if (index == 0) {

            element = head.getElement();
            head = head.getNext();
            length--;
        }

        else if (index == length - 1) {

            Node<E> p = head;
            element = tail.getElement();
            for (int i = 0; i != length - 2; i++) {
                p = p.getNext();
            }

            p.setNext(null);
            tail = p;

            length--;
        }

        return element;
    }

    public E set(int index, E element) {

        Node<E> p = head;
        E result = null;

        if (index > -1 && index < length) {

            for (int i = 0; i < length; i++) {

                if (i == index) {

                    result = p.getElement();
                    p.setElement(element);
                }
                p = p.getNext();
            }
        }
        return result;
    }

    public int size() {
        return length;
    }


    public E[] toArray() {

        Node<E> p = head;

        E[] array = (E[]) new Object[length];

        for (int i = 0; i < length; i++) {
            array[i] = p.getElement();
            p = p.getNext();
        }

        return array;
    }

    public String toString() {

        StringBuilder str = new StringBuilder("[");

        for (E e : this) {
            str.append(e).append(" ");
        }

        return str + "]";
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {

                E element = node.getElement();

                if (hasNext()) {
                    node = node.getNext();
                }

                return element;
            }
        };
    }
}
