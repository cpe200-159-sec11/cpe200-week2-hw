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
        PNode tmp = new PNode(i, null, tail);
        if(tail == null){
            tail = head;
        }
        tail.next = tmp;
        tail = tmp;
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
        char i = tail.data;
        PNode tmp = tail; // createe tmp = last node
        if (tail.prev == null) { // check empty
            return 0;
        }
        else
            tail = tmp.prev; // point tail to new last node
        tail.next = null;  // set last node = null
        size--;
        return i;

    }

    public boolean search(char i) {
        // implement your code here
        PNode temp = tail;
        while (temp != null) {
            if (temp.data == i) { // if data == input return ture
                return true;
            }
            temp = temp.prev; // move list
        }
        return false;
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        if (head == tail)
        {
            System.out.print(head.data);
        }
        else {
            PNode tmp = head;
            while (tmp != null) {
                // implement your code here
                System.out.print(tmp.data);
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    public void printBackward() {
        // implement your code here
        if (tail == head)
        {
            System.out.print(tail.data);
        }
        else {
            PNode tmp = tail;
            while (tmp != null) {
                // implement your code here
                System.out.print(tmp.data);
                tmp = tmp.prev;
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }
    private PNode head, tail;
    private int size=0;
}
