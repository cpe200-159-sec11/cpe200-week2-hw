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

        if (tail == null) {
            tail = new PNode(i,tail, null);
            head = tail;
        }
        else
        {
            PNode temp = new PNode(i, tail, null);
            tail.next = temp;
            temp.prev = tail;
            tail = temp;

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

        char el = tail.data;
        PNode tmp = tail;
        if (head == tail)
        {
            head = tail = null;
        }
        else
        {
            tail = tmp.prev;
            tail.next = null;
        }
        size--;
        return el;
    }

    public boolean search(char i) {

        PNode temp;
        temp = head;
        if (temp.data == i) {
            popHead();
            return true;
        }
        while (temp.next != null) {
            temp = temp.next;
            if (temp.data == i) {
                return true;
            }
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
        while (tmp != null){
            System.out.print(tmp.data);
            tmp = tmp.prev;
        }
        System.out.print(tmp);
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
