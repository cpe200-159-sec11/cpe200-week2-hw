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
        head = new PNode(i, null, tail);
       if (head==null) {
           tail = head;     //If nothing in list set head point to same data as tail
       }
        else {
           tail.next.prev = tail; //new tail point prev to old tail
       }
       size++; //increase size
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
        char i=tail.data; //set char i contain tail data
        PNode tmp = tail; //set tmp Node point at tail
        if(head==tail) {
            tail = head = null; //if have only one node set both head and tail point to null
        }
        else {
            tail = tail.prev;
            tail.next = null;   //move tail pointer point to prev tail
            tmp.prev = null;    //delete tail
        }
        size--; //decrease size
        return i; //return the value of deleted tail
    }

    public boolean search(char i) {
        PNode tmp = head; //set tmp point to data as head point to
        if(head == null && tail == null)
        {
            return false;       //if nothing in the list
        }
        while(tmp != null)
        {
            if(tmp.data==i) {
                return true;    //if data in tmp node equal to i return true
            }
            else {
                tmp = tmp.next; //if not move to next node
            }
        }
        return false; //if end of the loop but still didnt find return false
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data); //print data that tmp point to
            tmp = tmp.next; //move tmp to next node
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail; //set tmp point to data that tail point to
        while (tmp != null) {
            System.out.print(tmp.data);  //print data that tmp point to
            tmp = tmp.prev; //move tmp previous
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
