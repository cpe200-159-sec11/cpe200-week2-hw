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
        PNode temp = new PNode(i, null, null);
        if (tail == null) {
            tail = head;
        }
        else if (tail == head) {
            head.next = temp;
            tail = temp;
            temp.prev = head;
        }
        else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        size++;
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
            size--;
        }
        return i;
    }

    public char popTail() {
        char x = tail.data;
        PNode temp = tail;
        if (head == tail) {
            size--;
        }
        else {
            tail = temp.prev;
            size--;
        }
        return x;
    }

    public boolean search(char i) {
        PNode temp = head;
        while (temp != null ) {
            if (i == temp.data ) {
                return true;
            }
            temp = temp.next;

        }
        return false;
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.print(tmp.data);
            tmp=tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;
        while (tmp != null) {
            System.out.print(tmp.data);
            tmp=tmp.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}