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
        PNode tmp = head;
        if (head == null) {
            pushToHead(i);
        }
        else {
            tmp = tail;
            tail = new PNode(i, null, tmp);
            tmp.next = tail;
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
        if (head != null && tail != null) {
            PNode tmp = tail;
            char el = tail.data;
            if (head == tail)
            {
                head = tail = null;
            }
            else {
                tail = tail.prev;
                tail.next = null;
            }
            tmp.next = null;
            size--;
            return el;
        }
        else {
            return 0;
        }

    }

    public boolean search(char i) {
        PNode tmp = head;
        if (head != null) {
            while ((tmp.data != i) && (tmp.next != null)) { //Search and compare
                tmp = tmp.next;
            }
            if (tmp.data == i) {
                return true;
            }
            else {
                return false;
            }
        }
        else if(head == null){
            return false;
        }
        else {
            return false;
        }
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
