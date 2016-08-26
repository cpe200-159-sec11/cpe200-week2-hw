package cpe200.week2;

import javax.xml.soap.Node;

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
        PNode temp = new PNode(i, tail.next, tail);
        if (head == null)
        {
            head = new PNode(i, head, tail);
            tail = head;
        }
        else
        {
            tail.next = temp;
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
        char i=tail.data;
        PNode tmp=tail;

        if(head==tail){
            head = tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            tmp.prev = null;
        }
        size--;

        return i;
    }

    public boolean search(char i) {
        PNode tmp = head;
        if (head != null)
        {
            char temp;
            if (head == tail && head.data == i)
            {
                return true;
            }
            else
            {
                while (true)
                {
                    if (tmp.data ==i)
                    {
                        return true;
                    }
                    else
                    {
                        if (tmp == tail)
                        {
                            return false;
                        }
                        tmp = tmp.next;
                    }
                }
            }

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
        PNode tmp=tail;

        while (tmp!=null){
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
