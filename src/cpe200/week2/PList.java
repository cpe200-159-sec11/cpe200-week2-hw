package cpe200.week2;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(char i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(char i) {
        PNode ptr = new PNode(i, tail, null);
        if (tail == null) {
            tail = head;
        }
        else {
            tail.next = ptr;
            ptr.prev = tail;
            tail = ptr;
            tail.next = null;
        }
    }

    public char popHead() {
        char i=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return i;
    }

    public char popTail() {
        char el = head.data;
        PNode ptr = tail;
        if (head == tail) {
            head = tail = null;
        }
        else {
            tail = tail.prev;

        }
        size--;
        tail.next = null;
        return el;
    }

    public boolean search(char i) {
        PNode ptr = head;
        while (ptr != null) {
            if (ptr.data == i) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;

    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
