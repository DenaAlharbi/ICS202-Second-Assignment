public class SLL<T> {
    private SNode<T> head;
    private SNode<T> tail;
    private final SNode<T> dummy;

    public SLL() {
        dummy = new SNode<>(null);
        head =tail= dummy; // even though the dummy will always serve as a head regardless of specifying that or not
    }

    public boolean isEmpty() { // completed
        return dummy.next == null;
    }

    public void addToHead(T el) { //completed
        if (dummy.next != null) {
            SNode<T> tmp = dummy.next;
            dummy.next = new SNode<T>(el);
            dummy.next.next = tmp;
        } else
            head.next = new SNode<T>(el); //here dummy and head mean the same node
    }

    public void addToTail(T el) {
        if (tail != null) {
            tail = new SNode<T>(el, null, tail);
            tail.prev.next = tail;
        } else head = tail = new SNode<T>(el);
    }

    public T deleteFromHead() {
        if (isEmpty())
            return null;
        T el = head.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            head = head.next;
            head.prev = null;
        }
        return el;
    }

    public T deleteFromTail() {
        if (isEmpty())
            return null;
        T el = tail.info;
        if (head == tail)   // if only one node on the list;
            head = tail = null;
        else {              // if more than one node in the list;
            tail = tail.prev;
            tail.next = null;
        }
        return el;
    }
    public T search(T element){ //Completed probably
        if (isEmpty())
            return null;
        else{
            SNode<T> tmp; // it is here and not in the for loop statement so that the if statement after it can access the variable
            for (tmp = head.next; tmp != null && !tmp.info.equals(element);){
                tmp = tmp.next;
            }
            if (tmp == null)
                return null;
            else return tmp.info;
        }
    }

    public void printAll() {
        for (SNode<T> tmp = head; tmp != null; tmp = tmp.next)
            System.out.print(tmp.info + " ");
        System.out.println();
    }



    public void printReverse() {
        SNode<T> p = tail;
        while (p != null) {
            System.out.print(p.info + " ");
            p = p.prev;
        }
    }
}