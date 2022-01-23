package linkedlist;

public class Component<E> {
    E data;
    Component<E> next;

    Component() {
        data = null;
        next = null;
    }

    Component(E dataItem) {
        data = dataItem;
        next = null;
    }

    Component<E> nextComponent() {
        return next;
    }

    E data() {
        return data;
    }
}