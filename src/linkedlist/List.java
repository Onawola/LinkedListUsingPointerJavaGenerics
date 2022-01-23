package linkedlist;

public class List<E> implements ListJava<E> {
    Component<E> front, last;

    List() {
        front = null;
        last = null;
    }

    List(E obj) {
        front = new Component(obj);
        last = front;
    }

    List(E[] listItems, int n) {
        if (n < 1) return;
        front = new Component(listItems[0]);
        int i = 1;
        last = front;
        for (Component ptr = front; i < n; i++, ptr = ptr.next)
            last = ptr.next = new Component(listItems[i]);
    }

    List(List lst) {
        if (lst.front == null) {
            front = null;
            return;
        }
        front = new Component(lst.front.data);
        last = front;
        for (Component it = lst.front.next; it != null; it = it.next) {
            last.next = new Component(it.data);
            last = last.next;
        }
    }

    @Override
    public boolean empty() {
        return front == null;
    }


    @Override
    public void appendObj(E obj) {
        Component temp = null;
        if (front == null) {
            front = new Component(obj);
            last = front;
        } else {
            temp = new Component(obj);
            last.next = temp;
            last = temp;
        }
    }

    @Override
    public void removeFront() {
        if (front != null) front = front.next;
    }

    @Override
    public E front() {
        if (front != null) return front.data;
        return null;
    }

    @Override
    public int listLength() {
        int len = 0;
        for (Component t = front; t != null; t = t.next) ++len;
        return len;
    }

    @Override
    public int locateObj(E obj) {
        int position = 0;
        for (Component t = front; t != null; t = t.next) {
            ++position;
            if (t.data.equals(obj)) break;
        }
        return position;
    }


    @Override
    public void deleteObj(E obj) {
        if (front == null) return;
        if (front.data.equals(obj)) {
            front = front.next;
            if (front == null) last = null;
            return;
        }
        Component ptr = null;
        for (ptr = front; ptr.next != null; ptr = ptr.next) if (ptr.next.data.equals(obj)) break;
        if (ptr.next != null) {
            ptr.next = ptr.next.next;
            if (ptr.next == null) last = ptr;
        }
    }


    @Override
    public void deleteObjAt(int position) {
        if (front == null) return;
        if (position == 1) {
            front = front.next;
            if (front == null) last = null;
            return;
        }
        Component ptr = null;
        --position;
        for (ptr = front; ptr.next != null && position > 1; ptr = ptr.next) --position;
        if (ptr.next != null) {
            ptr.next = ptr.next.next;
            if (ptr.next == null) last = ptr;
        }
    }

    @Override
    public boolean enlistObj(E obj, int position) {
        if (position == 1) {
            Component temp = new Component(obj);
            if (front != null) temp.next = front;
            else last = temp;
            front = temp;
            return true;
        }
        Component ptr = null;
        --position;
        for (ptr = front; ptr.next != null && position > 1; ptr = ptr.next) --position;
        if (ptr.next != null || position == 1) {
            Component temp = new Component(obj);
            temp.next = ptr.next;
            ptr.next = temp;
            if (temp.next == null) last = temp;
            return true;
        }
        return false;
    }

    @Override
    public void display() {
        for (Component t = front; t != null; t = t.next) System.out.print(t.data + " ");
    }
}
