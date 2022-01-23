package linkedlist;

public interface ListJava<E> {
    boolean empty();

    void appendObj(E obj);

    void removeFront();

    E front();

    int listLength();

    int locateObj(E obj);

    void deleteObj(E obj);

    void deleteObjAt(int position);

    boolean enlistObj(E obj, int position);

    void display();
}