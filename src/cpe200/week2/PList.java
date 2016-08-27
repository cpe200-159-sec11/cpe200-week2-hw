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
        // implement your code here
        tail = new PNode(i, null, tail);
        if (head==null)
            head = tail;
        else
            tail.next.prev = tail;
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
        }
        size--;
        return i;
    }

    public char popTail() {
        // implement your code here
        char i=tail.data;
        PNode tmp = tail;

        if (head==tail)
            head = tail = null;
        else {
            tail = tail.prev;
            tail.next = null;
            tmp.next = null;
        }
        size--;
        return i;
    }

    public boolean search(char i) {
        // implement your code here
        PNode tmp;
        for (tmp = head; tmp != null && (tmp.data!=i); tmp = tmp.next);
        return tmp!=null;
    }

    public boolean isEmpty() { return (head == null); }
        //if(head==null) return true; else return false;


    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            // implement your code here
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        // implement your code here
        PNode tmp = tail;

        while (tmp != null)
        {
            System.out.println(tmp.data);
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
